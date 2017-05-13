package graphics;

import java.awt.Graphics2D;
import java.awt.geom.Path2D;

public class ShapeFactory {
	public enum Shapes {TOPSIDE, LEFTSIDE, RIGHTSIDE, FRONTSIDE};
	
	public void createShape(Graphics2D graphics2d, Shapes shapeType, int w, int h, int x, int y){
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
		case FRONTSIDE:
			shape = new FrontSide(w, h, x ,y);
			break;
		default:
			shape = null;
			break;
		}
		
		if (shape!=null)
			graphics2d.fill(shape);
	}
}
