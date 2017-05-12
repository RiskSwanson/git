package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

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
		ChunkFactory chunkFactory = new ChunkFactory();
		Chunk chunk = chunkFactory.createChunk (chunkDepth, chunkWidth, chunkHeight, 0, -1, -3);
		cd.drawCubes(myGraphics2d, chunk);
		Chunk chunk3 = chunkFactory.createChunk(chunkDepth, chunkWidth, chunkHeight, 0, -2, -2);
		cd.drawCubes(myGraphics2d, chunk3);
		Chunk chunk2 = chunkFactory.createChunk(chunkDepth, chunkWidth, chunkHeight,  0, -1, -2);
		cd.drawCubes(myGraphics2d, chunk2);
		Chunk chunk4 = chunkFactory.createChunk(chunkDepth, chunkWidth, chunkHeight, 1, -1, -2);
		cd.drawCubes(myGraphics2d, chunk4);
		
		
	}
}