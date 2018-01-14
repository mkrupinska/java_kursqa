package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTest extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() {

    app.goTo().homePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/stru.png");
    ContactData contact = new ContactData().withLastName("testl").withFirstName("testF").withPhoto(photo);
    app.contact().createContact(contact);
    app.goTo().homePage();
    Contacts after = app.contact().all();

    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before
            .withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }
}
  /*
  @Test
  public void testCurrentDir() {
    File currentDir = new File (".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File ("src/test/resources/stru.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());

  }
 */