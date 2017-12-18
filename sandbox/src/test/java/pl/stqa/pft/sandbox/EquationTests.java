package pl.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationTests {

  @Test
  public void test0 () {

    Equation jeden = new Equation(1,1,1);
    Assert.assertEquals(jeden.RootNumber(),0);
  }

  @Test
  public void test1 () {

    Equation dwa = new Equation(1,2,1);
    Assert.assertEquals(dwa.RootNumber(),1);
  }

  @Test
  public void test2 () {

    Equation trzy = new Equation(1,5,6);
    Assert.assertEquals(trzy.RootNumber(),2);
  }

  @Test
  public void testLiniowy () {

    Equation trzy = new Equation(0, 5, 6);
    Assert.assertEquals(trzy.RootNumber(), 1);
  }

  @Test
  public void testConstant () {

    Equation trzy = new Equation(0, 0, 6);
    Assert.assertEquals(trzy.RootNumber(), 0);
  }

  @Test
  public void testZero () {

    Equation trzy = new Equation(0, 0, 0);
    Assert.assertEquals(trzy.RootNumber(), -1);
  }

}

