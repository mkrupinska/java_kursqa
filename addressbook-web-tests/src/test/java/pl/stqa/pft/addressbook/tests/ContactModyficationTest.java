package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

public class ContactModyficationTest extends TestBase {

  @Test
  public void testContactModyfication() {

    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("testimie", "testnazwi", "gdzies", "1231234", "imejl@test.pl", "test1"));
    }
    app.getContactHelper().chooseEditContact(5);
    app.getContactHelper().fillContactForm(new ContactData("modify", "modifynazw", "gdzies", "1231234", "imejl@test.pl", null), false);
    app.getContactHelper().confirmEditContatct();
    app.getNavigationHelper().gotoHomePage();
  }
}
