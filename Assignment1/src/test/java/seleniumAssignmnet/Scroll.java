package seleniumAssignmnet;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scroll{
	static WebDriver driver;
  @Test
  public void f() {
	  driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
	  driver.manage().window().maximize();
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("scroll(0,400)");
  }
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }
  }

