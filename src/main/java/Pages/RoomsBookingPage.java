package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RoomsBookingPage  extends PageBase{
    public RoomsBookingPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//button[normalize-space()='Check-In']")
    WebElement checkInBtn;
    @FindBy(id = "customerId")
    WebElement customerIdInput;
    @FindBy(id="room")
    WebElement RoomType;
    @FindBy(xpath = "//button[@type='submit' and normalize-space()='Check-In']")
    WebElement roomCheckInSubmitBtn;

    @FindBy(xpath = "//button[contains(@class,'btn-success') and normalize-space()='Check-Out']")
    WebElement roomCheckOutBtn;

    @FindBy(id = "checkOutCustomerId")
    WebElement checkOutCustomerIdInput;
    @FindBy(xpath = "//button[@type='submit' and normalize-space()='Check-Out']")
    WebElement roomCheckOutSubmitBtn;

    public void Click_Check_In_Btn(String customerId){
        ClickButton(checkInBtn);
        EnterText(customerIdInput,customerId);
        Select roomType = new Select(RoomType);
        roomType.selectByVisibleText("Room 1");;
        ClickButton(roomCheckInSubmitBtn);
    }

    public void Check_Out_Room(String roomId){
        ClickButton(roomCheckOutBtn);
        EnterText(checkOutCustomerIdInput,roomId);
        ClickButton(roomCheckOutSubmitBtn);
    }
}
