package tests;

import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class EmployeesPageTest extends TestBase{
    HomePage HomePageObj;
    LoginPage LoginPageObj;


    @Test
    public void CustomerPageTest() throws InterruptedException {
        LoginPageObj = new LoginPage(driver);
        LoginPageObj.UserCanLogin("40004000400022", "Comma@123");
        HomePageObj = new HomePage(driver);
        Thread.sleep(4000);
        HomePageObj.OpenCheckInPage();
    }
}
