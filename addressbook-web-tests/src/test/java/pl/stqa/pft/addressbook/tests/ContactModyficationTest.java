package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModyficationTest extends TestBase {

  @Test (enabled = false)
  public void testContactModyfication() {

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
//    Comparator<? super ContactData> byName = (c1, c2) -> c1.getLastname().compareTo(c2.getLastname());
    app.goTo().gotoHomePage();
    ContactData contact = new ContactData("takie", "testnazwi", "gdzies", "1231234", "imejl@test.pl", "test1");
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(contact);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
/*
    int maxIDIndex=-1;
    int maxID = -1;
    for (int i=0;i<before.size();i++)
    {
      if (before.get(i).getId() > maxID)
      {
        maxID = before.get(i).getId();
        maxIDIndex=i;
      }
    }
*/
    int modifiedID = app.getContactHelper().chooseEditContact(400+1);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().confirmEditContatct();
    app.goTo().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size() , before.size());

    int index = -1;
    for (int i = 0; i<before.size(); i++){
      ContactData item = before.get(i);
      if (item.getId() == modifiedID){
        index = i;
        break;
      }
    }

    contact.setId(modifiedID);
    before.set(index,contact);

   // before.remove(index);
    //before.add(contact);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }
}
