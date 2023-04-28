import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.table.*;

import static java.lang.Integer.parseInt;

/**
 * Yahtzee Final Project
 * 
 */
public class MainFrame extends javax.swing.JFrame implements ActionListener {
    Game g;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        g = new Game();
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Gui Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        title = new java.awt.Label();
        gamePanel = new javax.swing.JPanel();
        roundLabel = new javax.swing.JLabel();
        dicePanel = new javax.swing.JPanel();
        dice1Box = new javax.swing.JCheckBox();
        dice2Box = new javax.swing.JCheckBox();
        dice3Box = new javax.swing.JCheckBox();
        dice4Box = new javax.swing.JCheckBox();
        dice5Box = new javax.swing.JCheckBox();
        dice1Image = new javax.swing.JLabel();
        dice2Image = new javax.swing.JLabel();
        dice3Image = new javax.swing.JLabel();
        dice4Image = new javax.swing.JLabel();
        dice5Image = new javax.swing.JLabel();
        button = new javax.swing.JButton();
        rollsLeftLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        jScrollPane1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        for (int i = 0; i < table1.getRowCount(); i++) {

        }
        table1.setFont(new java.awt.Font("Eras Medium ITC", 0, 12)); // NOI18N
        table1.setModel(new MyTableModel(
                new Object[][] {
                        { "Ones", "" },
                        { "Twos", null },
                        { "Threes", null },
                        { "Fours", null },
                        { "Fives", null },
                        { "Sixes", null },
                        { "Upper Total", null },
                        { "3 of a Kind", null },
                        { "4 of a Kind", null },
                        { "Full House", null },
                        { "Small Straight", null },
                        { "Large Straight", null },
                        { "Chance", null },
                        { "Yahtzee", null },
                        { "Lower Total", null }
                },
                new String[] {
                        "Category", "Score"
                }));

        table1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                int row = table1.rowAtPoint(e.getPoint());
                //Remove all value of other row
                if (g.isScored[row])
                {
                    return;
                }
                for (int i=0; i<15; i++)
                {
                    if (i != row && i != 6 && row != 14 && !g.isScored[i])
                    {
                        table1.setValueAt(null, i, 1);
                    }
                }
                if (row >= 0) {
                    Object cellValue = table1.getValueAt(row, 1);
                    if (row != 6 && row != 14) {
                        g.t.rollNum = 3;
                        g.turnNum--;
                        startNewRound();
                        g.isScored[row] = true;
                        if (row < 6) {
                            g.upperPoint += parseInt(cellValue.toString());
                        }
                        else {
                            g.lowerPoint += parseInt(cellValue.toString());
                        }
                    }
                    if (g.isScored[0] && g.isScored[1] && g.isScored[2] && g.isScored[3] && g.isScored[4] && g.isScored[5]) {
                        table1.setValueAt(g.upperPoint, 6, 1);
                    }
                    if (g.isScored[7] && g.isScored[8] && g.isScored[9] && g.isScored[10] && g.isScored[11] && g.isScored[12] && g.isScored[13]) {
                        table1.setValueAt(g.lowerPoint, 14, 1);
                    }
                }
                table1.setRowSelectionAllowed(false);
            }
        });
        table1.setFillsViewportHeight(true);
        table1.setPreferredSize(new java.awt.Dimension(150, 390));
        table1.setRowHeight(27);
        table1.setRowSelectionAllowed(false);
        table1.setShowHorizontalLines(true);
        table1.setShowVerticalLines(true);
        table1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table1);

        title.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        title.setFont(new java.awt.Font("Eras Medium ITC", 1, 48)); // NOI18N
        title.setText("Yahtzee");

        roundLabel.setFont(new java.awt.Font("Eras Medium ITC", 0, 18)); // NOI18N
        roundLabel.setText("Rounds Left:" + String.valueOf(g.turnNum));

        dice1Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dice1BoxActionPerformed(evt);
            }
        });
        dice2Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dice2BoxActionPerformed(evt);
            }
        });
        dice3Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dice3BoxActionPerformed(evt);
            }
        });
        dice4Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dice4BoxActionPerformed(evt);
            }
        });
        dice5Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dice5BoxActionPerformed(evt);
            }
        });

        dice1Box.setEnabled(false);
        dice2Box.setEnabled(false);
        dice3Box.setEnabled(false);
        dice4Box.setEnabled(false);
        dice5Box.setEnabled(false);
        dice1Image.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));

        dice2Image.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));

        dice3Image.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));

        dice4Image.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));

        dice5Image.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));

        javax.swing.GroupLayout dicePanelLayout = new javax.swing.GroupLayout(dicePanel);
        dicePanel.setLayout(dicePanelLayout);
        dicePanelLayout.setHorizontalGroup(
                dicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dicePanelLayout.createSequentialGroup()
                                .addGroup(dicePanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(dicePanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(dice1Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(dice2Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(dice3Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(dicePanelLayout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addComponent(dice1Box)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(dice2Box)
                                                .addGap(62, 62, 62)
                                                .addComponent(dice3Box)
                                                .addGap(21, 21, 21)))
                                .addGroup(dicePanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(dicePanelLayout.createSequentialGroup()
                                                .addGap(18, 18, Short.MAX_VALUE)
                                                .addComponent(dice4Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(dice5Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(13, 13, 13))
                                        .addGroup(dicePanelLayout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(dice4Box)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(dice5Box)
                                                .addGap(36, 36, 36)))));
        dicePanelLayout.setVerticalGroup(
                dicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dicePanelLayout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addGroup(dicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(dice4Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dice1Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dice2Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dice3Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dice5Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(dicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dice1Box, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(dice3Box, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(dice2Box, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(dice4Box, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(dice5Box, javax.swing.GroupLayout.Alignment.TRAILING))));

        button.setFont(new java.awt.Font("Eras Medium ITC", 0, 36)); // NOI18N
        button.setText("Roll");
        button.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        // button.addActionListener(new java.awt.event.ActionListener() {
        // public void actionPerformed(java.awt.event.ActionEvent evt) {
        // buttonActionPerformed(evt);
        // }
        // });
        button.addActionListener(evt -> actionPerformed(evt));

        rollsLeftLabel.setFont(new java.awt.Font("Eras Medium ITC", 0, 18)); // NOI18N
        rollsLeftLabel.setText("Rolls Left:" + String.valueOf(g.t.rollNum));

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
                gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(roundLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dicePanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gamePanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(rollsLeftLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 206,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 203,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(112, 112, 112)));
        gamePanelLayout.setVerticalGroup(
                gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(gamePanelLayout.createSequentialGroup()
                                .addComponent(roundLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dicePanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62,
                                        Short.MAX_VALUE)
                                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 106,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rollsLeftLabel)
                                .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 306,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 209, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
                                        Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(25, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1))));

        pack();
    }// </editor-fold>

    private void dice1BoxActionPerformed(java.awt.event.ActionEvent evt) {
        if (dice1Box.isSelected()) {
            g.getAllDice()[0].setSaved(true);
        }
        else {
            g.getAllDice()[0].setSaved(false);
        }
    }
    private void dice2BoxActionPerformed(java.awt.event.ActionEvent evt) {
        if (dice2Box.isSelected()) {
            g.getAllDice()[1].setSaved(true);
        }
        else {
            g.getAllDice()[1].setSaved(false);
        }
    }
    private void dice3BoxActionPerformed(java.awt.event.ActionEvent evt) {
        if (dice3Box.isSelected()) {
            g.getAllDice()[2].setSaved(true);
        }
        else {
            g.getAllDice()[2].setSaved(false);
        }
    }
    private void dice4BoxActionPerformed(java.awt.event.ActionEvent evt) {
        if (dice4Box.isSelected()) {
            g.getAllDice()[3].setSaved(true);
        }
        else {
            g.getAllDice()[3].setSaved(false);
        }
    }
    private void dice5BoxActionPerformed(java.awt.event.ActionEvent evt) {
        if (dice5Box.isSelected()) {
            g.getAllDice()[4].setSaved(true);
        }
        else {
            g.getAllDice()[4].setSaved(false);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton button;
    private javax.swing.JCheckBox dice1Box;
    private javax.swing.JLabel dice1Image;
    private javax.swing.JCheckBox dice2Box;
    private javax.swing.JLabel dice2Image;
    private javax.swing.JCheckBox dice3Box;
    private javax.swing.JLabel dice3Image;
    private javax.swing.JCheckBox dice4Box;
    private javax.swing.JLabel dice4Image;
    private javax.swing.JCheckBox dice5Box;
    private javax.swing.JLabel dice5Image;
    private javax.swing.JPanel dicePanel;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel rollsLeftLabel;
    private javax.swing.JLabel roundLabel;
    private javax.swing.JTable table1;
    private java.awt.Label title;

    // End of variables declaration

    @Override
    public void actionPerformed(ActionEvent e) {
        if (g.t.rollNum > 0)
        {
            g.play();
            dice1Box.setEnabled(true);
            dice2Box.setEnabled(true);
            dice3Box.setEnabled(true);
            dice4Box.setEnabled(true);
            dice5Box.setEnabled(true);
            rollsLeftLabel.setText("Rolls Left:" + String.valueOf(g.t.rollNum));
            setImages();
            System.out.println(g.allDice[0].getNum() + " " + g.allDice[1].getNum() + " " + g.allDice[2].getNum() + " " + g.allDice[3].getNum() + " " + g.allDice[4].getNum());
            for (int row=0; row<14; row++)
            {
                if (g.isScored[row])
                {
                    continue;
                }
                switch (row) {
                    case 0:
                        table1.setValueAt(g.t.ones(g.getAllDice()), row, 1);
                        System.out.println(g.t.ones(g.allDice));
                        break;
                    case 1:
                        table1.setValueAt(g.t.twos(g.getAllDice()), row, 1);
                        System.out.println(g.t.twos(g.allDice));
                        break;
                    case 2:
                        table1.setValueAt(g.t.threes(g.getAllDice()), row, 1);
                        System.out.println(g.t.threes(g.allDice));
                        break;
                    case 3:
                        table1.setValueAt(g.t.fours(g.getAllDice()), row, 1);
                        System.out.println(g.t.fours(g.allDice));
                        break;
                    case 4:
                        table1.setValueAt(g.t.fives(g.getAllDice()), row, 1);
                        System.out.println(g.t.fives(g.allDice));
                        break;
                    case 5:
                        table1.setValueAt(g.t.sixes(g.getAllDice()), row, 1);
                        System.out.println(g.t.sixes(g.allDice));
                        break;
                    case 7:
                        table1.setValueAt(g.t.threeKind(g.getAllDice()), row, 1);
                        System.out.println(g.t.threeKind(g.allDice));
                        break;
                    case 8:
                        table1.setValueAt(g.t.fourKind(g.getAllDice()), row, 1);
                        System.out.println(g.t.fourKind(g.allDice));
                        break;
                    case 9:
                        table1.setValueAt(g.t.fullHouse(g.allDice), row, 1);
                        System.out.println(g.t.fullHouse(g.allDice));
                        break;
                    case 10:
                        table1.setValueAt(g.t.straightSmall(g.allDice), row, 1);
                        System.out.println(g.t.straightSmall(g.allDice));
                        break;
                    case 11:
                        table1.setValueAt(g.t.straightLarge(g.allDice), row, 1);
                        System.out.println(g.t.straightLarge(g.allDice));
                        break;
                    case 12:
                        table1.setValueAt(g.t.chance(g.allDice), row, 1);
                        System.out.println(g.t.chance(g.allDice));
                        break;
                    case 13:
                        table1.setValueAt(g.t.yahtzee(g.allDice), row, 1);
                        System.out.println(g.t.yahtzee(g.allDice));
                        break;

                }
            }

        }
        // else choose from score board and then end turn
    }

    public void setImages() {
        ArrayList<JLabel> diceImages = new ArrayList<JLabel>();
        diceImages.add(dice1Image);
        diceImages.add(dice2Image);
        diceImages.add(dice3Image);
        diceImages.add(dice4Image);
        diceImages.add(dice5Image);
        Dice[] dices = g.getAllDice();
        for (int i=0; i<5; i++)
        {
            if (!dices[i].isSaved()) {
                int diceNum = randomDice();
                String iconSource = "/img/dice" + diceNum + ".png";
                diceImages.get(i).setIcon(new ImageIcon(getClass().getResource(iconSource)));
                g.setDice(i, diceNum);
            }
        }

    }

    public void startNewRound() {
        dice1Box.setEnabled(false);
        dice2Box.setEnabled(false);
        dice3Box.setEnabled(false);
        dice4Box.setEnabled(false);
        dice5Box.setEnabled(false);

        dice1Box.setSelected(false);
        dice2Box.setSelected(false);
        dice3Box.setSelected(false);
        dice4Box.setSelected(false);
        dice5Box.setSelected(false);

        g.clearDice();

        ArrayList<JLabel> diceImages = new ArrayList<JLabel>();
        diceImages.add(dice1Image);
        diceImages.add(dice2Image);
        diceImages.add(dice3Image);
        diceImages.add(dice4Image);
        diceImages.add(dice5Image);
        for (int i=0; i<5; i++)
        {
            diceImages.get(i).setIcon(new ImageIcon());
        }

        roundLabel.setText("Rounds Left:" + String.valueOf(g.turnNum));

        rollsLeftLabel.setText("Rolls Left:" + String.valueOf(g.t.rollNum));


    }

    public int randomDice(){
        Random random = new Random();
        return 1 + random.nextInt(6);
    }

    public void scoreActionPerformed(ActionEvent e) {
        g.play();
        button.setText("Bababooey");
        roundLabel.setText("Rounds Left:" + String.valueOf(g.turnNum));

    }
}

class MyTableModel extends DefaultTableModel {
    public MyTableModel(Object[][] o, String[] s) {
        super(o, s);
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col == 1 && col == 2;
    }
}
