import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiceTest {

	 MainFrame m;

	    @BeforeEach
	    public void setUp() {
	    	m = new MainFrame();
	    }

	    @Test
	    public void testGetNum() {
	    	m.g.allDice[1].setNum(2);
	    	assertEquals(2, m.g.allDice[1].getNum());
	    }

	    @Test
	    public void testSetNum() {
	    	m.g.allDice[0].setNum(5);
	        assertEquals(5, m.g.allDice[0].getNum());
	    }
	    
	    @Test
	    public void testIsSaved() {
	    	m.g.allDice[0].setSaved(false);
	        assertFalse(m.g.allDice[0].isSaved());
	    }
	    
	    @Test
	    public void testSetDice() {
	    	m.g.setDice(0, 3);
	        assertEquals(3, m.g.getAllDice()[0].getNum());
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
