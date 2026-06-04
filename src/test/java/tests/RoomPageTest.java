package tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RoomPage;
import data.LoadProperties;
import org.testng.annotations.Test;

public class RoomPageTest extends TestBase{
    HomePage homePageObj;
    LoginPage loginPageObj;
    RoomPage roomPageObj;
    String userName = LoadProperties.userData.getProperty("userName");
    String password = LoadProperties.userData.getProperty("password");
    String roomName = LoadProperties.RoomData.getProperty("RoomName");
    String branchName = LoadProperties.BranchData.getProperty("BranchName");
    String roomType = LoadProperties.RoomData.getProperty("RoomType");
    String roomCapacity = LoadProperties.RoomData.getProperty("RoomCapacity");
    String roomPrice = LoadProperties.RoomData.getProperty("RoomPrice");
    @Test
    public void OpenRoomPage() throws InterruptedException {
        loginPageObj = new LoginPage(driver);
        loginPageObj.UserCanLogin(userName ,password);
        homePageObj = new HomePage(driver);
        Thread.sleep(4000);
        homePageObj.OpenRoomsPage();
    }

//@Test(dependsOnMethods = "OpenRoomPage")
//    public void AddRoom()  {
//       roomPageObj = new RoomPage(driver);
//       roomPageObj.AddNewRoom(
//               roomName ,
//               branchName ,
//               roomType ,
//               Integer.parseInt( roomCapacity),
//               Integer.parseInt(roomPrice) );
//}

//@Test(dependsOnMethods = "OpenRoomPage")
//    public void EditTheRoom() throws InterruptedException{
//        roomPageObj = new RoomPage(driver);
//        Thread.sleep(9000);
//        roomPageObj.EditTheRoom();
//
//}

@Test(dependsOnMethods = "OpenRoomPage")
public void Delete() throws InterruptedException
{
        roomPageObj = new RoomPage(driver);
    Thread.sleep(9000);
        roomPageObj.DeleteTheRoom();
}
}


