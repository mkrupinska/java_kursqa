package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModyficationTest extends TestBase {

@Test
  public void testGroupModyfication() {

    app.getNavigationHelper().goToGroupPage();
      if (! app.getGroupHelper().isThereAGroup()) {
       app.getGroupHelper().createGroup(new GroupData("test3", null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().SelectGroup(before.size()-1);
    app.getGroupHelper().initGroupModyfication();
    GroupData group = new GroupData(before.get(before.size()-1).getId(),"test1", "test2", "test3");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModyfication();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
  Assert.assertEquals(after.size(), before.size());


  before.remove(before.size() -1);
  before.add(group);
  Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));



  }





}
