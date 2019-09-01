package coviamPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class coviamTest {
	
	private static XSSFSheet excelSheet;
	private static XSSFWorkbook wb;
	private static WebDriver driver;
	
	public static   String ReadData( String path,int SheetNo, int rowNo, int cellNo) throws Exception{
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
	
	@BeforeMethod(description=" It Will Launch Coviam url")
	public static  void setUp()  throws Exception{
		try {
		String projectLocation = System.getProperty("user.dir");
		System.getProperty("webdriver.chrome.driver",projectLocation+"/libs/chromedriver/chromedriver");
	    driver = new ChromeDriver();	
		driver.get("http://www.coviam.com");
		Reporter.log("Url Successfully Launched", true);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test(priority=1, description="This testcase will test all the links")
	public static void checkAllLinks() throws InterruptedException {
				
		Thread.sleep(2000);
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		java.util.List<String> absLink= new ArrayList<String>();
		String path ="//Users//ashu//eclipse-workspace//testing1//test data//xapth_coviam.xlsx";// mention the correct path
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele=null;
		try {
		for (int i = 0; i<links.size(); i=i+1){
			
			if(links.get(i).getAttribute("href")!=null)
				{			
				//System.out.println(links.get(i).getAttribute("href"));
				absLink.add(links.get(i).getAttribute("href"));								
				}			
			else {
			//	System.out.println(links.get(i).getAttribute("id"));
				absLink.add(links.get(i).getAttribute("href"));
			}			
		}											
		   for (int j=1;j<4;j++) {			
			String xPath = ReadData(path,0,j,1);	
			String name = ReadData(path,0,j,0);
		//	System.out.println(name);
			if(name.equalsIgnoreCase("Culture") ||name.equalsIgnoreCase("Jobs")) {
		//		Actions action = new Actions(driver);    
				ele=driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[6]"));
				js.executeScript("arguments[0].scrollIntoView();", ele);
				ele.click();
				//System.out.println(ele.isSelected());
				 Thread.sleep(5000);		
				ele=driver.findElement(By.linkText(name));
				js.executeScript("arguments[0].scrollIntoView();", ele);
				ele.click();				
			}
			else {					
			    ele =	driver.findElement(By.xpath(""+xPath+""));
			    Thread.sleep(5000);
			    js.executeScript("arguments[0].scrollIntoView();", ele);
			    Thread.sleep(5000);			
		    	ele.click();
			}
			Thread.sleep(2000);
			java.util.List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
			int count = browserTabs.size();
			
			if(count>1) {
				Thread.sleep(2000);
				driver.switchTo().window(browserTabs.get(1));
				java.util.List<String> currLink= new ArrayList<String>();
				 String currentLink = driver.getCurrentUrl();
				 currLink.add(currentLink);
				 Thread.sleep(3000);
			//	 Assert.assertTrue(absLink.containsAll(currLink));
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
			//	 Assert.assertTrue(absLink.containsAll(currLink));				 
				 Thread.sleep(2000);
				 driver.navigate().back();				 
			}
		}						
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());			
		}		
	}
	
	 @Test(priority=2, description="This testcase will look up location in career UI")
	 public  static void bangaloreLocation() throws InterruptedException
		{
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver; 	 
		    WebElement ele=driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[6]"));
			ele.click();
			//System.out.println(ele.isSelected());
			Thread.sleep(2000);	
			ele=driver.findElement(By.linkText("Jobs"));			
			ele.click();	
			Thread.sleep(5000);
			java.util.List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(browserTabs.get(1));
			Thread.sleep(2000);
			ele=driver.findElement(By.xpath("//*[@id='search_location']"));
			Thread.sleep(2000);
			
			js.executeScript("arguments[0].scrollIntoView();", ele);
			ele.sendKeys("bangalore");
			ele.sendKeys(Keys.ENTER);
			
			//job_listings, //*[@id="content"]/div[7]/ul/li[2]/a//div[2],,, //*[@id="content"]/div/div/article/div[3]/div/div[2]/p[4],,,,,//*[@id="content"]/div[7]/ul/li[1]/a
			Thread.sleep(2000);
			int k=1;
			while(driver.findElements(By.xpath("//*[@id='content']/div[7]/ul/li["+k+"]/a")).size()!=0) {
				//System.out.println(k);
				driver.findElement(By.xpath("//*[@id='content']/div[7]/ul/li["+k+"]/a")).click();
				Thread.sleep(3000);
				String location = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/article/div[3]/div/ul/li[2]/a")).getText();
				Assert.assertTrue(location.contains("Bangalore"));
				driver.navigate().back();
				Thread.sleep(2000);
				k=k+1;
				
			}								
		}
	@AfterMethod
	public void closeSession() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		//File htmlFile = new File("Users\\ashu\\eclipse-workspace\\testing1\\test-output\\index.html");
		//Desktop.getDesktop().browse(htmlFile.toURI());
		driver.get("file:///Users/ashu/eclipse-workspace/testing1/test-output/index.html");
		Thread.sleep(3000);
		driver.quit();
		Reporter.log("Browser session ended", true);
	}
	
    
   
  
        
}

