package effectivejava.item10;

import java.awt.Point;
import java.awt.*;

public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y , Color color){
        super(x,y);
        this.color = color;
    }

    @Override public boolean equals(Object o){
        // to fix 1.
        if(!(o instanceof Point))
            return false;
        // to fix 1. mixed comparisons.
        if(!(o instanceof ColorPoint))
            return o.equals(this);

        // o is a colorpoint and full comparison is done here. but this mixed comparison is still broken.
        // breaks transitivity rule.
        return super.equals(o) && ((ColorPoint)o).color == color;
    }

    public static void main(String[] args) {
        Point p = new Point(1,2);
        Point p1 = new Point(1,2);
        ColorPoint cp = new ColorPoint(1,2,Color.RED);
        ColorPoint cp1 = new ColorPoint(1,2,Color.BLACK);

        System.out.println(p1.equals(p));
        System.out.println(cp.equals(p));
        System.out.println(p.equals(cp1));  // RED != BLUE. but equals return true.

        System.out.println("Point super class equals Color Point class : " + p.equals(cp));

        //1. return false as type argument is incorrect.
        System.out.println("Color Point class equals  Point super class : " + cp.equals(p));
    }
}
