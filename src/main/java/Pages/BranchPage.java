package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BranchPage extends PageBase{
    public  BranchPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div/div/button")
    WebElement AddBranchBtn;
    @FindBy(xpath= "//*[@id=\"name\"]")
    WebElement BranchName;
    @FindBy(xpath = "//*[@id=\"location\"]")
    WebElement BranchLocation;
    @FindBy(xpath = "//*[@id=\"phone\"]")
    WebElement PhoneOfBranch;
    @FindBy(xpath = "//*[@id=\"roomsCount\"]")
    WebElement RoomsCount;
    @FindBy(xpath = "//*[@id=\"employeesCount\"]")
    WebElement EmployeesCount;
    @FindBy(xpath = "//*[@id=\"customersCount\"]")
    WebElement  CustomersCount;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div/form/div[7]/button[1]")
    WebElement CancelBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div/form/div[7]/button[2]")
    WebElement BtnSave;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/table/tbody/tr[2]/td[7]/button[1]")
    WebElement EditBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/table/tbody/tr[2]/td[7]/button[2]")
    WebElement DeleteBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div/div/button[2]")
    WebElement DeleteBtnConfirm;

    @FindBy(xpath= "//*[@id=\"edit-name\"]")
    WebElement BranchEditName;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div/form/div[7]/button[2]")
    WebElement SaveChangeBtn;

    public void AddBranch(
            String name ,
            String location ,
            String phone ,
            Number roomsCount ,
            Number employeesCount ){
       ClickButton(AddBranchBtn);
        EnterText(BranchName,name);
        EnterText(BranchLocation,location);
        EnterText(PhoneOfBranch,phone);
        EnterText(RoomsCount,String.valueOf(roomsCount));
        EnterText(EmployeesCount,String.valueOf(employeesCount));
        BtnSave.click();

    }

    public void EditYourBranch(){
        ClickButton(EditBtn);
        BranchEditName.clear();
        EnterText(BranchEditName, "BranchUpdateDone");
        ClickButton(SaveChangeBtn);
    }

   public  void  DeleteYourBranch() throws InterruptedException{
  ClickButton(DeleteBtn);
  Thread.sleep(1000);
    ClickButton(DeleteBtnConfirm);
    }
}
