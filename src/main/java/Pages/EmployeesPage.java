package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EmployeesPage extends PageBase  {
    public EmployeesPage (WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[1]/div/button[1]")
    WebElement btnCheckIn;
    @FindBy(id = "customerId")
    WebElement txtCustomerId;

    @FindBy(id = "type")
    WebElement SharedType;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[6]/div/form/div[3]/button[2]")
    WebElement CheckInBtn;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div/div[1]")
    WebElement AllCheckInPage ;

    public void  NewCheckIn(){
        btnCheckIn.click();
        EnterText(txtCustomerId,"Dok-098");
        Select selectSharedType = new Select(SharedType);
        selectSharedType.selectByValue("Quiet Area");
        CheckInBtn.click();
    }
}