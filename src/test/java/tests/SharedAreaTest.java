package tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.PageBase;
import Pages.SherdAreaPage;
import data.LoadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SharedAreaTest  extends TestBase {
    HomePage homePage ;
    LoginPage loginPage;
    SherdAreaPage sherdAreaPage;
    String username = LoadProperties.userData.getProperty("userName");
    String password = LoadProperties.userData.getProperty("password");
    @Test
    public void Open_Share_Area_Page()
    {
        loginPage = new LoginPage(driver);
        loginPage.UserCanLogin(username ,  password);
        homePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement SharedTab = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath( "//li[contains(text(),'Shared-Area')]")
                )
        );
        SharedTab.click();
    }

    //here you can choose what's the page you need to open
    @Test(dependsOnMethods = "Open_Share_Area_Page")
  public void open_All_Checkin_Page()
    {
        sherdAreaPage = new SherdAreaPage(driver);
        //sherdAreaPage.openAllCheckInPage();
        //sherdAreaPage.open_Vip_Area_CheckIn();
       // sherdAreaPage.open_Quiet_Area_CheckIn();
        sherdAreaPage.open_General_Area_CheckIn();
    }
//if you need open th Vip Page and make checkin to customer in Vip Page
    @Test(dependsOnMethods = "open_All_Checkin_Page")
    public void  open_Vip_Page()
    {
         homePage = new HomePage(driver);
        sherdAreaPage = new SherdAreaPage(driver);
        homePage.OpenShared_Area_Page();
        sherdAreaPage.open_Vip_Area_CheckIn();
    }

    //if you need open th Vip Page and make checkout to customer in Vip Page
    @Test(dependsOnMethods = "Open_Share_Area_Page")
    public void Customer_Check_Out_From_Vip_Page()
    {
        homePage = new HomePage(driver);
        sherdAreaPage = new SherdAreaPage(driver);
        homePage.OpenShared_Area_Page();
        sherdAreaPage.vipArea.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement CheckOutBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector( "button.btn-checkout")
                )
        );
        CheckOutBtn.click();
        sherdAreaPage.CheckOut_Customer_Button_From_Table();

    }

    //if you need Cancel  the checkin  in Vip Page run this
    @Test(dependsOnMethods = "Open_Share_Area_Page")
    public void Customer_Cancel_From_Vip_Page()
    {
        homePage = new HomePage(driver);
        sherdAreaPage = new SherdAreaPage(driver);
        homePage.OpenShared_Area_Page();
        sherdAreaPage.vipArea.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement CancelOutBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath( "//button[normalize-space()='Cancel' and @class='btn-delete']")
                )
        );
        CancelOutBtn.click();

        sherdAreaPage.CheckOut_Cancel_Button_From_Table("Test");

    }
}
