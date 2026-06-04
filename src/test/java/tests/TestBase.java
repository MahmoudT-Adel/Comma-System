package tests;

import helpers.Helpers;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;


public class TestBase {
WebDriver driver;

@BeforeTest
    public void setUp(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("document.body.style.zoom='60%'");
    driver.navigate().to("https://comma-co-working-space.up.railway.app/login");
}



//public void setUpWithHeadless(){
//    ChromeOptions options = new ChromeOptions();
//    options.addArguments("--headless=new");
//
//    driver = new ChromeDriver(options);
//    driver.get("https://web-production-d11f.up.railway.app/login");
//}

    @AfterMethod
    public  void ScreenshotOnFailure(ITestResult results) throws IOException{
        if (results.getStatus() == ITestResult.FAILURE){
            System.out.println("Failed!");
            System.out.println("Taking Screenshot...");
            Helpers.captureScreenShot(driver, results.getName());

        }

    }

    @AfterTest
    public void CleanUp(){
        driver.close();

    }

}
