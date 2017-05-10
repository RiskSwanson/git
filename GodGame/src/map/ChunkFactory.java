package map;

import java.util.LinkedList;

public class ChunkFactory {
	CellFactory cellFactory = new CellFactory();
	public Chunk createChunk (int chunkHeight, int chunkWidth, int chunkX, int chunkY){
		int cellZ = 0;
		Chunk myReturn = new Chunk();
		
		for (int yPosition = 0;yPosition<chunkHeight;yPosition++){
			LinkedList<Cell> myRow = new LinkedList<Cell>();
			for (int xPosition = 0;xPosition<chunkWidth;xPosition++){
				int cellY = yPosition + chunkY;
				int cellX = xPosition + chunkX;
				Cell myCell = cellFactory.CreateCell(cellX,cellY,cellZ, "Soil");
				myRow.add(myCell);
			}
			myReturn.add(myRow);
		}
		return myReturn;
	}
}
