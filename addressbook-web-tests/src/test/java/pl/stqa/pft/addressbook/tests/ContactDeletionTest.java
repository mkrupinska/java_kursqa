package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;
import pl.stqa.pft.addressbook.model.Groups;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.db().contacts().size() == 0) {
      Groups groups = app.db().groups();
      app.goTo().homePage();
      app.contact().createContact(new ContactData()
              .withFirstName("takie").withLastName("testnazwi").withAddress("gdzies").withHomephone("1231234")
              .withEmail("imejl@test.pl").inGroup(groups.iterator().next()));
    } }

  @Test (enabled = true)
  public void testContactDeletion () {

    Contacts before = app.db().contacts();
    ContactData deletedContact =  before.iterator().next();
    app.goTo().homePage();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
   Contacts after = app.db().contacts();

    assertEquals(after.size() , before.size() -1 );
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
