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
		
		CubeDrawer cd = new CubeDrawer();
		ChunkFactory chunkFactory = new ChunkFactory();
		Chunk chunk = chunkFactory.createChunk(10, 10, 10, 0, 0, 0);
		cd.drawCubes(myGraphics2d, chunk);
	}
}