package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion () {

    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("testimie", "testnazwi", "gdzies", "1231234", "imejl@test.pl", "test1"));
    }
    app.getContactHelper().selectElement("14");
    app.getContactHelper().deleteContact();
    app.getContactHelper().closeAlertWindow();
    app.getNavigationHelper().gotoHomePage();

  }



}
