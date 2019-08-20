package effectivejava.item10;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

 /*  @Override public boolean equals(Object o){
        if(!(o instanceof Point))
            return false;
        Point p = (Point) o;
        return p.x == x && p.y == y;
   }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }



}
