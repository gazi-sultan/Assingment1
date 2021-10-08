package seleniumAssignmnet;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Data {
	
	static WebDriver driver; 
	
  @Test(dataProvider = "dp")
  public void f(String username, String password) throws Exception {
	  
	  driver.get("https://www.saucedemo.com/");
	  
	  
	  driver.findElement(By.id("user-name")).sendKeys(username);
	  driver.findElement(By.id("password")).sendKeys(password);
	  driver.findElement(By.id("login-button")).click();
	  
	
	  driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
	  Thread.sleep(200);
	  driver.findElement(By.id("logout_sidebar_link")).click();
	  
  }

  @DataProvider
  public Object[][] dp() {
	  
	  Object[][] data=new Object[2][2];
	  data[0][0]="standard_user";
	  data[0][1]="secret_sauce";
	  data[1][0]="problem_user";
	  data[1][1]="secret_sauce";
    return data;
      
  }
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
  }

  @AfterClass
  public void afterClass() {
	  
	  driver.close();
  }

}
