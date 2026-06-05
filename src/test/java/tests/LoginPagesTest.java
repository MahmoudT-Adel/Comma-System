package tests;

import Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPagesTest extends TestBase{
    LoginPage loginPageObj;

    @Test(description = "Verify that a user can successfully log in with valid credentials")
    public void userCanLoginSuccessfully(){
        loginPageObj = new LoginPage(driver);
         loginPageObj.UserCanLogin("4000*********" , "*********");
    }
}
