public class Game {
    Dice[] allDice = new Dice[5];
    Turn t;
    int turnNum;

    public void next() {
        turnNum--;
        t = new Turn();
    }

    public Game() {
        for(int i = 0; i < allDice.length; i++) {
            allDice[i] = new Dice();
        }
      t = new Turn();
      turnNum = 13;
    }

    public void play() {
        t.roll(allDice);
        next();
    }

    public Dice[] getAllDice() {
        return allDice;
    }
    public void setAllDice(Dice[] allDice) {
        this.allDice = allDice;
    }
    public Turn getT() {
        return t;
    }
    public void setT(Turn t) {
        this.t = t;
    }
    
}
