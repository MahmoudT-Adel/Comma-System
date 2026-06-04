package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
    public  static Properties userData  = loadProperties(System.getProperty("user.dir") +"\\src\\main\\java\\Properties\\userData.Properties") ;
    public  static Properties BranchData  = loadProperties(System.getProperty("user.dir") +"\\src\\main\\java\\Properties\\BranchData.Properties") ;
    public  static Properties RoomData  = loadProperties(System.getProperty("user.dir") +"\\src\\main\\java\\Properties\\RoomData.Properties") ;

    private static Properties loadProperties(String path) {
        Properties pro = new Properties();

        //System for reading file
        try {
            FileInputStream stream = new FileInputStream(path);
            pro.load(stream);
            stream.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Error Occur" +e.getMessage() );
        }
        catch (IOException s){
            System.out.println("Error Occur s" +s.getMessage() );
        }
        return pro ;
    }
}
