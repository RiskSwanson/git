package graphics;

import java.awt.geom.Path2D;

public class RightSide extends Path2D.Double {
    public RightSide(double width, double height, int x, int y) {
        moveTo(x + width, y + height/4);
        lineTo(x + width, y + height/2+ height/4);
        lineTo(x + width /2, y + height);
        lineTo(x + width /2, y + height/2);
        closePath();
    }
}