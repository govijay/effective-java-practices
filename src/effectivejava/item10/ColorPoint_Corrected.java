package effectivejava.item10;

import java.awt.Point;
import java.awt.*;
import java.util.Objects;

/*
*  Add a value component without violating the equals contracts.
*
* */

public class ColorPoint_Corrected {

    private final Point point;
    private final Color color;

    public ColorPoint_Corrected(int x,int y,Color color){
        this.point = new Point(x,y);
        this.color = Objects.requireNonNull(color);
    }

    /*
    * Returns the point-view of this color point.
    *
    * */

    public Point asPoint(){
        return point;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ColorPoint_Corrected))
            return false;
        ColorPoint_Corrected colorPoint_corrected = (ColorPoint_Corrected) obj;
        return colorPoint_corrected.point.equals(point) && colorPoint_corrected.color.equals(color);
    }


    public static void main(String[] args) {
        ColorPoint_Corrected cp1 = new ColorPoint_Corrected(0,1,Color.RED);
        Point p = new Point(0,1);
        ColorPoint_Corrected cp3 = new ColorPoint_Corrected(0,1,Color.RED);
        ColorPoint_Corrected cp2 = new ColorPoint_Corrected(0,1,Color.BLACK);

        System.out.println(cp1.equals(cp2));

        System.out.println(cp1.equals(cp3));

        System.out.println(cp1.equals(p));

    }
}
