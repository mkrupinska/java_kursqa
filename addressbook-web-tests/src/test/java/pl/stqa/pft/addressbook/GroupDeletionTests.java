package pl.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{

    @Test
    public void testGroupDeletion() {
        goToGroupPage();
        SelectGroup();
        DeleteGroup();
        returnToGroupPage();
    }

}
