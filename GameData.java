import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.table.*;
import static java.lang.Integer.parseInt;

public class GameData {
    public javax.swing.JButton button;
    public javax.swing.JCheckBox dice1Box;
    public javax.swing.JLabel dice1Image;
    public javax.swing.JCheckBox dice2Box;
    public javax.swing.JLabel dice2Image;
    public javax.swing.JCheckBox dice3Box;
    public javax.swing.JLabel dice3Image;
    public javax.swing.JCheckBox dice4Box;
    public javax.swing.JLabel dice4Image;
    public javax.swing.JCheckBox dice5Box;
    public javax.swing.JLabel dice5Image;
    public javax.swing.JPanel dicePanel;
    public javax.swing.JPanel gamePanel;
    public javax.swing.JPanel endGamePanel;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel rollsLeftLabel;
    public javax.swing.JLabel roundLabel;
    public javax.swing.JTable table1;
    public java.awt.Label title;
    public javax.swing.JLabel totalScoreLabel;

    public GameData() {
         jScrollPane1 = new javax.swing.JScrollPane();
         table1 = new javax.swing.JTable();
         title = new java.awt.Label();
         gamePanel = new javax.swing.JPanel();
         endGamePanel = new javax.swing.JPanel();
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
        totalScoreLabel = new javax.swing.JLabel();
    }
}
