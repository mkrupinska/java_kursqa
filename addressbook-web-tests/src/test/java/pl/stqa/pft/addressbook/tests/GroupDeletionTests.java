package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.tests.TestBase;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.goToGroupPage();
        app.SelectGroup();
        app.DeleteGroup();
        app.returnToGroupPage();
    }

}
