package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;
import pl.stqa.pft.addressbook.model.GroupData;
import pl.stqa.pft.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class AddContactToGroup extends TestBase
{
  @BeforeMethod
  public void ensurePreconditions(){
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().createContact(new ContactData()
              .withFirstName("takie").withLastName("testnazwi").withAddress("gdzies").withHomephone("1231234")
              .withEmail("imejl@test.pl"));
    }
    if (app.db().groups().size()==0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("testn"));
    }
  }

    @Test
  public void addContactToGroup(){
    ContactData choosenContact = app.db().contacts().iterator().next();
    Groups beforeGroupsforChoosenContact = choosenContact.getGroups();
    Integer ContactId = choosenContact.getId();

     Groups withoutGroups = app.db().groups().without(beforeGroupsforChoosenContact);
     if (withoutGroups.size() == 0){
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("boniebylo"));
     }
       GroupData choosenGroup = app.db().groups().without(beforeGroupsforChoosenContact).iterator().next();
       Contacts beforeContactsInChoosenGroup = choosenGroup.getContacts();
       Integer GroupId = choosenGroup.getId();

       app.goTo().homePage();
       app.contact().addContactInGroup(choosenContact, choosenGroup);
       app.goTo().homePage();

     Groups afterGroupsforChoosenContact = app.db().contacts().getContact(ContactId).getGroups();
     Contacts afterContactsInChoosenGroup = app.db().groups().getGroup(GroupId).getContacts();

    assertThat(beforeGroupsforChoosenContact.withAdded(choosenGroup), equalTo(afterGroupsforChoosenContact));
    assertThat(beforeContactsInChoosenGroup.withAdded(choosenContact), equalTo(afterContactsInChoosenGroup));
    }

  @Test
  public void addContactToItsGroupAgain() {

    Contacts allContacts = app.db().contacts();
    ContactData choosenContact = null;
    GroupData choosenGroup = null;

    for (ContactData contact : allContacts) {
      if (contact.getGroups().size() != 0) {
        choosenContact = contact;
        choosenGroup = contact.getGroups().iterator().next();
        break;
      }
    }
    if (choosenContact == null) {
      choosenContact = allContacts.iterator().next();
      choosenGroup = app.db().groups().iterator().next();
      app.goTo().homePage();
      app.contact().addContactInGroup(choosenContact, choosenGroup);
    }

    Groups beforeGroupsforChoosenContact = choosenContact.getGroups();
    Contacts beforeContactsInChoosenGroup = choosenGroup.getContacts();
    Integer ContactId = choosenContact.getId();
    Integer GroupId = choosenGroup.getId();


    app.goTo().homePage();
    app.contact().addContactInGroup(choosenContact, choosenGroup);
    app.goTo().homePage();

    Groups afterGroupsforChoosenContact = app.db().contacts().getContact(ContactId).getGroups();
    Contacts afterContactsInChoosenGroup = app.db().groups().getGroup(GroupId).getContacts();

    assertThat(beforeGroupsforChoosenContact, equalTo(afterGroupsforChoosenContact));
    assertThat(beforeContactsInChoosenGroup, equalTo(afterContactsInChoosenGroup));
  }
}
