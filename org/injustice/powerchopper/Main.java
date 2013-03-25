package org.injustice.powerchopper;

import org.injustice.powerchopper.strat.*;
import org.injustice.powerchopper.util.Failsafe;
import org.injustice.powerchopper.util.GUI;
import org.injustice.powerchopper.util.Paint;
import org.powerbot.core.event.events.MessageEvent;
import org.powerbot.core.event.listeners.MessageListener;
import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.Job;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.job.state.Tree;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Random;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.injustice.powerchopper.util.Utilities.savePaint;
import static org.injustice.powerchopper.util.Variables.*;

@Manifest(authors = {"Bartsome/Injustice"}, name = "Injustice's Powerchopper", description = "Powerchops all trees", version = this.version)
public class Main extends ActiveScript implements PaintListener, MessageListener, MouseListener {
    final double version = 0.3;

    private final List<Node> jobsCollection = Collections
            .synchronizedList(new ArrayList<Node>());
    private Tree jobContainer = null;

    public final void provide(final Node... jobs) {
        for (final Node job : jobs) {
            if (!jobsCollection.contains(job)) {
                jobsCollection.add(job);
            }
        }
        jobContainer = new Tree(jobsCollection.toArray(new Node[jobsCollection
                .size()]));
    }

    public final void submit(final Job job) {
        getContainer().submit(job);
    }

    public void onStart() {
        provide(new ActionChop(), new Chop(), new Drop(), new PickNests(), new AddLogs());
        startExp = Skills.getExperience(Skills.WOODCUTTING);
        startLevel = Skills.getRealLevel(Skills.WOODCUTTING);
        startFMexp = Skills.getExperience(Skills.FIREMAKING);
        startFMlevel = Skills.getRealLevel((Skills.FIREMAKING));
        startInventCount = Inventory.getCount();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                status = "In setup";
                try {
                    GUI frame = new GUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void onStop() {
        if (doScreenshots) {
            if (sexyPaint) {
                status = "[STOPPING] Saving screenshot";
                savePaint(0, 310, 519, 220);
            }
            if (doBonfires && simplePaint) {
                savePaint(5, 178, 190, 160);
                if (showFMexp && !showWCexp) {
                    showWCexp = true;
                    savePaint(5, 178, 190, 160);
                } else if (showWCexp && !showFMexp) showFMexp = true;
                if (simplePaint) savePaint(5, 178, 190, 160);
            } else if (simplePaint) savePaint(5, 178, 190, 160);
        }
    }


    @Override
    public int loop() {
        if (jobContainer != null) {
            final Node job = jobContainer.state();
//            if (sexyPaint) savePaint(0, 310, 519, 220);
//            if (simplePaint) savePaint(5, 178, 190, 160);
            if (job != null) {
                jobContainer.set(job);
                getContainer().submit(job);
                job.join();
            }
            if (Failsafe.run()) {
                status = "Failsafe, shutdown";
                System.out.println("Failsafe shutdown");
                Game.logout(true);
                this.shutdown();
            }
        }
        return Random.nextInt(10, 50);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!noPaint) {
            if (sexyPaint) {
                Rectangle close = new Rectangle(8, 398, 503, 125);
                Rectangle open = new Rectangle(8, 398, 503, 125);
                Point p = e.getPoint();
                if (close.contains(p) && !hidePaint) {
                    hidePaint = true;
                } else if (open.contains(p) && hidePaint) {
                    hidePaint = false;
                }
            } else if (simplePaint) {
                Rectangle close = new Rectangle(5, 178, 190, 160);
                Rectangle open = new Rectangle(5, 178, 190, 160);
                Rectangle FM = new Rectangle(6, 161, 186, 17);
                Rectangle WC = new Rectangle(6, 161, 186, 17);
                Point p = e.getPoint();
                if (close.contains(p) && !hidePaint) {
                    hidePaint = true;
                } else if (open.contains(p) && hidePaint) {
                    hidePaint = false;
                }
                if (doBonfires && FM.contains(p) && showWCexp) {
                    showFMexp = true;
                    showWCexp = false;
                } else if (doBonfires && WC.contains(p) && showFMexp) {
                    showWCexp = true;
                    showFMexp = false;
                }
            }

        }

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void messageReceived(MessageEvent m) {
        String s = m.getMessage();
        if (s.contains("You get")) {
            logsCut++;
        }
        if (m.getMessage().contains("nest falls out") && pickNests) {
            nestExists = true;
        }
        if (m.getMessage().contains("The fire catches") && doBonfires) {
            logsBurned++;
        }
        if (m.getMessage().contains("You add a log") && doBonfires) {
            logsBurned++;
        }
    }

    @Override
    public void onRepaint(Graphics g) {
        Paint.onRepaint(g);
    }
}
