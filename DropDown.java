package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver= new ChromeDriver();
		 driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		  driver.manage().window().maximize();
		  WebElement dd=driver.findElement(By.id("option-droup-demo"));
		  Select select=new Select(dd);
		  select.selectByValue("jQuery");
		  //Thread.sleep(5000);
		  driver.close();
		  
		  
	}
	
}
