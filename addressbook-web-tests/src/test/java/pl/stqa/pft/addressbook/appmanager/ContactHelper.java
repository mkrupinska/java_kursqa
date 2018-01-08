package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;
import pl.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
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

  public void chooseEditContact(Integer index){
    wd.findElements(By.cssSelector(("img[title=\"Edit\"]"))).get(index).click();
  }


  public void chooseEditContact(ContactData contact) {

    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int iD = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
      if (contact.getId() == iD){
        cells.get(7).findElement(By.cssSelector("img[title=\"Edit\"]")).click();
        return;
      }
    }
  }

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
      int iD = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
      contacts.add(new ContactData().withId(iD).withFirstName(firstName).withLastName(lastName));
    }
    return contacts;
  }


}
