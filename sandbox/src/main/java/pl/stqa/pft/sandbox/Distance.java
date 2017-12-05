package pl.stqa.pft.sandbox;

public class Distance {

  public static void main(String[] args) {

    Point p1 = new Point(-17, 8);
    Point p2 = new Point(1, 7);

  double wynik = Math.sqrt ((p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y) );

    System.out.println("Distance beetween point A (" + p1.x + " , " + p1.y + ") and point B (" + p2.x + " , " + p2.y + ") = " + wynik );


  }
}
