package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

public class ContactAdressTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (!app.contact().isThereAContact()) {
      app.contact().createContact(new ContactData()
              .withFirstName("takie").withLastName("testnazwi").withAddress("gdzies").withHomephone("1231234").withEmail("imejl@test.pl").withGroup("test1"));
    }
  }

  @Test
  public void testContactAdress() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
  }
}
