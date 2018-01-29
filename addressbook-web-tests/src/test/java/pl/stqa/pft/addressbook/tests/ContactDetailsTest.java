package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailsTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().createContact(new ContactData()
              .withFirstName("takie").withLastName("testnazwi").withAddress("gdzies").withHomephone("1231234").withEmail("imejl@test.pl").withGroup("test1"));
    } }

  @Test(enabled = true)
  public void testContactDetails() {
    ContactData contacts = app.contact().all().iterator().next();

    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contacts);
    String detailsData = app.contact().infoFromDetailsPage(contacts);

    String cleanEditFormData = mergeContact(CreateFormatted(contactInfoFromEditForm));
    String cleanedDataDetailsForm = cleaned(detailsData);

    System.out.println(cleanEditFormData);
    System.out.println(cleanedDataDetailsForm);
    assertThat(cleanedDataDetailsForm, equalTo(cleanEditFormData));
  }

  private String mergeContact(ContactData contat) {
    return Arrays.asList(contat.getFirstname(), contat.getMiddlename(), contat.getLastname(),contat.getNickname(),contat.getTitle(),contat.getCompany(),
            contat.getAddress(),contat.getHomephone(),contat.getMobilephone(),contat.getWorkphone(),contat.getFax(),contat.getEmail(),contat.getEmail2(),
            contat.getEmail3(),contat.getHomepage(),contat.getBirthday(),contat.getAnniversary(),contat.getSecAddress(),contat
                    .getSecHomePhone(),contat.getNotes())
            .stream().filter((s) -> s !=null && !s.equals("")).map(ContactDetailsTest::cleaned)
            .collect(Collectors.joining());
  }

  public static String cleaned (String data) {
    return data.replaceAll("\n", "").replace(" ", "")
            .replace(".", "").replace("-", "");
  }

  public ContactData CreateFormatted(ContactData source) {
    ContactData result = new ContactData();
    if (source.getHomephone() != null && source.getHomephone().length() > 0) {
      result.withHomephone("H:" + source.getHomephone());
    } else {
      result.withHomephone(source.getHomephone());
    }
    if (source.getMobilephone() != null && source.getMobilephone().length() > 0) {
      result.withMobilephone("M:" + source.getMobilephone());
    } else {
      result.withMobilephone(source.getMobilephone());
    }
    if (source.getWorkphone() != null && source.getWorkphone().length() > 0) {
      result.withWorkphone("W:" + source.getWorkphone());
    } else {
      result.withWorkphone(source.getWorkphone());
    }
    if (source.getFax() != null && source.getFax().length() > 0) {
      result.withFax("F:" + source.getFax());
    } else {
      result.withFax(source.getFax());
    }
    if (source.getHomepage() != null && source.getHomepage().length() > 0) {
      result.withHomepage("Homepage:" + source.getHomepage());
    } else {
      result.withHomepage(source.getHomepage());
    }
    if (source.getSecHomePhone() != null && source.getSecHomePhone().length() > 0) {
      result.withSecHomePhone("P:" + source.getSecHomePhone());
    } else {
      result.withSecHomePhone(source.getSecHomePhone());
    }
    if (source.getBirthday() != null && source.getBirthday().length() > 0 && !source.getBirthday().equals("--")) {
      result.withBirdhday("Birthday" + source.getBirthday());
    } else {
      result.withBirdhday(source.getBirthday());
    }
    if (source.getAnniversary() != null && source.getAnniversary().length() > 0 && !source.getAnniversary().equals("--")) {
      result.withAnniversary("Anniversary" + source.getAnniversary());
    } else {
      result.withAnniversary(source.getAnniversary());
    }

    result.withEmail(source.getEmail()).withEmail2(source.getEmail2()).withEmail3(source.getEmail3()).withFirstName(source.getFirstname())
            .withMiddlename(source.getMiddlename()).withLastName(source.getLastname()).withNickname(source.getNickname()).withTitle(source.getTitle())
    .withCompany(source.getCompany()).withAddress(source.getAddress()).withNotes(source.getNotes()).withSecAddress(source.getSecAddress());

    return result;
  }
}
