package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;
import pl.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomephone());
    type(By.name("email"), contactData.getEmail());
    attach(By.name("photo"), contactData.getPhoto());

    if (creation) {
      if (contactData.getGroups().size() >0) {
        Assert.assertTrue(contactData.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }


  public void initAddNewContact() {
    click(By.linkText("add new"));
  }

  public void confirmCreation() {
    click((By.xpath("//div[@id='content']/form/input[21]")));
    }

  public WebElement selectElement(String id) {
    WebElement element = null;
    if (isElementPresent(By.id(id))) {
      if (!wd.findElement(By.id(id)).isSelected()) {
        wd.findElement(By.id(id)).click();
        element = wd.findElement(By.id(id));
      }
    } else if (isElementPresent(By.name("selected[]"))) {
      wd.findElement(By.name("selected[]")).click();
      element = wd.findElement(By.name("selected[]"));
      System.out.println("there is no element with selected ID, random element selected");
    }
    return element;
  }

  public void chooseElementDetails (ContactData contact) {
    int id = contact.getId();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int iD = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
      if (id == iD) {
        cells.get(6).findElement(By.cssSelector("img[title=\"Details\"]")).click();
        return;
      }
    }
  }

  public void chooseEditContact(ContactData contact) {
    chooseElementById(contact.getId());
  }

  public void chooseElementById (int id) {

    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int iD = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
      if (id == iD) {
        cells.get(7).findElement(By.cssSelector("img[title=\"Edit\"]")).click();
        return;
      }
    }
  }
   /*  Alternatives
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();

    wd.findElement(By.xpath(String.format("//input[@value='%s']../../td[8]/a", id))).click();
    wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
    wd.findElement(By.cssSelector(String.format("a[href='edit/php?id=%s']',id"))).click();
  */


  public void confirmEditContatct() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void closeAlertWindow() {
    wd.switchTo().alert().accept();
  }

  public void createContact(ContactData contact) {
    initAddNewContact();
    fillContactForm(contact, true);
    confirmCreation();
  }

  public void delete(ContactData contact) {
    selectElement(Integer.toString(contact.getId()));
    deleteContact();
    closeAlertWindow();
  }

  public void modify(ContactData contact) {
    chooseEditContact(contact);
    fillContactForm(contact, false);
    confirmEditContatct();
  }


  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String lastName = cells.get(1).getText();
      String firstName = cells.get(2).getText();
      String allPhones = cells.get(5).getText();
      String adress = cells.get(3).getText();
      String emails = cells.get(4).getText();
      int iD = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
      contacts.add(new ContactData().withId(iD).withFirstName(firstName).withLastName(lastName).withAllPhones(allPhones).withAddress(adress).withAllEmails(emails));
    }
    return contacts;
  }


  public ContactData infoFromEditForm(ContactData contact) {
    chooseEditContact(contact);
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String email1 = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String middlename = wd.findElement(By.name("middlename")).getAttribute("value");
    String nickname = wd.findElement(By.name("nickname")).getAttribute("value");
    String company = wd.findElement(By.name("company")).getAttribute("value");
    String title = wd.findElement(By.name("title")).getAttribute("value");
    String fax = wd.findElement(By.name("fax")).getAttribute("value");
    String secAddress = wd.findElement(By.name("address2")).getAttribute("value");
    String secHomePhone = wd.findElement(By.name("phone2")).getAttribute("value");
    String notes = wd.findElement(By.name("notes")).getAttribute("value");
    String homepage = wd.findElement(By.name("homepage")).getAttribute("value");
    String bDay = wd.findElement(By.name("bday")).findElement(By.cssSelector("option[selected=selected]")).getText();//.getAttribute("selected");
    String bMonth = wd.findElement(By.name("bmonth")).findElement(By.cssSelector("option[selected=selected]")).getText();
    String bYear = wd.findElement(By.name("byear")).getAttribute("value");
    String aDay = wd.findElement(By.name("aday")).findElement(By.cssSelector("option[selected=selected]")).getText();
    String aMonth = wd.findElement(By.name("amonth")).findElement(By.cssSelector("option[selected=selected]")).getText();
    String aYear = wd.findElement(By.name("ayear")).getAttribute("value");


    wd.navigate().back();
    return new ContactData().withLastName(lastname).withFirstName(firstname)
            .withHomephone(home).withWorkphone(work).withMobilephone(mobile).withAddress(address)
            .withEmail(email1).withEmail2(email2).withEmail3(email3).withMiddlename(middlename).withNickname(nickname).withCompany(company).withTitle(title)
            .withFax(fax).withSecAddress(secAddress).withSecHomePhone(secHomePhone).withNotes(notes).withBDay(bDay).withBMonth(bMonth).withBYear(bYear)
            .withADay(aDay).withAMonth(aMonth).withAYear(aYear).withHomepage(homepage).withBirdhday(bDay+bMonth+bYear).withAnniversary(aDay+aMonth+aYear);
  }

  public String infoFromDetailsPage (ContactData contact){
    chooseElementDetails(contact);
    WebElement details = wd.findElement(By.id("content"));
    String [] parts = details.getText().split("Member of:");
    String detailsText = parts[0];
   // String detailsText = details.getText();
    wd.navigate().back();
    return detailsText;
  }

  private void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='"+ id + "']")).click();
  }
  private void selectGroupById(int id) {
    new Select(wd.findElement(By.name("group"))).selectByValue(Integer.toString(id));
  }

  private void addToGroupById(int id) {
    new Select(wd.findElement(By.name("to_group"))).selectByValue(Integer.toString(id));
    wd.findElement(By.name("add")).click();
  }

  public void addContactInGroup(ContactData contact, GroupData group) {
    selectContactById(contact.getId());
    addToGroupById(group.getId());
  }

  public void removeContactFromGroup(ContactData contact, GroupData group) {
    selectGroupById(group.getId());
    selectContactById(contact.getId());
    wd.findElement(By.name("remove")).click();
  }

}

