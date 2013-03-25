package org.injustice.powerchopper.util;

import org.powerbot.game.api.methods.interactive.Players;

/**
 * Created with IntelliJ IDEA.
 * User: Injustice
 * Date: 24/03/13
 * Time: 20:13
 * To change this template use File | Settings | File Templates.
 */
public class Failsafe {
    private static long lastAction = 0;
    private static long timeOut = 180000;

    public static boolean run() {
        if (Players.getLocal().getAnimation() != -1) {
            lastAction = System.currentTimeMillis();
        }

        if (lastAction != 0 && System.currentTimeMillis() > lastAction + timeOut) {
            return true;
        }

        return false;
    }
}
