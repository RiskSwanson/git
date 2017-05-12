package testSuites;

import static org.junit.Assert.*;

import org.junit.Test;

import map.Chunk;
import map.ChunkFactory;

public class ChunkFactoryTest {

	int d = 4;
	int w = 8;
	int h = 5;
	int x = 0;
	int y = 1;
	int z = 2;
	
	ChunkFactory cf = new ChunkFactory();
	Chunk c = cf.createChunk(d,w, h, x, y, z);
	
	@Test
	public void ChunkFactory_CreateChunk_ChunkHasCorrectWidth() {
		int expected = w;
		int actual = c.cells[0][0].length;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void ChunkFactory_CreateChunk_ChunkHasCorrectDepth() {
		
		int expected = d;
		int actual = c.cells[0].length;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void ChunkFactory_CreateChunk_ChunkHasCorrectHeight() {
		
		int expected = h;
		int actual = c.cells.length;
		
		assertEquals(expected, actual);
	}
/*
	@Test
	public void ChunkFactory_CreateChunk_FirstCellOfFirstRowHasCorrectX() {
		
		int expected = x;
		int actual = c.cells[0][0][0].getX();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void ChunkFactory_CreateChunk_FirstCellOfFirstRowHasCorrectY() {
		int expected = y;
		int actual = c.cells[0][0][0].getY();
		assertEquals(expected, actual);
	}
	
	@Test
	public void ChunkFactory_CreateChunk_FirstCellOfFirstRowHasCorrectZ() {
		int expected = z;
		int actual = c.cells[0][0][0].getZ();
		assertEquals(expected, actual);
	}
	
	@Test
	public void ChunkFactory_CreateChunk_LastCellOfFirstRowHasCorrectX() {
		int expected = w+x-1;
		int actual = c.cells[0][0][w-1].getX();
		assertEquals(expected, actual);
	}
	
	@Test
	public void ChunkFactory_CreateChunk_LastCellOfFirstRowHasCorrectY() {
		int expected = y;
		int actual = c.cells[0][0][w-1].getY(); 
		assertEquals(expected, actual);
	}

	@Test
	public void ChunkFactory_CreateChunk_FirstCellOfLastRowHasCorrectX() {
		int expected = x;
		int actual = c.cells[0][d-1][0].getX(); 
		assertEquals(expected, actual);
	}
	

	@Test
	public void ChunkFactory_CreateChunk_FirstCellOfLastRowHasCorrectY() {
		int expected = d+y-1;
		int actual = c.cells[0][d-1][0].getY(); 
		assertEquals(expected, actual);
	}
	
	@Test
	public void ChunkFactory_CreateChunk_LastCellOfLastRowHasCorrectX() {
		int expected = w+x-1;
		int actual = c.cells[0][d-1][w-1].getX(); 
		assertEquals(expected, actual);
	}
	
	@Test
	public void ChunkFactory_CreateChunk_LastCellOfLastRowHasCorrectY() {
		int expected = d+y-1;
		int actual = c.cells[0][d-1][w-1].getY(); 
		assertEquals(expected, actual);
	}
	
	@Test
	public void ChunkFactory_CreateChunk_FinalCellHasCorrectY() {
		int expected = d+y-1;
		int actual = c.cells[h-1][d-1][w-1].getY(); 
		assertEquals(expected, actual);
	}
	
	@Test
	public void ChunkFactory_CreateChunk_FinalCellHasCorrectX() {
		int expected = w+x-1;
		int actual = c.cells[h-1][d-1][w-1].getX(); 
		assertEquals(expected, actual);
	}
	
	@Test
	public void ChunkFactory_CreateChunk_FinalCellHasCorrectZ() {
		int expected = h+z-1;
		int actual = c.cells[h-1][d-1][w-1].getZ(); 
		assertEquals(expected, actual);
	}
	*/
}
