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
    GameData gd;
    SetScore s;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        g = new Game();
        gd = new GameData();
        s = new SetScore();
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Gui Code">
    private void initComponents() {


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gd.jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        gd.jScrollPane1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        gd.table1.setFont(new java.awt.Font("Eras Medium ITC", 0, 12)); // NOI18N
        gd.table1.setModel(new MyTableModel(
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

        gd.table1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                int row = gd.table1.rowAtPoint(e.getPoint());
                //Remove all value of other row
                if (g.isScored[row])
                {
                    return;
                }
                for (int i=0; i<15; i++)
                {
                    if (i != row && i != 6 && row != 14 && !g.isScored[i])
                    {
                        gd.table1.setValueAt(null, i, 1);
                    }
                }
                if (row >= 0) {
                    Object cellValue = gd.table1.getValueAt(row, 1);
                    if (row != 6 && row != 14) {
                        g.t.rollNum = 3;
                        g.turnNum--;
                        s.startNewRound(gd, g);
                        g.isScored[row] = true;
                        if (row < 6) {
                            g.upperPoint += parseInt(cellValue.toString());
                        }
                        else {
                            g.lowerPoint += parseInt(cellValue.toString());
                        }
                    }
                    if (g.isScored[0] && g.isScored[1] && g.isScored[2] && g.isScored[3] && g.isScored[4] && g.isScored[5] && !g.isScored[6]) {
                        gd.table1.setValueAt(g.upperPoint, 6, 1);
                        g.totalPoints += g.upperPoint;
                        g.isScored[6] = true;
                    }
                    if (g.isScored[7] && g.isScored[8] && g.isScored[9] && g.isScored[10] && g.isScored[11] && g.isScored[12] && g.isScored[13] && !g.isScored[14]) {
                        gd.table1.setValueAt(g.lowerPoint, 14, 1);
                        g.totalPoints += g.lowerPoint;
                        g.isScored[14] = true;
                    }
                    if(g.turnNum == 0) {
                        gd.gamePanel.hide();
                        gd.button.setFont(new java.awt.Font("Eras Medium ITC", 0, 24)); // NOI18N
                        gd.button.setText("New Game?");
                        gd.button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                        gd.button.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                buttonActionPerformed(evt);
                            }
                        });

                        gd.totalScoreLabel.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
                        gd.totalScoreLabel.setText("Total Score: " + String.valueOf(g.totalPoints));

                        javax.swing.GroupLayout endGamePanelLayout = new javax.swing.GroupLayout(gd.endGamePanel);
                        gd.endGamePanel.setLayout(endGamePanelLayout);
                        endGamePanelLayout.setHorizontalGroup(
                                endGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, endGamePanelLayout.createSequentialGroup()
                                                .addContainerGap(45, Short.MAX_VALUE)
                                                .addGroup(endGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(gd.totalScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(gd.button, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(114, 114, 114))
                        );
                        endGamePanelLayout.setVerticalGroup(
                                endGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(endGamePanelLayout.createSequentialGroup()
                                                .addGap(91, 91, 91)
                                                .addComponent(gd.totalScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                                                .addComponent(gd.button, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33))
                        );

                        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                        getContentPane().setLayout(layout);
                        layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(154, 154, 154)
                                                .addComponent(gd.title, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 209, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(gd.endGamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(gd.jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        );
                        layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(gd.title, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(gd.endGamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(25, Short.MAX_VALUE))
                                                        .addComponent(gd.jScrollPane1)))
                        );
                    }
                }
                gd.table1.setRowSelectionAllowed(false);
            }
        });
        gd.table1.setFillsViewportHeight(true);
        gd.table1.setPreferredSize(new java.awt.Dimension(150, 390));
        gd.table1.setRowHeight(27);
        gd.table1.setRowSelectionAllowed(false);
        gd.table1.setShowHorizontalLines(true);
        gd.table1.setShowVerticalLines(true);
        gd.table1.getTableHeader().setReorderingAllowed(false);
        gd.jScrollPane1.setViewportView(gd.table1);

        gd.title.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gd.title.setFont(new java.awt.Font("Eras Medium ITC", 1, 48)); // NOI18N
        gd.title.setText("Yahtzee");


        gd.roundLabel.setFont(new java.awt.Font("Eras Medium ITC", 0, 18)); // NOI18N
        gd.roundLabel.setText("Rounds Left:" + String.valueOf(g.turnNum));

       gd.dice1Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               dice1BoxActionPerformed(evt);
            }
        });
       gd.dice2Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               dice2BoxActionPerformed(evt);
            }
        });
       gd.dice3Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               dice3BoxActionPerformed(evt);
            }
        });
       gd.dice4Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               dice4BoxActionPerformed(evt);
            }
        });
       gd.dice5Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               dice5BoxActionPerformed(evt);
            }
        });

       gd.dice1Box.setEnabled(false);
       gd.dice2Box.setEnabled(false);
       gd.dice3Box.setEnabled(false);
       gd.dice4Box.setEnabled(false);
       gd.dice5Box.setEnabled(false);
       gd.dice1Image.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));

       gd.dice2Image.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));

       gd.dice3Image.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));

       gd.dice4Image.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));

       gd.dice5Image.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));

        javax.swing.GroupLayout dicePanelLayout = new javax.swing.GroupLayout(gd.dicePanel);
       gd.dicePanel.setLayout(dicePanelLayout);
       dicePanelLayout.setHorizontalGroup(
               dicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dicePanelLayout.createSequentialGroup()
                                .addGroup(dicePanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(dicePanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(gd.dice1Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(gd.dice2Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(gd.dice3Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(dicePanelLayout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addComponent(gd.dice1Box)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(gd.dice2Box)
                                                .addGap(62, 62, 62)
                                                .addComponent(gd.dice3Box)
                                                .addGap(21, 21, 21)))
                                .addGroup(dicePanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(dicePanelLayout.createSequentialGroup()
                                                .addGap(18, 18, Short.MAX_VALUE)
                                                .addComponent(gd.dice4Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(gd.dice5Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(13, 13, 13))
                                        .addGroup(dicePanelLayout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(gd.dice4Box)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(gd.dice5Box)
                                                .addGap(36, 36, 36)))));
       dicePanelLayout.setVerticalGroup(
               dicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dicePanelLayout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addGroup(dicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(gd.dice4Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(gd.dice1Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(gd.dice2Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(gd.dice3Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(gd.dice5Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(dicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(gd.dice1Box, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(gd.dice3Box, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(gd.dice2Box, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(gd.dice4Box, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(gd.dice5Box, javax.swing.GroupLayout.Alignment.TRAILING))));

        gd.button.setFont(new java.awt.Font("Eras Medium ITC", 0, 36)); // NOI18N
        gd.button.setText("Roll");
        gd.button.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        gd.button.addActionListener(evt -> actionPerformed(evt));

        gd.rollsLeftLabel.setFont(new java.awt.Font("Eras Medium ITC", 0, 18)); // NOI18N
        gd.rollsLeftLabel.setText("Rolls Left:" + String.valueOf(g.t.rollNum));

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gd.gamePanel);
        gd.gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
                gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(gd.roundLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gd.dicePanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gamePanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(gd.rollsLeftLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 206,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(gd.button, javax.swing.GroupLayout.PREFERRED_SIZE, 203,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(112, 112, 112)));
        gamePanelLayout.setVerticalGroup(
                gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(gamePanelLayout.createSequentialGroup()
                                .addComponent(gd.roundLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gd.dicePanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62,
                                        Short.MAX_VALUE)
                                .addComponent(gd.button, javax.swing.GroupLayout.PREFERRED_SIZE, 106,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gd.rollsLeftLabel)
                                .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(gd.title, javax.swing.GroupLayout.PREFERRED_SIZE, 306,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 209, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(gd.gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gd.jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
                                        Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(gd.title, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(gd.gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(25, Short.MAX_VALUE))
                                        .addComponent(gd.jScrollPane1))));

        pack();
    }// </editor-fold>

    //New game gd.button
    private void buttonActionPerformed(ActionEvent evt) {
        this.dispose();
        new MainFrame().setVisible(true);
    }

    private void dice1BoxActionPerformed(java.awt.event.ActionEvent evt) {
        if (gd.dice1Box.isSelected()) {
            g.getAllDice()[0].setSaved(true);
        }
        else {
            g.getAllDice()[0].setSaved(false);
        }
    }
    private void dice2BoxActionPerformed(java.awt.event.ActionEvent evt) {
        if (gd.dice2Box.isSelected()) {
            g.getAllDice()[1].setSaved(true);
        }
        else {
            g.getAllDice()[1].setSaved(false);
        }
    }
    private void dice3BoxActionPerformed(java.awt.event.ActionEvent evt) {
        if (gd.dice3Box.isSelected()) {
            g.getAllDice()[2].setSaved(true);
        }
        else {
            g.getAllDice()[2].setSaved(false);
        }
    }
    private void dice4BoxActionPerformed(java.awt.event.ActionEvent evt) {
        if (gd.dice4Box.isSelected()) {
            g.getAllDice()[3].setSaved(true);
        }
        else {
            g.getAllDice()[3].setSaved(false);
        }
    }
    private void dice5BoxActionPerformed(java.awt.event.ActionEvent evt) {
        if (gd.dice5Box.isSelected()) {
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


    // End of variables declaration

    @Override
    public void actionPerformed(ActionEvent e) {
        SetScore s = new SetScore();
        s.scoreTable(gd, g);
        // else choose from score board and then end turn
    }


    public void scoreActionPerformed(ActionEvent e) {
        g.play();
        gd.button.setText("Bababooey");
        gd.roundLabel.setText("Rounds Left:" + String.valueOf(g.turnNum));

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
