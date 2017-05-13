package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import map.Cell;
import map.Chunk;
import map.ChunkFactory;

class Canvas extends JComponent {

	public void paint(Graphics graphics) {
		Graphics myGraphics = graphics;
		Graphics2D myGraphics2D = (Graphics2D) myGraphics;
		drawCube(myGraphics2D);
	}
	
	private void drawCube(Graphics2D myGraphics2d){
		
		int chunkDepth = 10;
		int chunkWidth = 20;
		int chunkHeight = 5;
		
		CubeDrawer cd = new CubeDrawer();
		/*
		cd.graphics2d = myGraphics2d;
		cd.drawCube(40, 40, 40, 40, Color.GRAY, Color.BLACK, Color.LIGHT_GRAY, Color.DARK_GRAY);
		*/
		ChunkFactory chunkFactory = new ChunkFactory();
		
		Chunk chunk = chunkFactory.createChunk (chunkDepth, chunkWidth, chunkHeight, 0, -1, -3);
		cd.drawCubes(myGraphics2d, chunk);
		Chunk chunk3 = chunkFactory.createChunk(chunkDepth, chunkWidth, chunkHeight, 0, -2, -2);
		cd.drawCubes(myGraphics2d, chunk3);
		
		Chunk chunk2 = chunkFactory.createChunk(chunkDepth, chunkWidth, chunkHeight,  0, -1, -2);
		chunk2.cells[17][8][4].isActive = false;
		chunk2.cells[17][9][4].isActive = false;
		chunk2.cells[18][9][4].isActive = false;
		chunk2.cells[17][9][3].isActive = false;
		chunk2.cells[15][9][4].cellType = Cell.CellType.GRASS;
		chunk2.cells[15][9][3].cellType = Cell.CellType.STONE;
		chunk2.cells[14][9][3].cellType = Cell.CellType.STONE;
		cd.drawCubes(myGraphics2d, chunk2);
		
		Chunk chunk4 = chunkFactory.createChunk(chunkDepth, chunkWidth, chunkHeight, 1, -1, -2);
		cd.drawCubes(myGraphics2d, chunk4);
		
		//ShapeFactory sf = new ShapeFactory();
		//sf.createShape(myGraphics2d, ShapeFactory.Shapes.TOPSIDE, 40, 40, 5, 5);
	}
}