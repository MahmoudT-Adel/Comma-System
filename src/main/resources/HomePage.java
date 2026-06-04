package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends  PageBase{
    public HomePage (WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/ul/li[1]")
    WebElement CustomerPage;


 public void  LoginCustomerPage(){
     ClickButton(CustomerPage);
 }
}
