package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().SelectGroup();
        app.getGroupHelper().DeleteGroup();
        app.getGroupHelper().returnToGroupPage();
    }

}
