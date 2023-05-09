import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiceTest {

	MainFrame m;

	@BeforeEach
	public void setUp() {
		m = new MainFrame();	
	}

	@After
	public void end() {
		m = null;
	}

	@Test
	public void testClearDice() {
		m.g.setDice(0, 4);
		m.g.setDice(1, 2);
		m.g.setDice(2, 5);
		m.g.setDice(3, 7);
		m.g.setDice(4, 5);
		m.g.clearDice();
		for (Dice d : m.g.getAllDice()) {
			assertFalse(d.isSaved());
		}
	}
	@Test 
	public void testSaved() {
		m.g.setDice(3, 3);
		m.g.setDice(4, 2);
		m.g.allDice[3].setSaved(true);
		m.g.allDice[4].setSaved(true);
		m.s.setImages(m.gd, m.g); //rolls the dice
		assertEquals(3, m.g.getAllDice()[3].getNum());
		assertEquals(2, m.g.getAllDice()[4].getNum());

	}
}
