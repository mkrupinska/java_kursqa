package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {

    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initAddNewContact();
    app.getContactHelper().fillContactForm(new ContactData("testimie", "testnazwi", "gdzies", "1231234", "imejl@test.pl"));
    app.getContactHelper().confirmCreation();
    app.getNavigationHelper().gotoHomePage();
  }
}