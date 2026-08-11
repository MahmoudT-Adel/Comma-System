
package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SherdAreaPage extends PageBase {
    public SherdAreaPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[contains(.,'All Check-ins')]")
    WebElement allCheckIns;

    @FindBy(xpath = "//h2[contains(.,'VIP Area')]")
   public WebElement vipArea;

    @FindBy(xpath = "//h2[contains(.,'Quiet Area')]")
    WebElement quietArea;

    @FindBy(xpath = "//h2[contains(.,'General Area')]")
    WebElement generalArea;

    @FindBy(xpath = "//button[normalize-space()='Check-In']")
    WebElement checkInBtn;

    @FindBy(xpath = "//button[normalize-space()='Check-Out']")
    WebElement checkOutBtn;

    @FindBy(id = "customerId")
    WebElement customerIdInput;

    @FindBy(css = "span.checkin-count")
    WebElement activeCustomersCount;
    @FindBy(id = "type")
    WebElement areaTypeDropdown;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement checkInSubmitBtn;

    @FindBy(css = "button.btn-checkout")
    WebElement checkOutButtonFromTable;

    @FindBy(id = "item-6")
    WebElement singleShotCheckbox;

    @FindBy(xpath = "//button[@type='submit' and normalize-space()='Check-Out']")
    WebElement checkOutSubmitBtn;

    @FindBy(xpath = "//textarea[@placeholder='Please provide a reason for cancellation']")
    WebElement cancellationReasonInput;

    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    WebElement confirmBtnCancel;

    public void openAllCheckInPage() {
        ClickButton(allCheckIns);
        ClickButton(checkInBtn);
        EnterText(customerIdInput , "DOK-1229");
        Select select =new Select(areaTypeDropdown);
        select.selectByVisibleText("VIP Area");
        ClickButton(checkInSubmitBtn);
    }
    public void open_Vip_Area_CheckIn() {
        ClickButton(vipArea);
        ClickButton(checkInBtn);
        EnterText(customerIdInput, "DOK-120");
        ClickButton(checkInSubmitBtn);
    }

    public void open_Quiet_Area_CheckIn() {
        ClickButton(quietArea);
        ClickButton(checkInBtn);
        EnterText(customerIdInput, "DOK-125");
        ClickButton(checkInSubmitBtn);
    }

    public void open_General_Area_CheckIn() {
        ClickButton(generalArea);
        ClickButton(checkInBtn);
        EnterText(customerIdInput, "DOK-1249");
        ClickButton(checkInSubmitBtn);
    }

    public void CheckOut_Customer_Button_From_Table() {
        //ClickButton(checkOutButtonFromTable);
      ClickButton(singleShotCheckbox);
      ClickButton(checkOutSubmitBtn);

    } public void CheckOut_Cancel_Button_From_Table(String value) {

     EnterText(cancellationReasonInput, value);
     ClickButton(confirmBtnCancel);
    }


}
