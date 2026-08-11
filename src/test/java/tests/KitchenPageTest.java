package tests;

import Pages.HomePage;
import Pages.KitchenPage;
import Pages.LoginPage;
import Pages.PageBase;
import data.LoadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class KitchenPageTest extends TestBase {
HomePage homePageObj  ;
KitchenPage  kitchenPageObj ;
LoginPage loginPageObj ;
String username = LoadProperties.userData.getProperty("userName");
String password = LoadProperties.userData.getProperty("password");

@Test(priority=1)
public void UserCanLogin(){
loginPageObj = new LoginPage(driver);
loginPageObj.UserCanLogin(username,password);
}

@Test(dependsOnMethods = "UserCanLogin")
    public void OpenKitchenPage() {
    homePageObj = new HomePage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    WebElement kitchenTab = wait.until(
            ExpectedConditions.elementToBeClickable(
                    By.xpath("//li[contains(text(),'Kitchen Items')]")
            )
    );

    kitchenTab.click();
}

@Test(dependsOnMethods="OpenKitchenPage")
public void openFormToAddNewItem(){
    kitchenPageObj =  new KitchenPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    WebElement OpenAddNewItemForm = wait.until(
            ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Add New Item')]")
            )
    );
    OpenAddNewItemForm.click();
}

@Test(dependsOnMethods = "openFormToAddNewItem")
    public void AddItem()  {
    kitchenPageObj =  new KitchenPage(driver);
    kitchenPageObj.AddNewItem("Snack" , 200);
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    WebElement waitSaveBtn= wait.until(
            ExpectedConditions.elementToBeClickable
          (
                  By.xpath("//*[@id=\"app\"]/div/div[2]/div/div[4]/div/form/div[5]/button[2]"))

    );
    waitSaveBtn.click();

}
}
