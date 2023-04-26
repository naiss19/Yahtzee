/**
 * Yahtzee Final Project
 * 
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
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

        table1.setFont(new java.awt.Font("Eras Medium ITC", 0, 12)); // NOI18N
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Ones", ""},
                {"Twos", null},
                {"Threes", null},
                {"Fours", null},
                {"Fives", null},
                {"Sixes", null},
                {"Upper Total", null},
                {"3 of a Kind", null},
                {"4 of a Kind", null},
                {"Full House", null},
                {"Small Straight", null},
                {"Large Straight", null},
                {"Chance", null},
                {"Yahtzee", null},
                {"Lower Total", null}
            },
            new String [] {
                "Category", "Score"
            }
        ));
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
        roundLabel.setText("Rounds Left:");

        dice1Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dice1BoxActionPerformed(evt);
            }
        });

        dice1Image.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        dice2Image.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        dice3Image.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        dice4Image.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        dice5Image.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        javax.swing.GroupLayout dicePanelLayout = new javax.swing.GroupLayout(dicePanel);
        dicePanel.setLayout(dicePanelLayout);
        dicePanelLayout.setHorizontalGroup(
            dicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dicePanelLayout.createSequentialGroup()
                .addGroup(dicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(dicePanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(dice1Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(dice2Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dice3Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dicePanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(dice1Box)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dice2Box)
                        .addGap(62, 62, 62)
                        .addComponent(dice3Box)
                        .addGap(21, 21, 21)))
                .addGroup(dicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dicePanelLayout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(dice4Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dice5Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(dicePanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(dice4Box)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dice5Box)
                        .addGap(36, 36, 36))))
        );
        dicePanelLayout.setVerticalGroup(
            dicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dicePanelLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(dicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(dice4Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dice1Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dice2Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dice3Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dice5Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dice1Box, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dice3Box, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dice2Box, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dice4Box, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dice5Box, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        button.setFont(new java.awt.Font("Eras Medium ITC", 0, 36)); // NOI18N
        button.setText("Roll");
        button.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        rollsLeftLabel.setFont(new java.awt.Font("Eras Medium ITC", 0, 18)); // NOI18N
        rollsLeftLabel.setText("Rolls Left:");

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dicePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gamePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(rollsLeftLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112))
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePanelLayout.createSequentialGroup()
                .addComponent(roundLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dicePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rollsLeftLabel)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 209, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)))
        );

        pack();
    }// </editor-fold>

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void dice1BoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
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
}
