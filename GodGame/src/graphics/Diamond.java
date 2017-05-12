package graphics;

import java.awt.geom.Path2D;

public class Diamond extends Path2D.Double {
    public Diamond(double width, double height, int x, int y) {
        moveTo(x, y + height / 4);
        lineTo(x + width / 2, y);
        lineTo(x + width, y +height / 4);
        lineTo(x + width / 2, y +height/2);
        closePath();
    }
}