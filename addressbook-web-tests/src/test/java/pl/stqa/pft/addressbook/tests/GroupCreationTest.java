package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;
import pl.stqa.pft.addressbook.model.Groups;




import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GroupCreationTest extends TestBase {

  @Test (enabled = false)
  public void testGroupCreation() {

    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withHeader("test1h").withFooter("test2f").withName("testn");

    app.group().create(group);
    Groups after = app.group().all();

    assertThat(after.size() , equalTo( before.size() + 1));
    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) ->g.getId()).max().getAsInt()))));

  }
}
