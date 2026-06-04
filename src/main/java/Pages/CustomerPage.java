package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.html.Option;
import java.time.Duration;

public class CustomerPage extends PageBase{
    public  CustomerPage (WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[1]/div/button[1]")
    WebElement AddNewCustomerButt;
    @FindBy(xpath = "//*[@id=\"name\"]")
    WebElement CustomerName;
    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement CustomerEmail;
    @FindBy(xpath = "//*[@id=\"phone\"]")
    WebElement CustomerPhone;

    @FindBy(id = "id-search")
    WebElement CustomerSearch;

    @FindBy(css = "label.checkbox-container")
    public WebElement checkInCheckbox;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[4]/div/form/div[8]/button[1]")
    public WebElement CancelButton;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement AddNewCustomerButton;

    public void OpenScreenToAddCustomer(){
        ClickButton(AddNewCustomerButt);
    }

    public void EnterTextToAddCustomer(
            String CustomerNameText,
            String CustomerEmailText,
            String CustomerPhoneText
            ){

        CustomerName.sendKeys(CustomerNameText);
        CustomerEmail.sendKeys(CustomerEmailText);
        CustomerPhone.sendKeys(CustomerPhoneText);
    }


    public void SearchOfCustomer(){
        EnterText(CustomerSearch , "Dok-550");
    }


}
