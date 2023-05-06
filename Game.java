public class Game {
    Dice[] allDice = new Dice[5];
    Turn t;
    int turnNum;
    int totalPoints;
    int upperPoint;
    int lowerPoint;
    boolean[] isScored = new boolean[17];

    public Game() {
        for (int i = 0; i < allDice.length; i++) {
            allDice[i] = new Dice();
        }
        t = new Turn();
        turnNum = 13;
        totalPoints = 0;
        upperPoint = 0;
        lowerPoint = 0;
    }

    public void play() {
        t.roll(allDice);
    }

    public Dice[] getAllDice() {
        return allDice;
    }

    public void setDice(int index, int value) {
        this.allDice[index].setNum(value);
    }

    public void clearDice() {
        for (int i = 0; i < 5; i++) {
            this.allDice[i].setSaved(false);
        }
    }

    

}
