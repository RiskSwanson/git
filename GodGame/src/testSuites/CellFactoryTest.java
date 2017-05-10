package testSuites;

import static org.junit.Assert.*;

import org.junit.Test;

import map.Cell;
import map.CellFactory;

public class CellFactoryTest {

	int z = 0;
	
	@Test
	public void CellFactory_CreateCell_CellHasCorrectX() {
		int x = 1;
		int y = 2;
		CellFactory cf = new CellFactory();
		Cell c = cf.CreateCell(x, y, z, "Soil");
		assertEquals(x, c.getX());
	}
	
	@Test
	public void CellFactory_CreateCell_CellHasCorrectY() {
		int x = 1;
		int y = 2;
		CellFactory cf = new CellFactory();
		Cell c = cf.CreateCell(x, y, z, "Soil");
		assertEquals(y, c.getY());
	}
}
