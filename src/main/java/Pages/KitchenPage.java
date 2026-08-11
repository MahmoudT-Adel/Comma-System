package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class KitchenPage extends PageBase{
    public KitchenPage(WebDriver driver){
    super(driver);
    }

//    @FindBy(xpath = "//button[normalize-space()='Add New Item']\"")
//    WebElement addNewItemBtn;
    @FindBy(id = "name")
    WebElement itemName;
    @FindBy(id = "price")
    WebElement price;
    @FindBy(xpath = "//*[@id=\"category\"]")
    WebElement categoryDropdown;
    @FindBy(id="availability")
    WebElement availabilityDropdown;
   @FindBy(xpath = "\"//button[@type='submit']\"")
   WebElement submitButt;





//    public void OpenAddNewItemForm(){
//      ClickButton(addNewItemBtn);
//    }
    public void AddNewItem(String Name,int Price){
        itemName.sendKeys(Name);
        price.sendKeys(String.valueOf(Price));
        Select selectCategory = new Select(categoryDropdown);
        selectCategory.selectByVisibleText("Beverages");
        Select selectAvailability = new Select(availabilityDropdown);
        selectAvailability.selectByVisibleText("Out of Stock");

    }

    public void SaveBtn(){
        ClickButton(submitButt);
    }
}
