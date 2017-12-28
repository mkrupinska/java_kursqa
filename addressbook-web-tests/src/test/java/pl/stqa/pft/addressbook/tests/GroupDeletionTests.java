package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
          app.getGroupHelper().createGroup(new GroupData("test3", null, null));
        }
        app.getGroupHelper().SelectGroup();
        app.getGroupHelper().DeleteGroup();
        app.getGroupHelper().returnToGroupPage();
    }
}
