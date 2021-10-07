package assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class DragDrop {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
	  
		  	 driver.get("https://jqueryui.com/droppable/");
		  	 driver.manage().window().maximize();
			 Thread.sleep(500);
			 
			  
			  Actions act=new Actions(driver);
			  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/iframe")));
			  
			  WebElement from=driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
			  WebElement to=driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
			  act.dragAndDrop(from, to).build().perform();
			  
			 
			  Thread.sleep(5000);
			  String txt=driver.findElement(By.xpath("//*[@id=\"droppable\"]/p")).getText();
			  if(txt.equals("Dropped!"))
				{
					  System.out.println("Drag Successful");
				  }
			  else
			  {
				  System.out.println("Drag Unsuccessful");
			  }
	
 

  
  
	  
	  driver.close();
  }

}
