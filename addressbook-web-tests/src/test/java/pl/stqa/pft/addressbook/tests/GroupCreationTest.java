package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;
import pl.stqa.pft.addressbook.model.Groups;




import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GroupCreationTest extends TestBase {

  @Test (enabled = true)
  public void testGroupCreation() {

    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withHeader("test1h").withFooter("test2f").withName("testn");

    app.group().create(group);
    assertThat(app.group().count() , equalTo( before.size() + 1));
    Groups after = app.group().all();
    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) ->g.getId()).max().getAsInt()))));

  }
  @Test (enabled = false)
  public void testBadGroupCreation() {

    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withHeader("test1'h").withFooter("test2f").withName("testn");
    app.group().create(group);
    assertThat(app.group().count() , equalTo( before.size() ));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));

  }

}
