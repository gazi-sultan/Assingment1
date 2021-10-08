package seleniumAssignmnet;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadingProperties {
  @Test
  public void f() throws Exception {
	  
	  Properties prop=new Properties();
	  
	  FileInputStream fip=new FileInputStream("E:\\Assignment1\\src\\test\\java\\seleniumAssignmnet\\config.properties");
	  
	  prop.load(fip);
	  
	  System.out.println("Browser :" +prop.getProperty("browser"));
	  System.out.println("Url :" +prop.getProperty("url"));
	  System.out.println("Username :" +prop.getProperty("username"));
	  System.out.println("Password :" +prop.getProperty("password"));
	  
  }
}