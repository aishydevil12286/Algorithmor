package misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindSquaresIn2D {
    static class Point{
        double x,y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;

            Point point = (Point) o;

            if (Double.compare(point.x, x) != 0) return false;
            if (Double.compare(point.y, y) != 0) return false;

            return true;
        }
        @Override
        public int hashCode() {
            int result;
            long temp;
            temp = Double.doubleToLongBits(x);
            result = (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(y);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }

        @Override
        public String toString() {
            return "{" +x +"," + y +'}';
        }
    }
    static class Line{
        Point a,b;
        Line(Point a, Point b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public String toString() {
            return "{" + a +"|" + b +'}';
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Line that = (Line) o;
            return  (this.a.equals(that.a) && this.b.equals(that.b) ||
                    this.a.equals(that.b) && this.b.equals(that.a));
        }

        @Override
        public int hashCode() {
            return (int) (a.x*a.y+b.x*b.y);
        }
    }
    static List<Point> all = new ArrayList<Point>();
            static{all.add(new Point(0,0));
            all.add(new Point(0,2));
            all.add(new Point(1,1));
            all.add(new Point(1,-1));
            all.add(new Point(2,2));
            all.add(new Point(2,0));
            all.add(new Point(2,1));
            all.add(new Point(1,2));
            all.add(new Point(1.1,2.7));
            all.add(new Point(-1,-1));}
     
    public static void main(String[] args) throws InterruptedException {
        Map<Double,Set<Line>> m = new HashMap<Double,Set<Line>>();
        for (int i = 0; i < all.size()-1; i++) {
            Point a = all.get(i);
            for (int j = i+1; j < all.size(); j++) {
                Point b = all.get(j);
                if (a.equals(b)) continue ;
                Double slope = checkForNegativeExtremes( (a.y - b.y) / (a.x - b.x) );
                Set<Line> l = m.get(slope);
                if (l==null){
                    m.put(slope, l = new HashSet());
                }
                l.add(new Line(a, b));
            }
        }
        for(Double slope : new ArrayList<Double>( m.keySet())){
            Set<Line> lTmp = m.get(slope);
            if (lTmp==null || lTmp.size()<=1) continue ;
            Double slopePerpendicular = checkForNegativeExtremes(-1. / slope);

            Set<Line> perpendiculars = m.remove(slopePerpendicular);
            if (perpendiculars==null || perpendiculars.size()<=1) continue ;
            List<Line> l = new ArrayList<Line>(lTmp);
            for (int i = 0; i < l.size()-1; i++) {
                Line l1 = l.get(i);
                for (int j = i+1; j < l.size(); j++) {
                    Line l2 = l.get(j);
                    if (perpendiculars.contains(new Line(l1.a,l2.a)) && perpendiculars.contains(new Line(l1.b,l2.b))
                            // just in case we got them crossed here try the other way too.
                            || perpendiculars.contains(new Line(l1.a,l2.b)) && perpendiculars.contains(new Line(l1.b,l2.a))){
                        System.out.println(l1.a+" "+l1.b+" "+l2.a+" "+l2.b+" form a square");
                    }
                }
            }
        }
        Thread.sleep(1000);
        System.exit(0);
    }

    private static Double checkForNegativeExtremes(Double slope) {
        if (slope.isInfinite() || slope.equals(-0.0)){
            slope = Math.abs(slope); // this handles horizontal and perpendicular lines, dont want to differential between 0. and -0.
        }
        return slope;
    }
}
