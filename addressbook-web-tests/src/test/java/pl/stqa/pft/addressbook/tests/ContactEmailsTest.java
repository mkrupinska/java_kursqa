package pl.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailsTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
      if (app.db().contacts().size() == 0) {
        app.goTo().homePage();
        app.contact().createContact(new ContactData()
                .withFirstName("takie").withLastName("testnazwi").withAddress("gdzies").withHomephone("1231234").withEmail("imejl@test.pl").withGroup("test1"));
      } }

    @Test (enabled = true)
    public void testContactEmails() {
      app.goTo().homePage();
      ContactData contact = app.contact().all().iterator().next();
      ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

      assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }

  private String mergeEmails(ContactData contat) {
    return Arrays.asList(contat.getEmail(), contat.getEmail2(), contat.getEmail3())
            .stream().filter((s) -> !s.equals("")).map(ContactEmailsTest::cleaned)
            .collect(Collectors.joining("\n"));

    }

  private static String cleaned(String email) {
    return email.replaceAll("\\s","");
  }
  }





