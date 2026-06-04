package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/form/input[1]")
    WebElement UsernameText;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/form/input[2]")
    WebElement PasswordText;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/form/button")
    WebElement LoginBtn;

    public void UserCanLogin(String UserName,String Password){
        EnterText(UsernameText, UserName);
        EnterText(PasswordText, Password);
        ClickButton(LoginBtn);
    }
}
