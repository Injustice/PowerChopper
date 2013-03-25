package org.injustice.powerchopper.util;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.injustice.powerchopper.util.Variables.*;
/*
 * Created by JFormDesigner on Sun Mar 24 10:49:05 GMT 2013
 */



/**
 * @author Injustice
 */
public class GUI extends JFrame {
    public GUI() {
        initComponents();
    }

    private void cbShowPaintActionPerformed(ActionEvent e) {
        if (cbShowPaint.isSelected()) {
            rbSexyPaint.setEnabled(true);
            rbSimplePaint.setEnabled(true);
        } else {
            rbSexyPaint.setEnabled(false);
            rbSimplePaint.setEnabled(false);
        }
    }

    private void cbAntibanActionPerformed(ActionEvent e) {
        if (cbAntiban.isSelected()) {
            jsAntiban.setEnabled(true);
        } else jsAntiban.setEnabled(false);
    }

    private void btnStartActionPerformed(ActionEvent e) {
        if (chopBox.getSelectedItem() != null) {
            status = "GUI complete";
            String choice = chopBox.getSelectedItem().toString();
            if (choice.equals("Normal")) {
                tree = NORMAL_ID;
                log = NORMAL;
                chopping = "Logs";
            } else if (choice.equals("Oak")) {
                tree = OAK_ID;
                log = OAK;
                chopping = "Oaks";
            } else if (choice.equals("Willow")) {
                tree = WILLOW_ID;
                log = WILLOW;
                chopping = "Willows";
            } else if (choice.equals("Achey")) {
                tree = ACHEY_ID;
                log = ACHEY;
                chopping = "Acheys";
            } else if (choice.equals("Maple")) {
                tree = MAPLE_ID;
                log = MAPLE;
                chopping = "Maples";
            } else if (choice.equals("Arctic Pine")) {
                tree = ARCTIC_PINE_ID;
                log = ARCTIC_PINE;
                chopping = "Arctic pines";
            } else if (choice.equals("Eucalyptus")) {
                tree = EUCALYPTUS_ID;
                log = EUCALYPTUS;
                chopping = "Eucalyptuses";
            } else if (choice.equals("Yew")) {
                tree = YEW_ID;
                log = YEW;
                chopping = "Yews";
            } else if (choice.equals("Magic")) {
                tree = MAGIC_ID;
                log = MAGIC;
                chopping = "Magics";
            } else if (choice.equals("Ivy")) {
                tree = IVY_ID;
                chopping = "Ivy";
            }
        }
        if (cbShowPaint.isSelected()) {
            noPaint = false;
            if (rbSexyPaint.isSelected()) {
                sexyPaint = true;
                noPaint = false;
                simplePaint = false;
            } else if (rbSimplePaint.isSelected()) {
                sexyPaint = false;
                noPaint = false;
                simplePaint = true;
            }
        } else noPaint = true;

        if (cbNests.isSelected()) {
            pickNests = true;
        }
        if (rbActiondrop.isSelected()) {
            actionDrop = true;
            normalDrop = false;
            doBonfires = false;
            normalChop = false;
        } else if (rbDrop.isSelected()) {
            actionDrop = false;
            normalDrop = true;
            doBonfires = false;
            normalChop = true;
        } else if (rbBonfire.isSelected()) {
            actionDrop = false;
            normalDrop = false;
            doBonfires = true;
            normalChop = true;
        }

        if (cbShowMouse.isSelected()) noMouse = false;
        if (cbAntiban.isSelected()) {
            doAntiban = true;
            antibanPercent = jsAntiban.getValue();
        }
        if (cbNests.isSelected()) pickNests = true;
        if (cbScreenshots.isSelected()) doScreenshots = true;

        guiDone = true;
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Azmat Habibullah
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        tabbedPane = new JTabbedPane();
        chopPane = new JPanel();
        lblLogsToCut = new JLabel();
        chopBox = new JComboBox();
        lblWhatToDo = new JLabel();
        rbBonfire = new JRadioButton();
        rbDrop = new JRadioButton();
        rbActiondrop = new JRadioButton();
        cbNests = new JCheckBox();
        paintPane = new JPanel();
        cbShowPaint = new JCheckBox();
        rbSimplePaint = new JRadioButton();
        rbSexyPaint = new JRadioButton();
        cbScreenshots = new JCheckBox();
        lblPath = new JLabel();
        lblFPS = new JLabel();
        cbShowMouse = new JCheckBox();
        antibanPane = new JPanel();
        jsAntiban = new JSlider();
        cbAntiban = new JCheckBox();
        lblFrequency = new JLabel();
        label18 = new JLabel();
        miscPane = new JPanel();
        lblScriptBy = new JLabel();
        lblIntro = new JLabel();
        lblMiscText = new JLabel();
        lblMiscText2 = new JLabel();
        lblMiscText3 = new JLabel();
        title = new JLabel();
        btnStart = new JButton();

        //======== this ========
        setTitle("Injustice's Powerchopper GUI");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //======== tabbedPane ========
                {

                    //======== chopPane ========
                    {
                        chopPane.setPreferredSize(new Dimension(300, 200));

                        //---- lblLogsToCut ----
                        lblLogsToCut.setText("Logs to cut");
                        lblLogsToCut.setFont(lblLogsToCut.getFont().deriveFont(lblLogsToCut.getFont().getSize() + 3f));

                        //---- chopBox ----
                        chopBox.setModel(new DefaultComboBoxModel(new String[] {
                                "Normal",
                                "Achey",
                                "Oak",
                                "Willow",
                                "Maple",
                                "Arctic Pine",
                                "Eucalyptus",
                                "Yew",
                                "Ivy ",
                                "Magic"
                        }));

                        //---- lblWhatToDo ----
                        lblWhatToDo.setText("What to do");
                        lblWhatToDo.setFont(lblWhatToDo.getFont().deriveFont(lblWhatToDo.getFont().getSize() + 3f));

                        //---- rbBonfire ----
                        rbBonfire.setText("Bonfire");

                        //---- rbDrop ----
                        rbDrop.setText("Drop");

                        //---- rbActiondrop ----
                        rbActiondrop.setText("Actiondrop");

                        //---- cbNests ----
                        cbNests.setText("Pick Nests");
                        cbNests.setFont(cbNests.getFont().deriveFont(cbNests.getFont().getSize() + 3f));

                        GroupLayout chopPaneLayout = new GroupLayout(chopPane);
                        chopPane.setLayout(chopPaneLayout);
                        chopPaneLayout.setHorizontalGroup(
                                chopPaneLayout.createParallelGroup()
                                        .addGroup(chopPaneLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(chopPaneLayout.createParallelGroup()
                                                        .addComponent(rbBonfire)
                                                        .addComponent(rbDrop)
                                                        .addComponent(rbActiondrop))
                                                .addContainerGap(200, Short.MAX_VALUE))
                                        .addGroup(chopPaneLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(chopPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(chopBox)
                                                        .addComponent(lblLogsToCut, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblWhatToDo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                                                .addComponent(cbNests)
                                                .addGap(32, 32, 32))
                        );
                        chopPaneLayout.setVerticalGroup(
                                chopPaneLayout.createParallelGroup()
                                        .addGroup(chopPaneLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(chopPaneLayout.createParallelGroup()
                                                        .addComponent(cbNests)
                                                        .addGroup(chopPaneLayout.createSequentialGroup()
                                                                .addComponent(lblLogsToCut)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(chopBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(lblWhatToDo)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(rbBonfire)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(rbDrop)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(rbActiondrop)))
                                                .addContainerGap(34, Short.MAX_VALUE))
                        );
                    }
                    tabbedPane.addTab("Chopping options", chopPane);


                    //======== paintPane ========
                    {

                        //---- cbShowPaint ----
                        cbShowPaint.setText("Show paint");
                        cbShowPaint.setFont(cbShowPaint.getFont().deriveFont(cbShowPaint.getFont().getSize() + 3f));
                        cbShowPaint.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                cbShowPaintActionPerformed(e);
                            }
                        });

                        //---- rbSimplePaint ----
                        rbSimplePaint.setText("Simple paint");
                        rbSimplePaint.setFont(rbSimplePaint.getFont().deriveFont(rbSimplePaint.getFont().getSize() + 3f));
                        rbSimplePaint.setEnabled(false);

                        //---- rbSexyPaint ----
                        rbSexyPaint.setText("Sexy paint");
                        rbSexyPaint.setFont(rbSexyPaint.getFont().deriveFont(rbSexyPaint.getFont().getSize() + 3f));
                        rbSexyPaint.setEnabled(false);

                        //---- cbScreenshots ----
                        cbScreenshots.setText("Take screenshots on stop");
                        cbScreenshots.setFont(cbScreenshots.getFont().deriveFont(cbScreenshots.getFont().getSize() + 3f));

                        //---- lblPath ----
                        lblPath.setText("[YOUR USER]\\Appdata\\Local\\Temp\\Injustice's Powerchopper");
                        lblPath.setFont(lblPath.getFont().deriveFont(lblPath.getFont().getSize() - 2f));

                        //---- lblFPS ----
                        lblFPS.setText("Note: Use simple paint if your FPS is below 20");

                        //---- cbShowMouse ----
                        cbShowMouse.setText("Show mouse");
                        cbShowMouse.setFont(cbShowMouse.getFont().deriveFont(cbShowMouse.getFont().getSize() + 3f));

                        GroupLayout paintPaneLayout = new GroupLayout(paintPane);
                        paintPane.setLayout(paintPaneLayout);
                        paintPaneLayout.setHorizontalGroup(
                                paintPaneLayout.createParallelGroup()
                                        .addGroup(paintPaneLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(paintPaneLayout.createParallelGroup()
                                                        .addGroup(paintPaneLayout.createSequentialGroup()
                                                                .addGap(21, 21, 21)
                                                                .addComponent(lblPath, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(paintPaneLayout.createSequentialGroup()
                                                                .addGroup(paintPaneLayout.createParallelGroup()
                                                                        .addComponent(cbScreenshots)
                                                                        .addGroup(paintPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                                .addGroup(paintPaneLayout.createSequentialGroup()
                                                                                        .addComponent(cbShowPaint)
                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(cbShowMouse))
                                                                                .addGroup(paintPaneLayout.createSequentialGroup()
                                                                                        .addGap(21, 21, 21)
                                                                                        .addGroup(paintPaneLayout.createParallelGroup()
                                                                                                .addComponent(rbSimplePaint)
                                                                                                .addComponent(rbSexyPaint)
                                                                                                .addComponent(lblFPS)))))
                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addContainerGap())
                        );
                        paintPaneLayout.setVerticalGroup(
                                paintPaneLayout.createParallelGroup()
                                        .addGroup(paintPaneLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(paintPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(cbShowPaint)
                                                        .addComponent(cbShowMouse))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rbSimplePaint)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rbSexyPaint)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblFPS)
                                                .addGap(7, 7, 7)
                                                .addComponent(cbScreenshots, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblPath, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(35, Short.MAX_VALUE))
                        );
                    }
                    tabbedPane.addTab("Paint options", paintPane);


                    //======== antibanPane ========
                    {

                        //---- jsAntiban ----
                        jsAntiban.setMinorTickSpacing(5);
                        jsAntiban.setMajorTickSpacing(25);
                        jsAntiban.setPaintTicks(true);
                        jsAntiban.setSnapToTicks(true);
                        jsAntiban.setPaintLabels(true);
                        jsAntiban.setEnabled(false);

                        //---- cbAntiban ----
                        cbAntiban.setText("Antiban");
                        cbAntiban.setFont(cbAntiban.getFont().deriveFont(cbAntiban.getFont().getSize() + 3f));
                        cbAntiban.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                cbAntibanActionPerformed(e);
                            }
                        });

                        //---- lblFrequency ----
                        lblFrequency.setText("Frequency");
                        lblFrequency.setFont(lblFrequency.getFont().deriveFont(lblFrequency.getFont().getSize() + 3f));

                        //---- label18 ----
                        label18.setText("Note: Antiban will only occur when the player is idle");

                        GroupLayout antibanPaneLayout = new GroupLayout(antibanPane);
                        antibanPane.setLayout(antibanPaneLayout);
                        antibanPaneLayout.setHorizontalGroup(
                                antibanPaneLayout.createParallelGroup()
                                        .addComponent(jsAntiban, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                                        .addGroup(antibanPaneLayout.createSequentialGroup()
                                                .addGroup(antibanPaneLayout.createParallelGroup()
                                                        .addGroup(antibanPaneLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(antibanPaneLayout.createParallelGroup()
                                                                        .addComponent(cbAntiban)
                                                                        .addGroup(antibanPaneLayout.createSequentialGroup()
                                                                                .addGap(19, 19, 19)
                                                                                .addComponent(lblFrequency)))
                                                                .addGap(0, 183, Short.MAX_VALUE))
                                                        .addGroup(antibanPaneLayout.createSequentialGroup()
                                                                .addGap(24, 24, 24)
                                                                .addComponent(label18, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)))
                                                .addContainerGap())
                        );
                        antibanPaneLayout.setVerticalGroup(
                                antibanPaneLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, antibanPaneLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(cbAntiban)
                                                .addGap(19, 19, 19)
                                                .addComponent(lblFrequency)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jsAntiban, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(label18)
                                                .addContainerGap(56, Short.MAX_VALUE))
                        );
                    }
                    tabbedPane.addTab("Antiban options", antibanPane);


                    //======== miscPane ========
                    {

                        //---- lblScriptBy ----
                        lblScriptBy.setText("Script by Injustice/Bartsome of PowerBot");

                        //---- lblIntro ----
                        lblIntro.setText("Welcome to Injustice's AIO Powerchopper. ");

                        //---- lblMiscText ----
                        lblMiscText.setText("This script features bonfires, actiondropping, regular");

                        //---- lblMiscText2 ----
                        lblMiscText2.setText("dropping, antiban, multiple paints and an easy to use");

                        //---- lblMiscText3 ----
                        lblMiscText3.setText("GUI.");

                        GroupLayout miscPaneLayout = new GroupLayout(miscPane);
                        miscPane.setLayout(miscPaneLayout);
                        miscPaneLayout.setHorizontalGroup(
                                miscPaneLayout.createParallelGroup()
                                        .addGroup(miscPaneLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(miscPaneLayout.createParallelGroup()
                                                        .addComponent(lblMiscText, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                                                        .addComponent(lblMiscText2, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                                                        .addComponent(lblMiscText3, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
                                                .addContainerGap())
                                        .addGroup(miscPaneLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(miscPaneLayout.createParallelGroup()
                                                        .addComponent(lblScriptBy, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblIntro, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
                                                .addGap(10, 10, 10))
                        );
                        miscPaneLayout.setVerticalGroup(
                                miscPaneLayout.createParallelGroup()
                                        .addGroup(miscPaneLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(lblIntro, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblMiscText, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1)
                                                .addComponent(lblMiscText2)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblMiscText3, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                                                .addGap(40, 40, 40)
                                                .addComponent(lblScriptBy, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                                .addGap(23, 23, 23))
                        );
                    }
                    tabbedPane.addTab("Misc", miscPane);

                }

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                );
                contentPanelLayout.setVerticalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //---- title ----
            title.setText("     Injustice's AIO Powerchopper");
            title.setFont(title.getFont().deriveFont(title.getFont().getSize() + 7f));
            dialogPane.add(title, BorderLayout.NORTH);

            //---- btnStart ----
            btnStart.setText("Start");
            btnStart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnStartActionPerformed(e);
                }
            });
            dialogPane.add(btnStart, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());

        //---- rdbgLogs ----
        ButtonGroup rdbgLogs = new ButtonGroup();
        rdbgLogs.add(rbBonfire);
        rdbgLogs.add(rbDrop);
        rdbgLogs.add(rbActiondrop);

        //---- rdbgPaint ----
        ButtonGroup rdbgPaint = new ButtonGroup();
        rdbgPaint.add(rbSimplePaint);
        rdbgPaint.add(rbSexyPaint);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
// Generated using JFormDesigner Evaluation license - Azmat Habibullah
    private JPanel dialogPane;
    private JPanel contentPanel;
    public JTabbedPane tabbedPane;
    private JPanel chopPane;
    private JLabel lblLogsToCut;
    private JComboBox<String> chopBox;
    private JLabel lblWhatToDo;
    private JRadioButton rbBonfire;
    private JRadioButton rbDrop;
    private JRadioButton rbActiondrop;
    private JCheckBox cbNests;
    private JPanel paintPane;
    private JCheckBox cbShowPaint;
    private JRadioButton rbSimplePaint;
    private JRadioButton rbSexyPaint;
    private JCheckBox cbScreenshots;
    private JLabel lblPath;
    private JLabel lblFPS;
    private JCheckBox cbShowMouse;
    private JPanel antibanPane;
    private JSlider jsAntiban;
    private JCheckBox cbAntiban;
    private JLabel lblFrequency;
    private JLabel label18;
    private JPanel miscPane;
    private JLabel lblScriptBy;
    private JLabel lblIntro;
    private JLabel lblMiscText;
    private JLabel lblMiscText2;
    private JLabel lblMiscText3;
    private JLabel title;
    private JButton btnStart;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
