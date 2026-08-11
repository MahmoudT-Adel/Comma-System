package tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RoomsBookingPage;
import data.LoadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class RoomsBookingTest extends TestBase {
    HomePage homePage ;
    LoginPage loginPage;
    RoomsBookingPage roomsBookingPage;
    String username = LoadProperties.userData.getProperty("userName");
    String password =LoadProperties.userData.getProperty("password");
   String customerId="DOK-1029";

   @Test
   public void User_Can_log(){
       loginPage = new LoginPage(driver);
       loginPage.UserCanLogin(username,password);
   }

   //Run this when add new checkin
//    @Test
//    public void Open_Rooms_Booking_Page(){
//        homePage = new HomePage(driver);
//        roomsBookingPage = new RoomsBookingPage(driver);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        WebElement RoomPage =wait.until(
//                ExpectedConditions.elementToBeClickable(
//                        By.xpath( "//li[contains(., 'Room Bookings')]")
//                )
//        );
//        RoomPage.click();
//        roomsBookingPage.Click_Check_In_Btn(customerId);
//
//    }

    //Run this when add new checkOut
    @Test(dependsOnMethods = "User_Can_log")
    public void Check_Out_Rooms_Booking_Page(){
        homePage = new HomePage(driver);
        roomsBookingPage = new RoomsBookingPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement RoomPage =wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath( "//li[contains(., 'Room Bookings')]")
                )
        );
        RoomPage.click();
        roomsBookingPage.Check_Out_Room(customerId);
    }
}
