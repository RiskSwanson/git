package map;

import java.util.LinkedList;

public class ChunkFactory {
	CellFactory cellFactory = new CellFactory();
	public Chunk createChunk (int chunkDepth, int chunkWidth, int chunkHeight, int chunkX, int chunkY, int chunkZ){
		
		Chunk myReturn = new Chunk(chunkX, chunkY, chunkZ);
		myReturn.cells = new Cell [chunkWidth][chunkDepth][chunkHeight];
		for (int zPosition = 0;zPosition<chunkHeight;zPosition++){
			for (int yPosition = 0;yPosition<chunkDepth;yPosition++){
				for (int xPosition = 0;xPosition<chunkWidth;xPosition++){
					boolean active = true;
					Cell myCell = cellFactory.CreateCell(active, Cell.CellType.DIRT);
					myReturn.cells[xPosition][yPosition][zPosition] = myCell;
				}	
			}
		}
		
		return myReturn;
	}
}
