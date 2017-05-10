package testSuites;

import static org.junit.Assert.*;

import org.junit.Test;
import items.Wood;
import mobs.Inventory;

public class InventoryTest {

	@Test
	public void CountItemWorks() {
		Inventory i = new Inventory();
		Wood w = new Wood();
		i.addItem(w);
		
		int expected = 1;
		int actual = i.countItems(w.getClass());
		assertEquals(expected, actual);
	}
}
