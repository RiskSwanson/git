package testSuites;

import static org.junit.Assert.*;

import org.junit.Test;

import map.Chunk;
import map.ChunkFactory;

public class ChunkFactoryTest {

	@Test
	public void ChunkFactory_CreateChunk_ChunkHasCorrectNumberOfRows() {
		int h = 4;
		int w = 8;
		int x = 0;
		int y = 0;
		
		ChunkFactory cf = new ChunkFactory();
		Chunk c = cf.createChunk(h,w, x, y);
		
		assertEquals(w, c.getFirst().size());
	}
	
	@Test
	public void ChunkFactory_CreateChunk_ChunkHasCorrectNumberOfColumns() {
		int h = 4;
		int w = 8;
		int x = 0;
		int y = 0;
		
		ChunkFactory cf = new ChunkFactory();
		Chunk c = cf.createChunk(h,w, x, y );
		assertEquals(h, c.size());
	}

	@Test
	public void ChunkFactory_CreateChunk_FirstCellOfFirstRowHasCorrectX() {
		int h = 4;
		int w = 8;
		int x = 0;
		int y = 1;
		
		ChunkFactory cf = new ChunkFactory();
		Chunk c = cf.createChunk(h,w, x, y );
		assertEquals(x, c.getFirst().getFirst().getX());
	}
	
	@Test
	public void ChunkFactory_CreateChunk_FirstCellOfFirstRowHasCorrectY() {
		int h = 4;
		int w = 8;
		int x = 0;
		int y = 1;
		
		ChunkFactory cf = new ChunkFactory();
		Chunk c = cf.createChunk(h,w, x, y );
		assertEquals(y, c.getFirst().getFirst().getY());
	}
	
	@Test
	public void ChunkFactory_CreateChunk_LastCellOfFirstRowHasCorrectX() {
		int h = 4;
		int w = 8;
		int x = 0;
		int y = 1;
		
		ChunkFactory cf = new ChunkFactory();
		Chunk c = cf.createChunk(h,w, x, y );
		assertEquals(w+x-1, c.getFirst().getLast().getX());
	}
	
	@Test
	public void ChunkFactory_CreateChunk_LastCellOfFirstRowHasCorrectY() {
		int h = 4;
		int w = 8;
		int x = 0;
		int y = 1;
		
		ChunkFactory cf = new ChunkFactory();
		Chunk c = cf.createChunk(h,w, x, y );
		assertEquals(y, c.getFirst().getLast().getY());
	}
	

	@Test
	public void ChunkFactory_CreateChunk_FirstCellOfLastRowHasCorrectX() {
		int h = 4;
		int w = 8;
		int x = 0;
		int y = 1;
		
		ChunkFactory cf = new ChunkFactory();
		Chunk c = cf.createChunk(h,w, x, y );
		assertEquals(x, c.getLast().getFirst().getX());
	}
	

	@Test
	public void ChunkFactory_CreateChunk_FirstCellOfLastRowHasCorrectY() {
		int h = 4;
		int w = 8;
		int x = 0;
		int y = 1;
		
		ChunkFactory cf = new ChunkFactory();
		Chunk c = cf.createChunk(h,w, x, y );
		assertEquals(h+y-1, c.getLast().getFirst().getY());
	}
	
	@Test
	public void ChunkFactory_CreateChunk_LastCellOfLastRowHasCorrectX() {
		int h = 4;
		int w = 8;
		int x = 0;
		int y = 1;
		
		ChunkFactory cf = new ChunkFactory();
		Chunk c = cf.createChunk(h,w, x, y );
		assertEquals(w+x-1, c.getLast().getLast().getX());
	}
	
	@Test
	public void ChunkFactory_CreateChunk_LastCellOfLastRowHasCorrectY() {
		int h = 4;
		int w = 3;
		int x = 0;
		int y = 1;
		
		ChunkFactory cf = new ChunkFactory();
		Chunk c = cf.createChunk(h,w, x, y );
		assertEquals(h+y-1, c.getLast().getLast().getY());
	}
}
