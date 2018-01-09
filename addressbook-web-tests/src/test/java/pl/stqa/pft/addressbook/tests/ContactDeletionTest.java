package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (! app.contact().isThereAContact()) {
      app.contact().createContact(new ContactData()
              .withFirstName("takie").withLastName("testnazwi").withAddress("gdzies").withHomephone("1231234").withEmail("imejl@test.pl").withGroup("test1"));
    } }

  @Test (enabled = false)
  public void testContactDeletion () {

    Contacts before = app.contact().all();
    ContactData deletedContact =  before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
   Contacts after = app.contact().all();

    assertEquals(after.size() , before.size() -1 );
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
