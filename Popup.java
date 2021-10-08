package seleniumAssignmnet;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Popup {
	public WebDriver driver;
  @Test
  public void f() throws Exception {
	 
	  driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
	  String parentwin=driver.getWindowHandle();
	  System.out.println(parentwin);
	
	  driver.findElement(By.xpath("//*[@id=\"newWindowBtn\"]")).click();
	  
	  Set<String> childwin=driver.getWindowHandles();
	  for(String handle: childwin)
	  {
		  if(!handle.equals(parentwin))
			 {
			  driver.switchTo().window(handle);
			  
			  System.out.println(driver.findElement(By.xpath("//*[@id=\"post-body-7593811851313663875\"]/div/div/h1")).getText());
			  
			  
			  driver.close();
			 }
	  }
	  driver.switchTo().window(parentwin);
	  Thread.sleep(1000);
	 driver.findElement(By.id("newTabBtn")).click();
	  Thread.sleep(2000);
	  Set<String> newHand=driver.getWindowHandles();
	  for(String newH:newHand)
	  {
		  if(!newH.equals(parentwin))
		  {
			  driver.switchTo().window(newH);
			  Thread.sleep(2000);
			  driver.findElement(By.id("alertBox")).click();
			  Thread.sleep(2000);
			  driver.switchTo().alert().accept();
			 
			  
			  driver.close();
		  }
	  }
	  driver.switchTo().window(parentwin);
  }
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}