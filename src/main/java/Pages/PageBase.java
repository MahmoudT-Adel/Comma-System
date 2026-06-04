package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

  public  PageBase( WebDriver driver)
  {
    PageFactory.initElements(driver, this);
  }

  protected static  void  EnterText(WebElement TextElement, String Value) {
    TextElement.sendKeys(Value);
  }

  protected static void  ClickButton(WebElement button) {
    button.click();
  }
}
