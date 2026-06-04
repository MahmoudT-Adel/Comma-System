package helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helpers {
public static void captureScreenShot(WebDriver  driver , String screenShotName){
    Path destination = Paths.get("./ScreenShots" +screenShotName + ".png");
    try{
        Files.createDirectories(destination.getParent());
        FileOutputStream out = new FileOutputStream(destination.toFile());
        out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        out.close();
    }catch (Exception e){
        System.out.println("Screen Shot Error" + e.getMessage());
    }

}
}
