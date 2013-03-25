package org.injustice.powerchopper.util;

import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Time;

import java.awt.*;

import static org.injustice.powerchopper.util.Utilities.format;
import static org.injustice.powerchopper.util.Variables.*;

public class Paint {
    public static void onRepaint(Graphics g1) {
        if(!noPaint && guiDone) {
            if (!hidePaint) {
                Graphics2D g = (Graphics2D) g1;
                final Font subTextFont = new Font("Tahoma", 0, 11);
                final Color subTextColor = new Color(144, 174, 136);
                int expGained = Skills.getExperience(Skills.WOODCUTTING) - startExp;
                int level = Skills.getRealLevel(Skills.WOODCUTTING);
                int expToLevel = Skills.getExperienceToLevel(Skills.WOODCUTTING,
                        level + 1);
                int levelsGained = Skills.getLevel(Skills.WOODCUTTING) - startLevel;
                int expHour = (int) (expGained * 3600000d / runTime.getElapsed());
                int logsHour = (int) (logsCut * 3600000d / runTime.getElapsed());

                int FMexpGained = Skills.getExperience(Skills.FIREMAKING) - startFMexp;
                int FMlevel = Skills.getRealLevel(Skills.FIREMAKING);
                int FMexpToLevel = Skills.getExperienceToLevel(Skills.FIREMAKING, FMlevel + 1);
                int FMlevelsGained = Skills.getLevel(Skills.FIREMAKING) - startFMlevel;
                int FMexpHour = (int) (FMexpGained * 3600000d / runTime.getElapsed());
                int FMlogsHour = (int) (logsBurned * 3600000d / runTime.getElapsed());
                Color grey = new Color(0, 0, 0, 100);
                Color blue = new Color(10, 50, 255, 100);
                Color green = new Color(10, 255, 50, 100);

                g.setFont(subTextFont);
                g.setColor(subTextColor);
                if (sexyPaint) {
                    final Image paint = Utilities
                            .getImage("http://oi48.tinypic.com/2w5vskm.jpg");

                    g.drawImage(paint, 0, 310, null);
                    g.drawString("" + format(expGained, 2), 196, 485);
                    g.drawString("" + level + "(" + levelsGained + ")", 353, 485);
                    g.drawString("" + format(expToLevel, 2), 456, 485);
                    g.drawString("" + format(expHour, 2), 264, 485);
                    g.drawString("" + getTimeToNextLevel(Skills.WOODCUTTING, expHour), 396, 485);
                    g.drawString("" + format(logsHour, 2), 338, 443);
                    g.drawString("" + format(logsCut, 2), 277, 443);
                    g.drawString("" + status, 215, 515);
                    g.drawString("" + runTime.toElapsedString(), 375, 515);
                    g.drawString("1.0", 490, 515);
                } else if (simplePaint) {
                    BasicStroke stroke1 = new BasicStroke(1);
                    g.setStroke(stroke1);
                    Font font1 = new Font("Tahoma", 0, 15);
                    Font font2 = new Font("Tahoma", 0, 9);
                    Font font3 = new Font("Tahoma", 0, 11);
                    Point loc = new Point(10, 220);

                    g.setColor(grey);
                    g.fillRoundRect(5, 178, 190, 160, 7, 7);
                    g.setColor(Color.GREEN);
                    g.setStroke(stroke1);
                    g.drawRoundRect(5, 178, 190, 160, 7, 7);
                    g.drawRect(5, 178, 190, 21);
                    g.setFont(font1);

                    g.drawString("Injustice's Powerchopper", 8, 196);
                    g.setFont(font2);
                    g.drawString("v0.2", 173, 196);
                    g.setFont(font3);
                    if(showWCexp) {
                        if(doBonfires) {
                            g.setColor(grey);
                            g.fillRoundRect(6, 161, 186, 17, 5, 5);
                            g.setColor(Color.GREEN);
                            g.drawRoundRect(6, 161, 186, 17, 5, 5);
                            g.setFont(font1);
                            g.drawString("Show Firemaking exp", 27, 174);
                        }
                        g.setFont(font3);
                        g.drawString("Exp gain: " + format(expGained, 2), loc.x, loc.y);     // loc.x, loc.y
                        g.drawString("Exp PH: " + format(expHour, 2), loc.x + 90, loc.y);          // +90, loc.y
                        g.drawString("Exp TNL: " + format(expToLevel, 2), loc.x, loc.y + 15);       // loc.x, +15
                        g.drawString("Time TNL: " + getTimeToNextLevel(Skills.WOODCUTTING, expHour), loc.x + 89, loc.y + 15);         // +89, +15
                        g.drawString("Levels: " + levelsGained, loc.x + 90, loc.y + 30);     // + 90, +30
                        g.drawString("Start level: " + startLevel, loc.x, loc.y + 30);   // loc.x, +30
                        g.drawString("Logs cut: " + format(logsCut, 2), loc.x, loc.y + 45);         // loc.x, +45
                        g.drawString("Logs PH: " + format(logsHour, 2), loc.x + 90, loc.y + 45);        // +90, +45
                        if (pickNests) {
                            g.drawString("Nests: " + nestsPicked, 10, 278); // loc.x, +70
                        }
                        if (doAntiban)
                            g.drawString("Antibans: " + antibanCount, loc.x + 90, loc.y + 60);
                        g.drawString("Runtime: " + runTime.toElapsedString(), loc.x, loc.y + 70); // loc.x, +70
                        g.drawString("Status: " + status, loc.x, loc.y + 85);            // loc.x, + 85
                        percBar(false, 10, 315, 178, 13, getPercentToNextLevel(Skills.WOODCUTTING), green, blue, stroke1, g);
                        g.setColor(Color.BLACK);
                        g.drawString("" + getPercentToNextLevel(Skills.WOODCUTTING) + "% TNL ", 78, 325);
                    }
                    if(doBonfires) {
                        if (showFMexp) {
                            g.setFont(font1);
                            g.setColor(grey);
                            g.fillRoundRect(6, 161, 186, 17, 5, 5);
                            g.setColor(Color.GREEN);
                            g.drawRoundRect(6, 161, 186, 17, 5, 5);
                            g.setFont(font1);
                            g.drawString("Show Woodcutting exp", 21, 175);
                            g.setFont(font3);
                            g.drawString("Exp gain: " + format(FMexpGained, 2), loc.x, loc.y);     // loc.x, loc.y
                            g.drawString("Exp PH: " + format(FMexpHour, 2), loc.x + 90, loc.y);          // +90, loc.y
                            g.drawString("Exp TNL: " + format(FMexpToLevel, 2), loc.x, loc.y + 15);       // loc.x, +15
                            g.drawString("Time TNL: " + getTimeToNextLevel(Skills.WOODCUTTING, FMexpHour), loc.x + 89, loc.y + 15);         // +89, +15
                            g.drawString("Levels: " + FMlevelsGained, loc.x + 90, loc.y + 30);     // + 90, +30
                            g.drawString("Start level: " + startFMlevel, loc.x, loc.y + 30);   // loc.x, +30
                            g.drawString("Logs burned: " + format(logsBurned, 2), loc.x, loc.y + 45);         // loc.x, +45
                            g.drawString("Logs PH: " + format(FMlogsHour, 2), loc.x + 90, loc.y + 45);        // +90, +45
                            g.drawString("Runtime: " + runTime.toElapsedString(), loc.x, loc.y + 70); // loc.x, +70
                            g.drawString("Status: " + status, loc.x, loc.y + 85);            // loc.x, + 85
                            percBar(false, 10, 315, 178, 13, getPercentToNextLevel(Skills.FIREMAKING), green, blue, stroke1, g);
                            g.setColor(Color.BLACK);
                            g.drawString("" + getPercentToNextLevel(Skills.FIREMAKING) + "% TNL ", 78, 325);
                            if (doAntiban) {
                                g.drawString("Antibans: " + antibanCount, loc.x + 90, loc.y + 60);
                                g.setColor(Color.GREEN);
                            }
                        }
                    }


                }
                if (!noMouse)
                    drawMouse(g);
            }
        }
    }



    private static void drawMouse(Graphics g1) {
        ((Graphics2D) g1).setRenderingHints(new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));
        Point p = Mouse.getLocation();
        Color[] gradient = new Color[]{new Color(255, 0, 0),
                new Color(255, 0, 255), new Color(0, 0, 255),
                new Color(0, 255, 255), new Color(0, 255, 0),
                new Color(255, 255, 0), new Color(255, 0, 0)};
        Color outerCircle = gradient[0];
        Color innerCircle = Color.white;
        g1.setColor(gradient[0]);
        int circleRadius = 7;
        int circleDiameter = circleRadius * 2;
        g1.drawLine(p.x + circleRadius, p.y, p.x + 2000, p.y);
        g1.drawLine(p.x - 2000, p.y, p.x - circleRadius, p.y);
// Vertical
        g1.drawLine(p.x, p.y + circleRadius, p.x, p.y + 2000);
        g1.drawLine(p.x, p.y - 2000, p.x, p.y - circleRadius);
        for (int r = gradient.length - 1; r > 0; r--) {
            int steps = 200 / ((gradient.length - 1) * 2);
            for (int i = steps; i > 0; i--) {
                float ratio = (float) i / (float) steps;
                int red = (int) (gradient[r].getRed() * ratio + gradient[r - 1]
                        .getRed() * (1 - ratio));
                int green = (int) (gradient[r].getGreen() * ratio + gradient[r - 1]
                        .getGreen() * (1 - ratio));
                int blue = (int) (gradient[r].getBlue() * ratio + gradient[r - 1]
                        .getBlue() * (1 - ratio));
                Color stepColor = new Color(red, green, blue);
                g1.setColor(stepColor);
// Horizontal
                g1.drawLine(p.x + circleRadius, p.y, p.x
                        + ((i * 5) + (100 * r)), p.y);
                g1.drawLine(p.x - ((i * 5) + (100 * r)), p.y, p.x
                        - circleRadius, p.y);
// Vertical
                g1.drawLine(p.x, p.y + circleRadius, p.x, p.y
                        + ((i * 5) + (100 * r)));
                g1.drawLine(p.x, p.y - ((i * 5) + (100 * r)), p.x, p.y
                        - circleRadius);
            }
        }
        g1.setColor(outerCircle);
        final long mpt = System.currentTimeMillis() - Mouse.getPressTime();
        if (Mouse.getPressTime() == -1 || mpt >= 200) {
            g1.drawOval(p.x - circleRadius / 3, p.y - circleRadius / 3,
                    circleDiameter / 3, circleDiameter / 3);
        }
        if (mpt < 200) {
            g1.drawLine(p.x - circleRadius, p.y + circleRadius, p.x
                    + circleRadius, p.y - circleRadius);
            g1.drawLine(p.x - circleRadius, p.y - circleRadius, p.x
                    + circleRadius, p.y + circleRadius);
        }
        g1.setColor(outerCircle);
        g1.drawOval(p.x - circleRadius, p.y - circleRadius, circleDiameter,
                circleDiameter);
    }
    // Tahoma, 11, 90ae88 colour subtext (144, 174, 136)





    public static void percBar(boolean vertical, int x, int y, int width, int height, double percentage, Color PercCol, Color outC, Stroke outS, Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        g.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        int drawPercentage = (int) (((percentage > 100 ? 100 : percentage) / 100) * width);
        g.setColor(PercCol);
        if (!vertical)
            g.fillRect(x, y, (width > height ? drawPercentage : width), (height >= width ? drawPercentage : height));
        else {
            int x1 = (width > height ? width - drawPercentage : 0);
            int y1 = (height > width ? height - drawPercentage : 0);
            g.fillRect(x + x1, y + y1, width - x1, height - y1);
        }
        g.setColor(outC);
        g.setStroke(outS);
        g.drawRect(x, y, width, height);

    }

    public static int getPercentToNextLevel(final int index) {
        final int lvl = Skills.getRealLevel(index);
        return getPercentToLevel(index, lvl + 1);
    }

    public static int getPercentToLevel(final int index, final int endLvl) {
        final int lvl = Skills.getRealLevel(index);
        if (lvl == 99) {
            return 0;
        }
        final int xpNeeded = Skills.XP_TABLE[endLvl] - Skills.XP_TABLE[lvl];
        if (xpNeeded == 0) {
            return 0;
        }
        final int xpDone = Skills.getExperience(index)
                - Skills.XP_TABLE[lvl];
        return 100 * xpDone / xpNeeded;


    }

    public static String getTimeToNextLevel(final int skill, final int xpPerHour) {
        if (xpPerHour < 1) {
            return Time.format(0L);
        }
        return Time.format((long)
                (Skills.getExperienceToLevel(skill, Skills.getLevel(skill) + 1) * 3600000D / xpPerHour));
    }
}
