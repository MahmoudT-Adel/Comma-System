package tests;

import Pages.CustomerPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class CustomerPageTest extends TestBase{
    HomePage HomePageObj;
    LoginPage LoginPageObj;
    CustomerPage CustomerPageObj;

  @Test
    public void CustomerPageTest() throws InterruptedException {
      LoginPageObj = new LoginPage(driver);
      LoginPageObj.UserCanLogin("40004000400022", "Comma@123");
        HomePageObj = new HomePage(driver);
      Thread.sleep(4000);
        HomePageObj.OpenCustomerPage();
    }

    @Test(dependsOnMethods = "CustomerPageTest")
    public void AddNewCustomer()  {
        CustomerPage CustomerPageObj = new CustomerPage(driver);
        CustomerPageObj.OpenScreenToAddCustomer();
        CustomerPageObj.EnterTextToAddCustomer("TestAuto1" , "TestAuto@gmail.com" , "01004989814");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


        //Waiting to the option disappears
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(
                By.id("branch"),
                By.xpath("//*[@id=\"branch\"]/option")
        ));
       WebElement branch = driver.findElement(By.id("branch"));
        Select select = new Select(branch);
        select.selectByVisibleText("Dokki");
//        CustomerPageObj.CancelButton.click();
        CustomerPageObj.checkInCheckbox.click();

        WebDriverWait waitAddBtn = new WebDriverWait(driver, Duration.ofSeconds(20));

     waitAddBtn.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='Save']")
                ));

        CustomerPageObj.AddNewCustomerButton.click();
    }



   @Test (dependsOnMethods = "CustomerPageTest")
   public void SearchOfClient()  {
       CustomerPageObj = new CustomerPage(driver);
       CustomerPageObj.SearchOfCustomer();
   }



}
