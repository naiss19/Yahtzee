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
        fullHouse(dice);
        straightSmall(dice);
        straightLarge(dice);
        chance(dice);
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
        int sum = 0;
        int[] count = new int[7];
        for(int i = 0; i < dice.length; i++){
            count[dice[i].getNum()]++;
            sum += dice[i].getNum();
        }
        for(int i = 1; i <= 6; i++){
            if(count[i] >= 3){
                return sum;
            }
        }
        return 0;
    }

    public int fourKind(Dice[] dice) {
        int sum = 0;
        int[] count = new int[7];
        for(int i = 0; i < dice.length; i++){
            count[dice[i].getNum()]++;
            sum += dice[i].getNum();
        }
        for(int i = 1; i <= 6; i++){
            if(count[i] >= 4){
                return sum;
            }
        }
        return 0;
    }

    public int yahtzee(Dice[] dice) {
        int[] count = new int[7];
        for(int i = 0; i < dice.length; i++){
            count[dice[i].getNum()]++;
        }
        
        for(int i = 1; i <= 6; i++){
            if(count[i] == 5){
                return 50;
            }
        }
        return 0;
    }

    public int fullHouse(Dice[] dice){
        int[] count = new int[7];
        for(int i = 0; i < dice.length; i++){
            count[dice[i].getNum()]++;
        }
        int twos = 0;
        int threes = 0;
        for(int i = 1; i <= 6; i++){
            if(count[i] == 2){
                twos = i;
            }
            if(count[i] == 3){
                threes = i;
            }
        }
        if(twos > 0 && threes > 0){
            return 25;
        }
        return 0;
    }

    public int chance(Dice[] dice){
        int total = 0;
        for(int i = 0; i < dice.length; i++){
            total += dice[i].getNum();
        }

        return total;
    }

    public int straightSmall(Dice[] dice) {
        if(checkDiceSimple(dice, 1) == 1 && checkDiceSimple(dice, 2) == 2 && checkDiceSimple(dice, 3) == 3 
        && checkDiceSimple(dice, 4) == 4) {
            return 30;
        } else if(checkDiceSimple(dice, 2) == 2 && checkDiceSimple(dice, 3) == 3 
        && checkDiceSimple(dice, 4) == 4 && checkDiceSimple(dice, 5) == 5) {
            return 30;
        } else if(checkDiceSimple(dice, 6) == 6 && checkDiceSimple(dice, 3) == 3 
        && checkDiceSimple(dice, 4) == 4 && checkDiceSimple(dice, 5) == 5) {
            return 30;
        }
        return 0;
    }

    public int straightLarge(Dice[] dice) {
        if(checkDiceSimple(dice, 1) == 1 && checkDiceSimple(dice, 2) == 2 && checkDiceSimple(dice, 3) == 3 
        && checkDiceSimple(dice, 4) == 4 && checkDiceSimple(dice, 5) == 5) {
            return 40;
        } else if(checkDiceSimple(dice, 6) == 6 && checkDiceSimple(dice, 2) == 2 && checkDiceSimple(dice, 3) == 3 
        && checkDiceSimple(dice, 4) == 4 && checkDiceSimple(dice, 5) == 5) {
            return 40;
        }

        return 0;
    }
}
