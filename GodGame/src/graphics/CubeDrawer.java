package graphics;

import java.awt.Color;
import java.awt.Graphics2D;

import map.Cell;
import map.Chunk;

public class CubeDrawer {
	
	Graphics2D graphics2d;
	private final int SIZE = 40;
	private ShapeFactory shapeFactory = new ShapeFactory();
	
	public void drawCubes (Graphics2D myGraphics2D, Chunk chunk){
		graphics2d = myGraphics2D;
		
		int xPosit = 200 + (chunk.x*SIZE/2*chunk.cells.length) - (chunk.y*SIZE/2*chunk.cells[0].length);
		int yPosit = 5- (chunk.z*SIZE/2*chunk.cells[0][0].length) + (chunk.y*SIZE/4*chunk.cells[0].length)+  (chunk.x*SIZE/4*chunk.cells.length) ;
		
				
		for (int x= 0; x < chunk.cells.length; x++){
			for (int y = 0; y<(chunk.cells[0].length);y++){
				for (int z = 0;z<(chunk.cells[0][0].length);z++){
					Cell myCell = chunk.cells[x][y][z];
					if (myCell.isActive){
						int cellX = xPosit + (x*SIZE/2) - (y*SIZE/2);
						int cellY = yPosit - (z*SIZE/2 ) + (y*SIZE/4) + (x*SIZE/4);
						
						Color left;
						Color right;
						Color top;
						
						switch(myCell.cellType){
						case DIRT:
							left = new Color(116, 49, 0);
							right = new Color(136, 69, 19);
							top = new Color(146, 79, 39);
							break;
							
						case GRASS:
							left = new Color(116, 49, 0);
							right = new Color(136, 69, 19);
							top = Color.GREEN;
							break;
							
						default:
							left = Color.GRAY;
							right = Color.DARK_GRAY;
							top = Color.LIGHT_GRAY;
							break;
						}
						
						if (myCell.cellType == Cell.CellType.DIRT){
							drawCube(SIZE, SIZE, cellX, cellY, left, right, top);
						}
					}
				}
			}
		}
	}
	
	private void drawCube(int w, int h, int x, int y, Color left, Color right, Color top){

		graphics2d.setColor(top);
		shapeFactory.createShape(graphics2d, ShapeFactory.Shapes.TOPSIDE, w, h, x, y);
		
		graphics2d.setColor(right);
		shapeFactory.createShape(graphics2d, ShapeFactory.Shapes.RIGHTSIDE, w, h, x, y);
		
		graphics2d.setColor(left);
		shapeFactory.createShape(graphics2d, ShapeFactory.Shapes.LEFTSIDE, w, h, x, y);
	}
}
