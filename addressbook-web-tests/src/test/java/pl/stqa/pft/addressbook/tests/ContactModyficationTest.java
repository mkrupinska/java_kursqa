package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModyficationTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (! app.contact().isThereAContact()) {
      app.contact().createContact(new ContactData()
              .withFirstName("takie").withLastName("testnazwi").withAddress("gdzies").withHomephone("1231234").withEmail("imejl@test.pl").withGroup("test1"));
    } }

  @Test (enabled = false)
  public void testContactModyfication() {

    Contacts before = app.contact().all();
    ContactData modifiedContact =  before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("test1").withLastName("test2").withAddress("gdzie").withHomephone("13123");

    app.contact().modify(contact);
    app.goTo().homePage();
    Contacts after = app.contact().all();

    assertEquals(after.size() , before.size());
    assertThat(before.without(modifiedContact).withAdded(contact), equalTo(after) );



  }

}
