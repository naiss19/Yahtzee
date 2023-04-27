public class Game {
    Dice[] allDice = new Dice[5];
    Turn t;
    int turnNum;
    int totalPoints;


    public void next() {
        t = new Turn();
        if (t.rollNum == 0) {
            for(int i = 0; i < allDice.length; i++) {
                allDice[i] = new Dice();
                t.rollNum = 3;
                turnNum--;
            }
        }
    }

    public Game() {
        for(int i = 0; i < allDice.length; i++) {
            allDice[i] = new Dice();
        }
      t = new Turn();
      turnNum = 13;
      totalPoints = 0;
    }

public int checker(int condition) {
    if (condition > 0) {
        this.totalPoints += t.ones(allDice);
        return t.ones(allDice); 
    }
    return 0;
}


    public void play() {
        t.roll(allDice);

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
