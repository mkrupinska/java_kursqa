package pl.stqa.pft.addressbook.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactDeletionTest extends TestBase {

  @Test (enabled = false)
  public void testContactDeletion () {
    String choosenId = "52";


    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("testimie", "testnazwi", "gdzies", "1231234", "imejl@test.pl", "test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    String deletedId =  app.getContactHelper().selectElement(choosenId).getAttribute("id");
    app.getContactHelper().deleteContact();
    app.getContactHelper().closeAlertWindow();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size() , before.size() -1 );

    int index = -1;
    for (int i = 0; i<before.size(); i++){
      ContactData item = before.get(i);
       if (item.getId() == Integer.parseInt(deletedId)){
         index = i;
         break;
       }
    }


    before.remove(index);
    Assert.assertEquals(before, after);



  }



}
