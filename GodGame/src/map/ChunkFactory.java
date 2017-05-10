package map;

import java.util.LinkedList;

public class ChunkFactory {
	CellFactory cellFactory = new CellFactory();
	public Chunk createChunk (int chunkDepth, int chunkWidth, int chunkHeight, int chunkX, int chunkY, int chunkZ){
		
		Chunk myReturn = new Chunk();
		myReturn.cells = new Cell [chunkHeight][chunkDepth][chunkWidth];
		for (int zPosition = 0;zPosition<chunkHeight;zPosition++){
			for (int yPosition = 0;yPosition<chunkDepth;yPosition++){
				for (int xPosition = 0;xPosition<chunkWidth;xPosition++){
					int cellY = yPosition + chunkY;
					int cellX = xPosition + chunkX;
					int cellZ = zPosition + chunkZ;
					Cell myCell = cellFactory.CreateCell(cellX,cellY,cellZ, "Soil");
					myReturn.cells[zPosition][yPosition][xPosition] = myCell;
				}	
			}
		}
		
		return myReturn;
	}
}
