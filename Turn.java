import java.lang.Math;

public class Turn {

    int rollNum;

    public Turn() {
        rollNum = 3;
    }
    public void roll(Dice[] dice) {
        for (int i = 0; i < dice.length; i++) {
            dice[i].setNum((int) ((Math.random() * (6 - 1)) + 1));
        }
        //Simple point scoring
        ones(dice);
        twos(dice);
        threes(dice);
        fours(dice);
        fives(dice);
        sixes(dice);
        //Complex point scoring
        threeKind(dice);
        fourKind(dice);
        straightSmall(dice);
        straightLarge(dice);
        yahtzee(dice);
        rollNum--;
    }

    public int checkDiceSimple(Dice[] dice, int num) {
        int total = 0;
        for(int i = 0; i < dice.length; i++) {
            if(dice[i].getNum() == num)
                total++;
        }
        return total;
    }

    // All of the lower scoring options
    public int ones(Dice[] dice) {
        return checkDiceSimple(dice, 1);
    }

    public int twos(Dice[] dice) {
        return checkDiceSimple(dice, 2);
    }

    public int threes(Dice[] dice) {
        return checkDiceSimple(dice, 3);
    }

    public int fours(Dice[] dice) {
        return checkDiceSimple(dice, 4);
    }

    public int fives(Dice[] dice) {
        return checkDiceSimple(dice, 5);
    }

    public int sixes(Dice[] dice) {
        return checkDiceSimple(dice, 6);
    }



    public int threeKind(Dice[] dice) {
        return 0;
    }

    public int fourKind(Dice[] dice) {
        return 0;
    }

    public int yahtzee(Dice[] dice) {
        return 0;
    }

    public int straightSmall(Dice[] dice) {
        return 0;
    }

    public int straightLarge(Dice[] dice) {
        return 0;
    }
}
