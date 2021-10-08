package seleniumAssignmnet;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class SendValue {
	static WebDriver driver;
  @Test
  public void f() {
	  driver.get("https://www.saucedemo.com/");
  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("document.getElementById('user-name').value='Gazi'");
  }
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.close();
  }

}