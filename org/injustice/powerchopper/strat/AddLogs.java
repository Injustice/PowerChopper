package org.injustice.powerchopper.strat;

import org.injustice.powerchopper.util.Utilities;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.methods.Players;
import org.powerbot.core.script.util.Random;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.wrappers.node.Item;
import org.powerbot.game.api.wrappers.node.SceneObject;
import org.powerbot.game.api.wrappers.widget.Widget;
import sk.action.ActionBar;
import sk.action.ActionSlotType;

import java.awt.*;

import static org.injustice.powerchopper.util.Utilities.waitForWidget;
import static org.injustice.powerchopper.util.Variables.*;

public class AddLogs extends Node {
    public boolean activate() {
        return Inventory.isFull() && doBonfires;
    }

    public void execute() {
        Inventory.getItem(log).getWidgetChild().interact("Light");
        status = "[BONFIRE] Lighting log";
        do sleep(1000);
        while (Players.getLocal().getAnimation() == 16700);

        ActionBar.interactSlot(0, "Craft");
        Item[] items = Inventory.getItems(new Filter<Item>() {
            @Override
            public boolean accept(Item i) {
                return i.getId() == log;
            }
        });
        if (items != null) {
            if (ActionBar.getSlotType(0) == ActionSlotType.ITEM) {
                if (ActionBar.isExpanded()) {
                    status = "[ACTIONBAR] Checking";
                    if (ActionBar.isReadyForInteract()) {
                        status = "[ACTIONBAR] Clicking";
                        ActionBar.interactSlot(0, "Craft");
                        status = "[ACTIONBAR] Sleeping";
                        Widget wc = new Widget(1179);
                        waitForWidget(wc.getChild(0));
                        sleep(500);
                        while (!wc.getChild(0).isOnScreen()) {
                            sleep(500);
                        }
                        status = "[BONFIRE] Clicking";
                        Point p = Widgets.get(1179, 38).getCentralPoint();
                        Mouse.move(p.x + (Random.nextInt(5, 10)), p.y + Random.nextInt(20, 60));
                        Mouse.click(true);
                        status = "[BONFIRE] Clicked";
                        sleep(3000);
                        SceneObject fire = SceneEntities
                                .getNearest(BONFIRES_ID);
                        while (fire.validate() && Inventory.getCount(log) != 0) {
                            sleep(500);
                            if (doAntiban) Utilities.antiban();
                            status = "[BONFIRE] sleeping";
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
}