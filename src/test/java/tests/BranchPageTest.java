package tests;

import Pages.BranchPage;
import Pages.HomePage;
import Pages.LoginPage;
import data.LoadProperties;
import org.testng.annotations.Test;

public class BranchPageTest  extends TestBase{
    HomePage homePageObj ;
    LoginPage loginPageObj;
    BranchPage branchPageObj;
    String userName = LoadProperties.userData.getProperty("userName");
    String password = LoadProperties.userData.getProperty("password");
    String BranchName = LoadProperties.BranchData.getProperty("BranchName");
    String BranchLocation = LoadProperties.BranchData.getProperty("BranchLocation");
    String BranchPhone =  LoadProperties.BranchData.getProperty("BranchPhone");
    String RoomsCount =  LoadProperties.BranchData.getProperty("RoomsCount");
    String EmployeesCount =   LoadProperties.BranchData.getProperty("EmployeesCount");
    // String CustomersCount =  LoadProperties.BranchData.getProperty("CustomersCount");

    @Test(priority = 1)
    public void OpenBranchPageTest() throws InterruptedException{
        loginPageObj = new LoginPage(driver);
        loginPageObj.UserCanLogin(userName ,password);
        homePageObj = new HomePage(driver);
        Thread.sleep(4000);
        homePageObj.OpenBranchPage();
    }

    @Test(dependsOnMethods = "OpenBranchPageTest")
    public void AddNewBranch() {
        branchPageObj = new BranchPage(driver);
        branchPageObj.AddBranch(
                BranchName ,
                BranchLocation ,
                BranchPhone ,
                Integer.parseInt(RoomsCount),
                Integer.parseInt(EmployeesCount)
        );

    }

    //Edit Your Branch........
    @Test(priority = 2)
    public void CanYouEditYourBranch() throws InterruptedException
    {
        branchPageObj = new BranchPage(driver);
        Thread.sleep(3000);
        branchPageObj.EditYourBranch();
    }

    //Delete Your Branch

    @Test(priority = 3)
    public void CanYouDeleteYourBranch() throws InterruptedException
    {
        branchPageObj = new BranchPage(driver);
        Thread.sleep(3000);
       branchPageObj.DeleteYourBranch();

    }


}


