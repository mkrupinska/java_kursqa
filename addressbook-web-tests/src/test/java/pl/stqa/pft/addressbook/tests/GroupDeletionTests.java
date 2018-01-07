package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;
import java.util.Set;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withHeader("test2"));
        }
    }

    @Test
    public void testGroupDeletion() {

        Set<GroupData> before = app.group().all();
        GroupData deletedgroup = before.iterator().next();
        app.group().delete(deletedgroup);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size() , before.size() -1 );

        before.remove(deletedgroup);
        Assert.assertEquals(before, after);

    }

}
