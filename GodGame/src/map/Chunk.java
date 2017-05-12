package map;

import java.util.LinkedList;

public class Chunk{
	public Cell[][][] cells;
	public int x;
	public int y;
	public int z;
	
	public Chunk(int chunkX, int chunkY, int chunkZ){
		x = chunkX;
		y = chunkY;
		z = chunkZ;
	}
}
