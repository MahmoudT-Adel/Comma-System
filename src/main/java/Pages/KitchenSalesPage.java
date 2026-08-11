package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class KitchenSalesPage extends PageBase{
    public KitchenSalesPage(WebDriver driver) {
        super(driver);
    }

@FindBy(xpath = "//button[normalize-space()='Create New Order']")
WebElement createNewOrder;
    @FindBy(xpath = "//label[text()='Customer ID:']/following-sibling::input")
    WebElement customerIDInput;
    @FindBy(xpath = "//label[text()='Select Items:']/following-sibling::div//select")
    WebElement selectItem;
    @FindBy(xpath = "//label[text()='Select Items:']/following-sibling::div//input[@type='number']")
    WebElement QuantityInput;

    @FindBy(xpath = "//button[@type='submit' and normalize-space()='Create Order']")
    WebElement CreateOrderButton;

//    public void clickCreateNewOrder(){
//        createNewOrder.click();
//    }

    public  void Form_Of_Create_NewOrder(String CustomerID , String Quantity ){
        EnterText(customerIDInput ,CustomerID );
        Select select = new Select(selectItem);
        select.selectByValue("6");
         EnterText(QuantityInput,Quantity);
         ClickButton(CreateOrderButton);
    }
}
