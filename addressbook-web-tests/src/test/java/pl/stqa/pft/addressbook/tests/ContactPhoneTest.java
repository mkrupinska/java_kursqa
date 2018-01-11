package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (! app.contact().isThereAContact()) {
      app.contact().createContact(new ContactData()
              .withFirstName("takie").withLastName("testnazwi").withAddress("gdzies").withHomephone("1231234").withEmail("imejl@test.pl").withGroup("test1"));
    } }

@Test
  public void testContactPhones() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

  assertThat(contact.getHomephone(), equalTo(cleaned(contactInfoFromEditForm.getHomephone())));
  assertThat(contact.getWorkphone(), equalTo(cleaned(contactInfoFromEditForm.getWorkphone())));
  assertThat(contact.getMobilephone(), equalTo(cleaned(contactInfoFromEditForm.getMobilephone())));
  }

  public String cleaned (String phone) {
    return  phone. replaceAll("\\s","").replaceAll("[-()]","");
  }

}
