package graphics;

import java.awt.geom.Path2D;

public class FrontSide extends Path2D.Double {
    public FrontSide(double width, double height, int x, int y) {
        moveTo(x + width/2, y + height/2);
        lineTo(x + width/2, y + height);
        lineTo(x + width, y + height);
        lineTo(x + width, y + height/2);
        closePath();
    }
}