package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class Calc {

  public static void main(String[] args) {
    Properties prop = new Properties();
    FileInputStream fis = null;
    File file = new File("calc.properties");
    
    
    try {
      fis = new FileInputStream(file);
      prop.load(fis);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }finally {
      if(fis !=null) {
        try {
                fis.close();
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
      }
    }
    
        
     
    int su1 = 0;
    int su2 = 0;
    
    su1 = Integer.parseInt(prop.getProperty("su1")); 
    su2 = Integer.parseInt(prop.getProperty("su2")); 
    
    System.out.println(su1+su2);
    System.out.println(su1-su2);
    System.out.println(su1/su2);
    System.out.println(su1*su2);
    System.out.println(su1%su2);
    

  }
  }