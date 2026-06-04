package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class LoginPage extends PageBase{

    public  LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//*[@id=\"app\"]/div/div/div/div[2]/form/input[1]")
    WebElement usernameField;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/form/input[2]")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/form/button")
    WebElement loginButton;

  public void UserLogin(String username,String password){
     EnterText(usernameField,username);
      EnterText(passwordField,password);
  ClickButton(loginButton);
  }
}
