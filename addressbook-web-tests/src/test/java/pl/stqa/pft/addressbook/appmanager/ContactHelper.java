package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.stqa.pft.addressbook.model.ContactData;

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


  public void initAddNewContact(){
    click(By.linkText("add new"));
  }

  public void confirmCreation () {
    click((By.xpath("//div[@id='content']/form/input[21]")));

    }

  public void selectElement(String id) {
    if (isElementPresent(By.id(id))){
      if (!wd.findElement(By.id(id)).isSelected()) {
        wd.findElement(By.id(id)).click();
      }
    }else
      if (isElementPresent(By.name("selected[]"))){
      wd.findElement(By.name("selected[]")).click();
      System.out.println("there is no element with selected ID, random element selected");
    }
  }

  public void chooseEditContact (Integer inLine){
    By loc = By.xpath("//table[@id='maintable']/tbody/tr["+(inLine+1)+"]/td[8]/a/img");
    if (isElementPresent(loc)) {
      click(loc);
    }
    else {
      wd.findElement(By.cssSelector("img[title=\"Edit\"]")).click();
      System.out.println("There is no selected element, modified random element");
    }
  }

  public void confirmEditContatct (){
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void closeAlertWindow(){
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
}
