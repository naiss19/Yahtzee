import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Before;
import org.junit.After;


import org.junit.Test;

public class GameTest {
    MainFrame m;

    public int randomDice() {
        Random random = new Random();
        return 1 + random.nextInt(6);
    }

    @Before
    public void createGame() {
        m = new MainFrame();
    }

    public void testSimple(int num) {
        for(int i = 0; i < m.g.allDice.length; i++) {
            m.g.allDice[i].setNum(num);
        }
        
    }

    
    @After
    public void endGame() {
        m = null;
    }

    @Test
    public void testOnes() {
        testSimple(1);
        assertEquals("One's failed", 5, m.g.t.ones(m.g.allDice));
    }

    @Test
    public void testTwos() {
        testSimple(2);
        assertEquals("Two's Failed", m.g.t.twos(m.g.allDice), 10);
    }

    @Test
    public void testThrees() {
        testSimple(3);
        assertEquals("Three's Failed", m.g.t.threes(m.g.allDice), 15);
    }
    @Test
    public void testFours() {
        testSimple(4);
        assertEquals("Four's Failed", m.g.t.fours(m.g.allDice), 20);
    }
    @Test
    public void testFives() {
        testSimple(5);
        assertEquals("Five's Failed", m.g.t.fives(m.g.allDice), 25);
    }
    @Test
    public void testSixes() {
        testSimple(6);
        assertEquals("Six's Failed", m.g.t.sixes(m.g.allDice), 30);
    }
    @Test
    public void testUpperTotal() {
        int randTotal = 0;
        for (int i = 0; i < 5; i++) {
                int diceNum = randomDice();
                m.g.setDice(i, diceNum);
                randTotal += diceNum;
        }
        m.g.upperPoint += m.g.t.chance(m.g.allDice);
        assertEquals("Upper Total Failed", randTotal, m.g.upperPoint);

    }
    @Test
    public void testBonus() {
        m.g.upperPoint = 64;
        m.upperBonus();
        assertEquals("Upper Bonus Failed", 99, m.g.totalPoints + m.g.upperPoint);
        
    }
    @Test
    public void test3ofKind() {
        int randNum = (int) (Math.random() * (6 - 1) + 1);
        int total = 0;
        for(int i = 0; i < 3; i++) {
            m.g.allDice[i].setNum(randNum);
            total+= randNum;
        }
        total+=m.g.allDice[3].getNum();
        total+=m.g.allDice[4].getNum();

        assertEquals("3 of a kind not available", total, m.g.t.threeKind(m.g.allDice));
        
    }
    @Test
    public void test4ofKind() {

        int randNum = (int) (Math.random() * (6 - 1) + 1);
        int total = 0;
        for(int i = 0; i < 4; i++) {
            m.g.allDice[i].setNum(randNum);
            total+= randNum;
        }

        total+=m.g.allDice[4].getNum();

        assertEquals("3 of a kind not available", total, m.g.t.fourKind(m.g.allDice));
        
    }

    @Test
    public void testSmStraight() {

        for(int i = 0; i < 4; i++) {
            m.g.allDice[i].setNum(i+1);
            // System.out.println(m.g.allDice[i].getNum());
        }
        assertEquals("3 of a kind not available", 30, m.g.t.straightSmall(m.g.allDice));

        for(int i = 0; i < 4; i++) {
            m.g.allDice[i].setNum(i+2);

        }
        assertEquals("3 of a kind not available", 30, m.g.t.straightSmall(m.g.allDice));

        for(int i = 0; i < 4; i++) {
            m.g.allDice[i].setNum(i+3);
        }
        assertEquals("3 of a kind not available", 30, m.g.t.straightSmall(m.g.allDice));
    }
    @Test
    public void testLgStraight() {
        fail("Unimplemented Method");
    }
    @Test
    public void testChance() {
        fail("Unimplemented Method");
    }
    @Test
    public void testYahtzee() {
        fail("Unimplemented Method");
    }

    @Test
    public void testYahtzeeBonus() {
        fail("Unimplemented Method");
    }
    @Test
    public void testLowerTotal() {
        fail("Unimplemented Method");
    }
    @Test
    public void testTotalPoints() {
        fail("Unimplemented Method");
    }

}
