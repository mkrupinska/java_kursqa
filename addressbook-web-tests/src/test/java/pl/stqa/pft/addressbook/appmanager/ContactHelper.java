package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
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



  public WebElement chooseEditContact(Integer inLine) {
    WebElement element = null;
    By loc = By.xpath("//table[@id='maintable']/tbody/tr[" + (inLine + 1) + "]/td[8]/a/img");
    if (isElementPresent(loc)) {
      element = wd.findElement(loc);
      click(loc);
     } else {
      element = wd.findElement(By.cssSelector("img[title=\"Edit\"]"));
      wd.findElement(By.cssSelector("img[title=\"Edit\"]")).click();


      System.out.println("There is no selected element, modified random element");
    }
    return element;
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

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String lastName = cells.get(1).getText();
      String firstName = cells.get(2).getText();
      int iD = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
      ContactData contact = new ContactData(iD, lastName, firstName, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
