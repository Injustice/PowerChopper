package org.injustice.powerchopper.util;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.util.Random;
import org.powerbot.game.api.methods.Environment;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.injustice.powerchopper.util.Variables.*;

public class Utilities {
    static Timer t = new Timer(6000);

    public static String format(long number, int precision) {
		String sign = number < 0 ? "-" : "";
		number = Math.abs(number);
		if (number < 1000) {
			return sign + number;
		}
		int exponent = (int) (Math.log(number) / Math.log(1000));
		return String.format("%s%." + precision + "f%s", sign,
				number / Math.pow(1000, exponent),
				"kmbtpe".charAt(exponent - 1));
	}

    public static void savePaint(final int x, final int y, final int w, final int h) {
        if (!t.isRunning()) {
            t.reset();
            final File path = new File(Environment.getStorageDirectory().getPath(), System.currentTimeMillis() + ".png");
            final BufferedImage img = Environment.captureScreen().getSubimage(x, y, w, h);
            try {
                ImageIO.write(img, "png", path);
                status = "Saving screenshot";
            } catch (Exception e) {
                e.printStackTrace();
                status = "Failed screenshot";
            }
        }
    }

	public static Image getImage(String url) {
		try {
			return ImageIO.read(new URL(url));
		} catch (IOException e) {
			return null;
		}
	}

    public static boolean waitForWidget(final WidgetChild widget) {
        return waitForCondition(new Condition() {
            @Override
            public boolean validate() {
                return widget.isOnScreen();
            }
        }, 5000);
    }

    public static boolean waitForCondition(Condition c, int timeout) {
        Timer t = new Timer(timeout);
        boolean validated;
        while (!(validated = c.validate()) && t.isRunning()) {
            Task.sleep(10);
        }
        return validated;
    }

    public static void antiban() {
        switch (Random.nextInt(0, (500 - antibanPercent))) {
            case 1:
                status = "[ANTIBAN] Moving camera";
                moveCamera();
                antibanCount++;
                break;
            case 2:
                status = "[ANTIBAN] Moving mouse";
                moveMouse((Random.nextInt(000, 500)), Random.nextInt(0, 500));
                antibanCount++;
                break;
            case 4:
                status = "[ANTIBAN] Moving mouse";
                Mouse.setSpeed(Mouse.Speed.SLOW);
                Point p = Mouse.getLocation();
                moveMouse(Random.nextInt(0, 50), Random.nextInt(10, 50));
                Mouse.move(p.x + (Random.nextInt(-50, 50)), p.y + (Random.nextInt(-50, 50)));
                Mouse.setSpeed(Mouse.Speed.NORMAL);
                antibanCount++;
                break;
            case 5:
                status = "[ANTIBAN] Moving randomly";
                moveMouseRandomly(Random.nextInt(0, 49), Random.nextInt(50, 100));
                antibanCount++;
                break;
            default:
                break;
        }
    }

    public static void moveCamera() {
        Camera.setPitch(Random.nextInt(0, 80));
        Camera.setAngle(Random.nextInt(0, 360));
    }

    public static void moveMouse(int x, int y) {
        Mouse.move(Random.nextInt(20 + x, 640 - y), Random.nextInt(20 + y, 470 - x));

    }


    /**
     * Author - Enfilade Moves the mouse a random distance between minDistance
     * and maxDistance from the current position of the mouse by generating
     * random vector and then multiplying it by a random number between
     * minDistance and maxDistance. The maximum distance is cut short if the
     * mouse would go off screen in the direction it chose.
     *
     * @param minDistance The minimum distance the cursor will move
     * @param maxDistance The maximum distance the cursor will move (exclusive)
     */
    public static void moveMouseRandomly(int minDistance, int maxDistance) {
        double xVector = Math.random();
        if (Random.nextInt(0, 2) == 1) {
            xVector = -xVector;
        }
        double yVector = Math.sqrt(1 - xVector * xVector);
        if (Random.nextInt(0, 2) == 1) {
            yVector = -yVector;
        }
        double distance = maxDistance;
        Point p = Mouse.getLocation();
        int maxX = (int) Math.round(xVector * distance + p.x);
        distance -= Math.abs((maxX - Math.max(0,
                Math.min(Game.getDimensions().getWidth(), maxX)))
                / xVector);
        int maxY = (int) Math.round(yVector * distance + p.y);
        distance -= Math.abs((maxY - Math.max(0,
                Math.min(Game.getDimensions().getHeight(), maxY)))
                / yVector);
        if (distance < minDistance) {
            return;
        }
        distance = Random.nextInt(minDistance, (int) distance);
        Mouse.move((int) (xVector * distance) + p.x, (int) (yVector * distance) + p.y);
    }
}
