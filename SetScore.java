import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SetScore {
    public void scoreTable(GameData gd, Game g) {
        if (g.t.rollNum > 0) {
            g.play();
            gd.dice1Box.setEnabled(true);
            gd.dice2Box.setEnabled(true);
            gd.dice3Box.setEnabled(true);
            gd.dice4Box.setEnabled(true);
            gd.dice5Box.setEnabled(true);
            gd.rollsLeftLabel.setText("Rolls Left:" + g.t.rollNum);
            setImages(gd, g);
            System.out.println(g.allDice[0].getNum() + " " + g.allDice[1].getNum() + " " + g.allDice[2].getNum() + " " + g.allDice[3].getNum() + " " + g.allDice[4].getNum());
            for (int row = 0; row < 16; row++) {
                if (g.isScored[row]) {
                    continue;
                }
                switch (row) {
                    case 0:
                        gd.table1.setValueAt(g.t.ones(g.getAllDice()), row, 1);
                        System.out.println(g.t.ones(g.allDice));
                        break;
                    case 1:
                        gd.table1.setValueAt(g.t.twos(g.getAllDice()), row, 1);
                        System.out.println(g.t.twos(g.allDice));
                        break;
                    case 2:
                        gd.table1.setValueAt(g.t.threes(g.getAllDice()), row, 1);
                        System.out.println(g.t.threes(g.allDice));
                        break;
                    case 3:
                        gd.table1.setValueAt(g.t.fours(g.getAllDice()), row, 1);
                        System.out.println(g.t.fours(g.allDice));
                        break;
                    case 4:
                        gd.table1.setValueAt(g.t.fives(g.getAllDice()), row, 1);
                        System.out.println(g.t.fives(g.allDice));
                        break;
                    case 5:
                        gd.table1.setValueAt(g.t.sixes(g.getAllDice()), row, 1);
                        System.out.println(g.t.sixes(g.allDice));
                        break;
                    case 8:
                        gd.table1.setValueAt(g.t.threeKind(g.getAllDice()), row, 1);
                        System.out.println(g.t.threeKind(g.allDice));
                        break;
                    case 9:
                        gd.table1.setValueAt(g.t.fourKind(g.getAllDice()), row, 1);
                        System.out.println(g.t.fourKind(g.allDice));
                        break;
                    case 10:
                        gd.table1.setValueAt(g.t.fullHouse(g.allDice), row, 1);
                        System.out.println(g.t.fullHouse(g.allDice));
                        break;
                    case 11:
                        gd.table1.setValueAt(g.t.straightSmall(g.allDice), row, 1);
                        System.out.println(g.t.straightSmall(g.allDice));
                        break;
                    case 12:
                        gd.table1.setValueAt(g.t.straightLarge(g.allDice), row, 1);
                        System.out.println(g.t.straightLarge(g.allDice));
                        break;
                    case 13:
                        gd.table1.setValueAt(g.t.chance(g.allDice), row, 1);
                        System.out.println(g.t.chance(g.allDice));
                        break;
                    case 14:
                        gd.table1.setValueAt(g.t.yahtzee(g.allDice), row, 1);
                        System.out.println(g.t.yahtzee(g.allDice));
                        break;

                }
            }
        }
    }

    public void setImages(GameData gd, Game g) {
        ArrayList<JLabel> diceImages = new ArrayList<JLabel>();
        diceImages.add(gd.dice1Image);
        diceImages.add(gd.dice2Image);
        diceImages.add(gd.dice3Image);
        diceImages.add(gd.dice4Image);
        diceImages.add(gd.dice5Image);
        Dice[] dices = g.getAllDice();
        for (int i = 0; i < 5; i++) {
            if (!dices[i].isSaved()) {
                int diceNum = randomDice();
                String iconSource = "/img/dice" + diceNum + ".png";
                diceImages.get(i).setIcon(new ImageIcon(getClass().getResource(iconSource)));
                g.setDice(i, diceNum);
            }
        }

    }

    public int randomDice() {
        Random random = new Random();
        return 1 + random.nextInt(6);
    }

    public void startNewRound(GameData gd, Game g) {
        gd.dice1Box.setEnabled(false);
        gd.dice2Box.setEnabled(false);
        gd.dice3Box.setEnabled(false);
        gd.dice4Box.setEnabled(false);
        gd.dice5Box.setEnabled(false);

        gd.dice1Box.setSelected(false);
        gd.dice2Box.setSelected(false);
        gd.dice3Box.setSelected(false);
        gd.dice4Box.setSelected(false);
        gd.dice5Box.setSelected(false);

        g.clearDice();

        ArrayList<JLabel> diceImages = new ArrayList<JLabel>();
        diceImages.add(gd.dice1Image);
        diceImages.add(gd.dice2Image);
        diceImages.add(gd.dice3Image);
        diceImages.add(gd.dice4Image);
        diceImages.add(gd.dice5Image);
        for (int i = 0; i < 5; i++) {
            diceImages.get(i).setIcon(new ImageIcon());
        }

        gd.roundLabel.setText("Rounds Left:" + g.turnNum);

        gd.rollsLeftLabel.setText("Rolls Left:" + g.t.rollNum);

    }
}
