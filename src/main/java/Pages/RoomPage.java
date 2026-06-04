package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import javax.xml.xpath.XPath;

public class RoomPage extends PageBase{

    public RoomPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[1]/button")
    WebElement AddRoomBtn;
    @FindBy(xpath = "//*[@id=\"name\"]")
    WebElement roomName;
    @FindBy(xpath = "//*[@id=\"branch_name\"]")

    WebElement branchName;
    @FindBy(xpath = "//*[@id=\"type\"]")
    WebElement roomType;
    @FindBy(xpath = "//*[@id=\"capacity\"]")
    WebElement  RoomCapacity;
    @FindBy(xpath = "//*[@id=\"price\"]")
    WebElement  RoomPrice;
    @FindBy(xpath = "//*[@id=\"price-type\"]")
    WebElement  RoomPriceType;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[4]/div/form/div[7]/button[1]")
    WebElement CancelBtn2;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[2]/div/div[4]/div/form/div[7]/button[2]")
    WebElement SaveBtn1;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[2]/div/table/tbody/tr[5]/td[8]/button[1]")
    WebElement EditRoomBtn;
//    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[4]/div/form/div[7]/button[2]")
//    WebElement SaveChangeBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/table/tbody/tr[5]/td[8]/button[2]")
    WebElement DeleteRoomBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[4]/div/div/button[1]")
    WebElement BtnCancelDeleteRoom;

    @FindBy(xpath = "//*[@id=\"edit-name\"]")
    WebElement RoomNameEdit;
    @FindBy(xpath = "//*[@id=\"edit-branch_name\"]")
    WebElement BranchNameEdit;
    @FindBy(xpath = "//*[@id=\"edit-type\"]")
    WebElement RoomTypeEdit;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[4]/div/form/div[7]/button[2]")
    WebElement SaveChangesBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[4]/div/form/div[7]/button[1]")
    WebElement CancelChangesBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[4]/div/div/button[2]")
    WebElement ConfirmToDeleteRoomBtn;
    public void  AddNewRoom(
            String roomNameTxt,
            String branchNameTxt,
            String roomTypeTxt,
            Number roomCapacityTxt,
            Number roomPriceTxt
    ){
       ClickButton(AddRoomBtn);
       EnterText(roomName ,  roomNameTxt);
       EnterText(branchName ,  branchNameTxt);
       EnterText(roomType ,  roomTypeTxt);
       EnterText(RoomCapacity , String.valueOf (roomCapacityTxt));
        EnterText(RoomPrice , String.valueOf (roomPriceTxt));
        Select selectRoomType = new Select(RoomPriceType);
        selectRoomType.selectByValue("day");
        ClickButton(SaveBtn1);

    }
    public void  EditTheRoom() {
        ClickButton(EditRoomBtn);
        RoomNameEdit.clear();
        EnterText(RoomNameEdit ,  "Edit Room Done");
        BranchNameEdit.clear();
        EnterText(BranchNameEdit ,  "Test Branch");
        RoomTypeEdit.clear();
        EnterText(RoomTypeEdit ,  "Edit Room Done");
        ClickButton( SaveChangesBtn);
    }

    public void DeleteTheRoom(){
        ClickButton(DeleteRoomBtn);
        ClickButton(ConfirmToDeleteRoomBtn);
    }
}
