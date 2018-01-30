package pl.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;
import pl.stqa.pft.addressbook.model.GroupData;
import pl.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class RemoveContactFromGroup extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.db().groups().size()==0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("testn"));
    }

    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().createContact(new ContactData()
              .withFirstName("takie").withLastName("testnazwi").withAddress("gdzies").withHomephone("1231234")
              .withEmail("imejl@test.pl").inGroup(app.db().groups().iterator().next()));
    }
  }

  @Test
  public void removeContactFromGroup(){

    Contacts allContacts = app.db().contacts();
    ContactData choosenContact = null;
    GroupData choosenGroup = null;

    for (ContactData contact:allContacts){
       if (contact.getGroups().size() != 0){
         choosenContact = contact;
         choosenGroup = contact.getGroups().iterator().next();
         break;
       }
    }
    if (choosenContact == null){
      choosenContact = allContacts.iterator().next();
      choosenGroup = app.db().groups().iterator().next();
      app.goTo().homePage();
      app.contact().addContactInGroup(choosenContact,choosenGroup);
    }

    Groups beforeGroupsforChoosenContact = choosenContact.getGroups();
    Contacts beforeContactsInChoosenGroup = choosenGroup.getContacts();
    Integer ContactId = choosenContact.getId();
    Integer GroupId = choosenGroup.getId();

   app.goTo().homePage();
   app.contact().removeContactFromGroup(choosenContact,choosenGroup);
   app.goTo().homePage();

    Groups afterGroupsforChoosenContact = app.db().contacts().getContact(ContactId).getGroups();
    Contacts afterContactsInChoosenGroup = app.db().groups().getGroup(GroupId).getContacts();

    assertThat(beforeGroupsforChoosenContact.without(choosenGroup), equalTo(afterGroupsforChoosenContact));
    assertThat(beforeContactsInChoosenGroup.without(choosenContact), equalTo(afterContactsInChoosenGroup));

  }
}
