package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;

public class GroupModyficationTest extends TestBase {

@Test
  public void testGroupModyfication() {

    app.getNavigationHelper().goToGroupPage();
      if (! app.getGroupHelper().isThereAGroup()) {
       app.getGroupHelper().createGroup(new GroupData("test3", null, null));
    }
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().SelectGroup();
    app.getGroupHelper().initGroupModyfication();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupModyfication();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount();
  Assert.assertEquals(after, before);




  }





}
