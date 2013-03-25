package org.injustice.powerchopper.strat;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.node.GroundItems;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.Item;

import static org.injustice.powerchopper.util.Variables.*;

public class PickNests extends Node {
    public boolean activate() {
        return nestExists && NESTS != null;
    }

    public void execute() {
        if(!Inventory.isFull()) {
            status = "[NEST] Taking";
            sleep(2000, 3000);
            GroundItems.getNearest(NESTS).interact("Take");
            sleep(500, 1000);
        } else {
            if (Inventory.contains(log)) {
                Item logs = Inventory.getItem(log);
                if (logs.getWidgetChild().interact("Drop")) {
                    status = "[NEST] Inventory full";
                }
            } else
                nestExists = false;
        }
    }


}