package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends BaseHelper {

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void login(String username, String password) {
    type(By.name("user"),username);
    type(By.name("pass"),password);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));
    //click(By.linkText("Create account"));
    //click(By.xpath("//form[@id='LoginForm']/input[3]"));
    //WebElement element = wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]"));
   //String cos = element.getTagName();
    //click(By.cssSelector("input[type=submit]"));
  }


}
