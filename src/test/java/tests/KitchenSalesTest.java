package tests;

import Pages.HomePage;
import Pages.KitchenSalesPage;
import Pages.LoginPage;
import data.LoadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class KitchenSalesTest extends  TestBase{
    HomePage homePageObj;
    LoginPage loginPageObj;
    String username = LoadProperties.userData.getProperty("userName");
    String password = LoadProperties.userData.getProperty("password");

    @Test(priority=1)
    public void UserCanLogin(){
        loginPageObj = new LoginPage(driver);
        loginPageObj.UserCanLogin(username,password);
    }

    @Test(dependsOnMethods = "UserCanLogin")
    public void OpenKitchenSalesTest(){
        homePageObj = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement kitchenTab = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//li[contains(text(),'Kitchen Sales')]")
                )
        );
        kitchenTab.click();
       // homePageObj.OpenKitchenSalesPage();
    }

    @Test(dependsOnMethods = "OpenKitchenSalesTest")
    public void clickCreateNewOrder(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        Boolean toast_success = wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        By.cssSelector("div.toast.toast-success")
        ));
        if (toast_success){
            driver.findElement(By.xpath("//button[normalize-space()='Create New Order']")).click();
            KitchenSalesPage kitchenSalesPageObj = new KitchenSalesPage(driver);
            kitchenSalesPageObj.Form_Of_Create_NewOrder("DOK-1099" , "3");
        }

    }
}
