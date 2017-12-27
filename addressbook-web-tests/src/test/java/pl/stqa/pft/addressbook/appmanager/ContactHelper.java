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
    if (!wd.findElement(By.id(id)).isSelected()) {
      wd.findElement(By.id(id)).click();
    }
  }

  public void chooseEditContact (Integer inLine){
    click((By.xpath("//table[@id='maintable']/tbody/tr["+(inLine+1)+"]/td[8]/a/img")));
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
}
