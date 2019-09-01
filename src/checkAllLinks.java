
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.Assert;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class checkAllLinks extends Setup {
	private static XSSFSheet excelSheet;
	private static XSSFWorkbook wb;
	
	public  String ReadData( String path,int SheetNo, int rowNo, int cellNo) throws Exception{
		String str=null;
		
		try {
			File srs = new File(path);
			FileInputStream excelFile = new FileInputStream(srs);
			wb = new XSSFWorkbook(excelFile);
			excelSheet= wb.getSheetAt(SheetNo);
			str= excelSheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
			
		
		}
		catch (Exception e) {		
			System.out.println(e.getMessage());
		}
		return str;
	}
	@Test(description="Test case for checking all links @coviam.com")
	public void validlogin()
	{						  		
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		java.util.List<String> absLink= new ArrayList<String>();
	//	java.util.List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		
	
		System.out.println(links.size());
	
		for (int i = 0; i<links.size(); i=i+1){
			
			if(links.get(i).getAttribute("href")!=null)
				{			
			//	System.out.println(links.get(i).getAttribute("href"));
				absLink.add(links.get(i).getAttribute("href"));								
				}
			
			else {
			//	System.out.println(links.get(i).getAttribute("id"));
				absLink.add(links.get(i).getAttribute("href"));
			}
			
			
		}
		
		try {
			String path ="//Users//ashu//eclipse-workspace//testing1//test data//xapth_coviam.xlsx";
		//	String parentWindow=driver.getWindowHandle();
			WebElement ele=null;
			JavascriptExecutor js = (JavascriptExecutor) driver;
			for (int j=9;j<32;j++) {
			
			String xPath = ReadData(path,0,j,1);	
			String name = ReadData(path,0,j,0);
			System.out.println(name);
			if(name.equalsIgnoreCase("Culture") ||name.equalsIgnoreCase("Jobs")) {
				ele=driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[6]"));
				js.executeScript("arguments[0].scrollIntoView();", ele);
				ele.click();
				Thread.sleep(5000);		
				ele=driver.findElement(By.linkText(name));
				js.executeScript("arguments[0].scrollIntoView();", ele);
				ele.click();
				
			}
			else {					
			    ele = driver.findElement(By.xpath(""+xPath+""));
			    Thread.sleep(5000);
			    js.executeScript("arguments[0].scrollIntoView();", ele);
			    Thread.sleep(5000);			
		    	ele.click();
			}
			Thread.sleep(2000);
			java.util.List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
			int count = browserTabs.size();
			System.out.println(count);
			if(count>1) {
				Thread.sleep(2000);
				driver.switchTo().window(browserTabs.get(1));
				java.util.List<String> currLink= new ArrayList<String>();
				 String currentLink = driver.getCurrentUrl();
				 currLink.add(currentLink);
				 Thread.sleep(3000);
				 Assert.assertTrue(absLink.containsAll(currLink));
				 driver.close();
				 Thread.sleep(2000);
				 driver.switchTo().window(browserTabs.get(0));
			}	
			
			else {
				Thread.sleep(2000);
				
				java.util.List<String> currLink= new ArrayList<String>();
				 String currentLink = driver.getCurrentUrl();
				 currLink.add(currentLink);
				 Thread.sleep(2000);
				 Assert.assertTrue(absLink.containsAll(currLink));				 
				 Thread.sleep(2000);
				 driver.navigate().back();
				 
			}
		}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			//System.out.println("Enter Correct File Path");
		}
		
		
		Reporter.log("We are on Selenium catogery", true);
	}


	
	
	
	@AfterTest
	public void closeSession()
	{
		driver.quit();
		Reporter.log("Browser session ended", true);
	}
	
}
