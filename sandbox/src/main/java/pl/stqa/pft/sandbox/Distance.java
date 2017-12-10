package pl.stqa.pft.sandbox;

public class Distance {

  public static void main(String[] args) {

    Point p1 = new Point(-17, 8);
    Point p2 = new Point(1, 7);
    Point p3 = new Point (4,8);

  double wynik  = Point.distance(p1,p2);

    System.out.println("Distance beetween point A (" + p1.x + " , " + p1.y + ") and point B (" + p2.x + " , " + p2.y + ") = " + wynik );

  }
}
