package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {

    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().createContact(new ContactData("testimie", "testnazwi", "gdzies", "1231234", "imejl@test.pl", "test1"));
    app.getNavigationHelper().gotoHomePage();
  }
}