package seleniumAssignmnet;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class ExtentReport {
	static WebDriver driver;
  @Test
  public void f() {
	  ExtentHtmlReporter htmlreporter=new ExtentHtmlReporter("ExtentReport1.html");
	  ExtentReports extent=new ExtentReports();
	  extent.attachReporter(htmlreporter);
	  
	  ExtentTest test2=extent.createTest("Login Functionality of SauceDemo.com","This is a test to validate login functionality");
	  test2.log(Status.INFO, "Starting the Test Case");
	  
	  driver.get("https://www.saucedemo.com/");
	  
	  test2.pass("Navigated to Home Page of saucedemo");
	  driver.findElement(By.id("user-name")).sendKeys("standard_user");
	  test2.pass("Entered Username");
	  driver.findElement(By.id("password")).sendKeys("secret_sauce");
	  test2.pass("Entered Password");
	  
	  driver.findElement(By.id("login-button")).click();
	  
	  test2.pass("Pressed the Login Button");
	  
	  test2.pass("Successfully Logged In");
	  
	  driver.close();
	  
	  test2.pass("Closed the browser");
	  
	  test2.pass("Test completed");
	  
	  extent.flush();
  }
  @BeforeClass
  public void beforeClass() {
	 WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
  }

}
