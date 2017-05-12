package graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

import map.Cell;
import map.Chunk;

public class CubeDrawer {
	
	Graphics2D graphics2d;
	private final int SIZE = 40;
	private enum Shapes {TOPSIDE, LEFTSIDE, RIGHTSIDE};
	
	public void drawCubes (Graphics2D myGraphics2D, Chunk chunk){
		int xPosit = 200;
		int yPosit = 200;
		for (int x= 0; x < chunk.cells.length; x++){
			for (int y = 0; y<(chunk.cells[x].length);y++){
				for (int z = 0;z<(chunk.cells[x][y].length);z++){
					if (chunk.cells[x][y][z].active ==true)
						drawCube(myGraphics2D, SIZE, SIZE, xPosit+ (x*SIZE/2) - (y*SIZE/2), (yPosit+ x*SIZE/4) -  (z*SIZE/2) + (y*SIZE/4));
				}
			}
		}
	}
	
	private void drawCube(Graphics2D myGraphics2d, int w, int h, int x, int y){
		graphics2d = myGraphics2d;
		
		graphics2d.setColor(Color.GRAY);
		createShape(Shapes.LEFTSIDE, w, h, x, y);
		
		graphics2d.setColor(Color.DARK_GRAY);
		createShape(Shapes.RIGHTSIDE, w, h, x, y);
		
		graphics2d.setColor(Color.LIGHT_GRAY);
		createShape(Shapes.TOPSIDE, w, h, x, y);
	}
	
	private void createShape(Shapes shapeType, int w, int h, int x, int y){
		Path2D.Double shape;
		switch (shapeType){
		case TOPSIDE:
			shape = new Diamond(w, h, x, y);
			break;
		case LEFTSIDE:
			shape = new LeftSide(w, h, x, y);
			break;
		case RIGHTSIDE:
			shape = new RightSide(w, h, x ,y);
			break;
		default:
			shape = null;
			break;
		}
		
		if (shape!=null)
		drawShape (shape);
	}
	
	private void drawShape(Path2D.Double shape){
		if (shape!=null)
			graphics2d.fill(shape);
	}
}
