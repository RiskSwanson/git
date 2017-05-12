package testSuites;

import static org.junit.Assert.*;

import org.junit.Test;

import map.Cell;
import map.Soil;

public class CellTest {

	int z = 0;
	
	@Test
	public void testX() {
		int x = 1;
		int y = 2;
		Cell c = new Soil(x, y, z);
		//assertEquals(x ,c.getX());
	}
	
	@Test
	public void testY() {
		int x = 1;
		int y = 2;
		Cell c = new Soil(x, y, z);
		//assertEquals(y ,c.getY());
	}

}
