package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion () {

    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectElement("17");
    app.getContactHelper().deleteContact();
    app.getContactHelper().closeAlertWindow();
    app.getNavigationHelper().gotoHomePage();

  }



}
