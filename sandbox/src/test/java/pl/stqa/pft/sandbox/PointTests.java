package pl.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testpoints1 (){

    Point p1 = new Point (1,0);
    Point p2 = new Point (1,4);
    Point p3 = new Point (-12, 4);

    Assert.assertEquals( p1.distance(p2), 4.0);
    Assert.assertEquals( p2.distance(p3), 13.0);

  }
  @Test
  public void testpoints2 (){

    Point p1 = new Point (1,0);

    Assert.assertEquals( p1.distance(p1), 0.0);

  }
  @Test
  public void testpoints3 () {

    Point p1 = new Point(1, 0);
    Point p4 = new Point(5, 3);

    Assert.assertEquals(p1.distance(p4), 5.0);
  }


  }