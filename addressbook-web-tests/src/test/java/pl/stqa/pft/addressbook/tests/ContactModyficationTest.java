package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.Comparator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModyficationTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().createContact(new ContactData()
              .withFirstName("takie").withLastName("testnazwi").withAddress("gdzies").withHomephone("1231234").withEmail("imejl@test.pl").withGroup("test1"));
    } }

  @Test (enabled = true)
  public void testContactModyfication() {

    Contacts before = app.db().contacts();
    ContactData modifiedContact =  before.iterator().next();
    app.goTo().homePage();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("test1").withLastName("test2").withAddress("gdzie")
            .withHomephone("13123").withPhoto(new File("src/test/resources/stru.png")).withEmail("ggg");

    app.contact().modify(contact);
    app.goTo().homePage();
    Contacts after = app.db().contacts();

    assertEquals(after.size() , before.size());
   // System.out.println(toTest);
    //Comparator<?super ContactData> byId = (c1, c2) ->Integer.compare(c1.getId(), c2.getId());
    assertThat(before.without(modifiedContact).withAdded(contact), equalTo(after) );


  }

}
