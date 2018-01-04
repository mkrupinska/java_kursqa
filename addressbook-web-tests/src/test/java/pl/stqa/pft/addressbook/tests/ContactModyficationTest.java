package pl.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModyficationTest extends TestBase {

  @Test
  public void testContactModyfication() {

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());

    app.getNavigationHelper().gotoHomePage();
    ContactData contact = new ContactData("mkbm", "testnazwi", "gdzies", "1231234", "imejl@test.pl", "test1");
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(contact);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    before.sort(byId);
    app.getContactHelper().chooseEditContact(before.size());
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().confirmEditContatct();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size() , before.size());

    before.remove(before.size()-1);
    before.add(contact);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
