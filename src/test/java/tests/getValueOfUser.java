package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class getValueOfUser {
    public static String getUserName (String username) throws IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("D:\\testGitHub\\System Comma\\src\\main\\java\\Properties\\userData.Properties");
   prop.load(file);
   return prop.getProperty(username );
    }
    public static String getUserPass (String password) throws IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("D:\\testGitHub\\System Comma\\src\\main\\java\\Properties\\userData.Properties");
        prop.load(file);
        return prop.getProperty(password );
    }
}
