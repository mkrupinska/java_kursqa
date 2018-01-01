package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
          app.getGroupHelper().createGroup(new GroupData("test3", null, null));
        }
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().SelectGroup(before-1);
        app.getGroupHelper().DeleteGroup();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after , before -1 );
    }
}
