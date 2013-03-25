package org.injustice.powerchopper.strat;

/**
 * Created with IntelliJ IDEA.
 * User: Injustice
 * Date: 17/03/13
 * Time: 16:24
 * To change this template use File | Settings | File Templates.
 */

import org.injustice.powerchopper.util.Utilities;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.wrappers.node.Item;
import org.powerbot.game.api.wrappers.node.SceneObject;
import sk.action.ActionBar;
import sk.action.ActionSlotType;

import static org.injustice.powerchopper.util.Variables.*;


public class ActionChop extends Node {

    @Override
    public boolean activate() {
        return guiDone && actionDrop && !doBonfires && !normalChop;
    }

    @Override
    public void execute() {
        Item[] items = Inventory.getItems(new Filter<Item>() {
            @Override
            public boolean accept(Item i) {
                return i.getId() == log;
            }
        });
        if (Inventory.contains(log)) {
            if (items != null) {
                if (ActionBar.getSlotType(0) == ActionSlotType.ITEM) {
                    if (ActionBar.isExpanded()) {
                        status = "[ACTIONBAR] Checking";
                        if (ActionBar.isReadyForInteract()) {
                            status = "[ACTIONBAR] Dropping " + chopping;
                            while (Inventory.contains(log)) {
                                ActionBar.interactSlot(0, "Drop");
                                sleep(700, 750);
                            }
                        } else {
                            ActionBar.makeReadyForInteract();
                            status = "[ACTIONBAR] Readying";
                        }
                    } else {
                        ActionBar.setExpanded(true);
                        status = "[ACTIONBAR] Readying";
                    }

                } else {
                    ActionBar.dragToSlot(items[0], 0);
                    status = "[ACTIONBAR] Dragging";
                }
            }
        }
        sleep(1000);


        SceneObject treeToCut = SceneEntities.getNearest(tree);
        if (Players.getLocal().getAnimation() == -1) {
            if (!Players.getLocal().isMoving()) {
                if (Players.getLocal().isIdle()) {
                    if (!Inventory.contains(log)) {
                        if (treeToCut != null) {
                            if (treeToCut.isOnScreen()) {
                                if (treeToCut.interact("Chop")) {
                                    status = "[CHOPPING] Interacting";
                                    sleep(1500, 2000);
                                    do {
                                        sleep(250);
                                        if (doAntiban) Utilities.antiban();
                                        status = "[CHOPPING] Sleeping";
                                    }
                                    while ((Players.getLocal().isMoving() || Players.getLocal()
                                            .getAnimation() != -1) && !Inventory.contains(log));
                                }
                            } else {
                                status = "[CHOPPING] Turning";
                                Camera.turnTo(treeToCut);
                            }
                        } else
                            sleep(250, 300);
                    }
                }
            } else sleep(250, 300);


            if (Widgets.get(640, 4).visible() && !actionBarDrop) {      // Abilitybar is visible
                ActionBar.setExpanded(false);
            }
        } else sleep(250, 300);
    }
}




