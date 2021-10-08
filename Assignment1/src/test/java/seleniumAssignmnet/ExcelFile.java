package seleniumAssignmnet;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelFile {
	
  @Test
  public void readData() throws Exception {
	  
	  FileInputStream fip=new FileInputStream("E:\\Gazi\\book1.xlsx");
	  
	  @SuppressWarnings("resource")
	XSSFWorkbook xbook=new XSSFWorkbook(fip);
	  
	  XSSFSheet xsheet=xbook.getSheet("Sheet1");
	  
	  int rowcount=xsheet.getLastRowNum();
	 
	  
	  for(int i=0;i<=rowcount;i++)
	  {
		 
			  XSSFCell result=xsheet.getRow(i).getCell(0);
			  System.out.println("Data at " +i+ " is " +result);
		  }
		
		 
	 
	
	  
  }
 
}
