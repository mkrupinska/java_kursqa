package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

public class ContactModyficationTest extends TestBase {

  @Test
  public void testContactModyfication() {

    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().choosEditContact(5);
    app.getContactHelper().fillContactForm(new ContactData("modify", "modifynazw", "gdzies", "1231234", "imejl@test.pl"));
    app.getContactHelper().confirmEditContatct();
    app.getNavigationHelper().gotoHomePage();
  }
}
