import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TurnTest {
	 MainFrame m;

	
	 @BeforeEach
	 public void setUp() {
		 m = new MainFrame();
	 }
	 
	 @After
	 public void end() {
		 m = null;
	 }

	
	public void diceInput(int num1, int num2, int num3, int num4, int num5) {
		m.g.allDice[0].setNum(num1);
		m.g.allDice[1].setNum(num2);
		m.g.allDice[2].setNum(num3);
		m.g.allDice[3].setNum(num4);
		m.g.allDice[4].setNum(num5);
		
	}
	
	@Test
	void testNewTurn() {
		m.s.startNewRound(m.gd, m.g);
		assertEquals(3,  m.g.t.rollNum);
		m.g.t.roll(m.g.allDice);
		assertEquals(2,  m.g.t.rollNum);

	}
	
	@Test
	void testTurnOnesYahtzee() {
		m.s.startNewRound(m.gd, m.g);
		diceInput(1,1,1,1,1);
		for(Dice d : m.g.allDice) {
			d.setSaved(true);
		}
		m.s.scoreTable(m.gd, m.g);
		assertEquals(5, m.gd.table1.getValueAt(0, 1));
		assertEquals(50, m.gd.table1.getValueAt(14, 1));
	}
	
	@Test
	void testTurnTwoFiveSixOne() {
		m.s.startNewRound(m.gd, m.g);
		diceInput(2,5,6,1,2);
		for(Dice d : m.g.allDice) {
			d.setSaved(true);
		}
		m.s.scoreTable(m.gd, m.g);
		assertEquals(1, m.gd.table1.getValueAt(0, 1));
		assertEquals(4, m.gd.table1.getValueAt(1, 1));
		assertEquals(5, m.gd.table1.getValueAt(4, 1));
		assertEquals(6, m.gd.table1.getValueAt(5, 1));

	}
	
	@Test
	void testTurnSixSixSixFourFour() {
		m.s.startNewRound(m.gd, m.g);
		diceInput(6,6,6,4,4);
		for(Dice d : m.g.allDice) {
			d.setSaved(true);
		}
		m.s.scoreTable(m.gd, m.g);
		assertEquals(18, m.gd.table1.getValueAt(5, 1));
		assertEquals(8, m.gd.table1.getValueAt(3, 1));
		assertEquals(25, m.gd.table1.getValueAt(10, 1));
		assertEquals(26, m.gd.table1.getValueAt(8, 1));

	}

	@Test
	void testTurnOneToFive() {
		m.s.startNewRound(m.gd, m.g);
		diceInput(1,2,3,4,5);
		for(Dice d : m.g.allDice) {
			d.setSaved(true);
		}
		m.s.scoreTable(m.gd, m.g);
		assertEquals(30, m.gd.table1.getValueAt(11, 1));
		assertEquals(40, m.gd.table1.getValueAt(12, 1));

	}
	@Test 
	void testTurnYahtzeeBonus() {
		m.s.startNewRound(m.gd, m.g);
		diceInput(3,3,3,3,3);
		for(Dice d : m.g.allDice) {
			d.setSaved(true);
		}
		m.s.scoreTable(m.gd, m.g);
		m.scoring(14,m.gd.table1.getValueAt(14, 1), true, m.gd.table1.getValueAt(14, 1));
		assertEquals(50, m.gd.table1.getValueAt(14, 1));
		
		//next round
		m.s.startNewRound(m.gd, m.g);
		diceInput(2,2,2,2,2);
		for(Dice d : m.g.allDice) {
			d.setSaved(true);
		}
		m.s.scoreTable(m.gd, m.g);
		m.scoring(1, m.gd.table1.getValueAt(14, 1), true, 50);
		assertEquals(100, m.gd.table1.getValueAt(15, 1));

	}

}
