package graphics;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex3f;

import java.awt.Color;

import map.Cell;
import map.Chunk;

public class CubeFactory {
	
	private final float SIZE = 0.2f; 
	private final float POINT_LENGTH = 0.866f;
	
	public void createCube(Chunk chunk){
		
		float xPosit = (chunk.x*SIZE*chunk.cells.length*2) + (chunk.y*SIZE*chunk.cells[0].length*1.732f*2) -0.9f;
		float yPosit = (chunk.y*SIZE*chunk.cells[0].length*1.433f);
		float zPosit = (chunk.z*SIZE*2*chunk.cells[0][0].length);
		
		for (int x= 0; x < chunk.cells.length; x++){
			for (int y = 0; y<(chunk.cells[0].length);y++){
				for (int z = 0;z<(chunk.cells[0][0].length);z++){
					Cell myCell = chunk.cells[x][y][z];
					
					float cellX = xPosit + (1.732f*SIZE *x*2)+ (y*SIZE*1.732f);
					float cellY = yPosit + (SIZE*2*1.433f*y);
					float cellZ = zPosit + (SIZE*2*z);
					
					if (myCell.isActive){
						Color left;
						Color right;
						Color top;
						Color front;
						
						switch(myCell.cellType){
						case DIRT:
							front = new Color(116, 49, 0);
							right = new Color(106, 39, 0);
							left = new Color(136, 69, 19);
							top = new Color(146, 79, 39);
							break;
							
						case GRASS:
							front = new Color(116, 49, 0);
							right = new Color(106, 39, 0);
							left = new Color(136, 69, 19);
							top = Color.GREEN;
							break;
						
						case STONE:
							left = Color.GRAY;
							right = Color.BLACK;
							top = Color.LIGHT_GRAY;
							front = Color.DARK_GRAY;
							break;
							
						default:
							left = Color.GRAY;
							right = Color.BLACK;
							top = Color.LIGHT_GRAY;
							front = Color.DARK_GRAY;
							break;
						}
						
						//drawCube(SIZE, SIZE, cellX, cellY, left, right, top, front);
						boolean zNegative = false;
						if (z>0)
							zNegative = chunk.cells[x][y][z-1].isActive;
						
						boolean zPositive = false;
						if (z<chunk.cells[0][0].length-1)
							zPositive = chunk.cells[x][y][z+1].isActive;
						
						boolean x1Positive = false;
						if (x<chunk.cells.length-1)
							x1Positive = chunk.cells[x+1][y][z].isActive;
						
						boolean x1Negative = false;
						if (x>0)
							x1Negative = chunk.cells[x-1][y][z].isActive;
						
						boolean y1Positive = false;
						if (y<chunk.cells[0].length-1)
							y1Positive = chunk.cells[x][y+1][z].isActive;
						
						boolean y1Negative = false;
						if (y>0)
							y1Negative = chunk.cells[x][y-1][z].isActive;
						
						boolean x2Negative = false;
						if (y>0&&x<chunk.cells.length-1)
								x2Negative = chunk.cells[x+1][y-1][z].isActive;
						
						boolean x2Positive = false;
						if (y<chunk.cells[0].length-1&&x>0)
							x2Positive = chunk.cells[x-1][y+1][z].isActive;

						renderDiamond(cellX, cellY, cellZ, zNegative, zPositive, x1Positive, x1Negative, y1Positive, y1Negative, x2Negative, x2Positive);
					}
				}
			}
		}
	}
	
	public void renderDiamond(float x, float y, float z, boolean zNegative, boolean zPositive, boolean x1Positive, boolean x1Negative, boolean y1Positive, boolean y1Negative, boolean x2Negative, boolean x2Positive){
    	/* Render cube */
		float SIZE = 0.2f;
		
        glBegin(GL_TRIANGLES);
        float point = POINT_LENGTH * SIZE;
        float recalculatedSize = POINT_LENGTH*2*SIZE;
        
        if (!zPositive){
	        //top one
	        glColor3f(1.0f,0.0f,0.0f);
	        glVertex3f( x+recalculatedSize,y+ SIZE,z+ SIZE);
	        glVertex3f(x-recalculatedSize, y+SIZE, z+SIZE);
	        glVertex3f(x-recalculatedSize,y-SIZE, z+SIZE);
	        
	        glVertex3f(x+ recalculatedSize,y-SIZE,z+ SIZE);
	        glVertex3f(x+ recalculatedSize, y+SIZE,z+ SIZE);
	        glVertex3f(x-recalculatedSize,y-SIZE,z+ SIZE);
	        
	        glVertex3f(x+recalculatedSize, y+SIZE, z+SIZE);
	        glVertex3f(x, y+SIZE+point, z+SIZE);
	        glVertex3f(x-recalculatedSize, y+SIZE, z+SIZE);
	        
	        glVertex3f(x+recalculatedSize, y-SIZE, z+SIZE);
	        glVertex3f(x, y-SIZE-point, z+SIZE);
	        glVertex3f(x-recalculatedSize, y-SIZE, z+SIZE);
        }
        
        if (!zNegative){
        	//bottom two
	        glColor3f(1.0f,0.0f,0.0f);
	        glVertex3f( x+recalculatedSize,y+ SIZE,z- SIZE);
	        glVertex3f(x-recalculatedSize, y+SIZE, z-SIZE);
	        glVertex3f(x-recalculatedSize,y-SIZE, z-SIZE);
	        
	        glVertex3f(x+ recalculatedSize,y-SIZE,z- SIZE);
	        glVertex3f(x+ recalculatedSize, y+SIZE,z- SIZE);
	        glVertex3f(x-recalculatedSize,y-SIZE,z- SIZE);
	        
	        glVertex3f(x+recalculatedSize, y+SIZE, z-SIZE);
	        glVertex3f(x, y+SIZE+point, z-SIZE);
	        glVertex3f(x-recalculatedSize, y+SIZE, z-SIZE);
	        
	        glVertex3f(x+recalculatedSize, y-SIZE, z-SIZE);
	        glVertex3f(x, y-SIZE-point, z-SIZE);
	        glVertex3f(x-recalculatedSize, y-SIZE, z-SIZE);
        }
        
        if (!x1Negative){
	        //side three
	        glColor3f(0.0f,1.0f,0.0f);
	        glVertex3f( x-recalculatedSize,y+ SIZE,z+ SIZE);
	        glVertex3f(x-recalculatedSize, y+SIZE, z-SIZE);
	        glVertex3f(x-recalculatedSize,y-SIZE, z-SIZE);
	        
	        glVertex3f(x- recalculatedSize,y-SIZE,z+ SIZE);
	        glVertex3f(x- recalculatedSize, y+SIZE,z+ SIZE);
	        glVertex3f(x-recalculatedSize,y-SIZE,z- SIZE);
        }

        if (!x1Positive){
        //side four
	        glColor3f(0.0f,1.0f,0.0f);
	        glVertex3f( x+recalculatedSize,y+ SIZE,z+ SIZE);
	        glVertex3f(x+recalculatedSize, y+SIZE, z-SIZE);
	        glVertex3f(x+recalculatedSize,y-SIZE, z-SIZE);
	        
	        glVertex3f(x+ recalculatedSize,y-SIZE,z+ SIZE);
	        glVertex3f(x+ recalculatedSize, y+SIZE,z+ SIZE);
	        glVertex3f(x+recalculatedSize,y-SIZE,z- SIZE);
        }
        
        if (!y1Positive){
	        //side five
	        glColor3f(0.0f,0.0f,1.0f);
	        glVertex3f( x+recalculatedSize,y+SIZE,z+ SIZE);
	        glVertex3f(x, y+SIZE+point, z+SIZE);
	        glVertex3f(x+recalculatedSize,y+SIZE, z-SIZE);
	        
	        glVertex3f( x+recalculatedSize,y+SIZE,z- SIZE);
	        glVertex3f(x, y+SIZE+point, z+SIZE);
	        glVertex3f(x,y+SIZE+point, z-SIZE);
        }
        
        if (!y1Negative){
	        //side six
	        glColor3f(0.0f,0.0f,1.0f);
	        glVertex3f( x-recalculatedSize,y-SIZE,z+ SIZE);
	        glVertex3f(x, y-SIZE-point, z+SIZE);
	        glVertex3f(x-recalculatedSize,y-SIZE, z-SIZE);
	        
	        glVertex3f( x-recalculatedSize,y-SIZE,z- SIZE);
	        glVertex3f(x, y-SIZE-point, z+SIZE);
	        glVertex3f(x,y-SIZE-point, z-SIZE);
        }
        
        if (!x2Negative){
        	//side seven
	        glColor3f(0.0f,1.0f,1.0f);
	        glVertex3f( x+recalculatedSize,y-SIZE,z+ SIZE);
	        glVertex3f(x, y-SIZE-point, z+SIZE);
	        glVertex3f(x+recalculatedSize,y-SIZE, z-SIZE);
	        
	        glVertex3f( x+recalculatedSize,y-SIZE,z- SIZE);
	        glVertex3f(x, y-SIZE-point, z+SIZE);
	        glVertex3f(x,y-SIZE-point, z-SIZE);
        }
        
        if (!x2Positive){
	        //side five
	        glColor3f(0.0f,1.0f,1.0f);
	        glVertex3f( x-recalculatedSize,y+SIZE,z+ SIZE);
	        glVertex3f(x, y+SIZE+point, z+SIZE);
	        glVertex3f(x-recalculatedSize,y+SIZE, z-SIZE);
	        
	        glVertex3f( x-recalculatedSize,y+SIZE,z- SIZE);
	        glVertex3f(x, y+SIZE+point, z+SIZE);
	        glVertex3f(x,y+SIZE+point, z-SIZE);
        }
        
        glEnd();
    }
}
