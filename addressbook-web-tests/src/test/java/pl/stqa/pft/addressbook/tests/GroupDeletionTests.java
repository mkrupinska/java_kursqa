package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;
import pl.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withHeader("test2"));
        }
    }

    @Test (enabled = true)
    public void testGroupDeletion() {

        Groups before = app.group().all();
        GroupData deletedgroup = before.iterator().next();
        app.group().delete(deletedgroup);
        assertThat(app.group().count() , equalTo( before.size()-1 ));
        Groups after = app.group().all();
      assertThat(after, equalTo(before.without(deletedgroup)));

    }

}
