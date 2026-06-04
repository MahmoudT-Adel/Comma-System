package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends  PageBase{
    public HomePage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/ul/li[1]")
    WebElement customerPage;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/ul/li[2]")
    WebElement branchPage;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/ul/li[4]")
    WebElement RoomsPage;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/ul/li[8]")
    WebElement CheckInPageBtn;
    public void OpenCustomerPage(){
        ClickButton(customerPage);
    }

    public void OpenBranchPage(){
        ClickButton(branchPage);
    }

    public void OpenRoomsPage(){
        ClickButton(RoomsPage);
    }
    public void OpenCheckInPage() {ClickButton(CheckInPageBtn);}
}
