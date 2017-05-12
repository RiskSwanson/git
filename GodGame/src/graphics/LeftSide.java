package graphics;

import java.awt.geom.Path2D;

public class LeftSide extends Path2D.Double {
    public LeftSide(double width, double height, int x, int y) {
        moveTo(x, y + height/4);
        lineTo(x , y + height/2+ height/4);
        lineTo(x + width /2,y + height);
        lineTo(x + width /2,y + height/2);
        closePath();
    }
}