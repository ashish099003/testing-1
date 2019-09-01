package test.TestNG;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.DriverInit;


public class TestWhatFix extends DriverInit{
	//private static WebDriver driver;
	
/*
	  @BeforeMethod
	  public void setUp() {
		  try {
			  	String projectLocation = System.getProperty("user.dir");
				String baseUrl = "https://whatfix.com/quickolabs.com/#!flows/how-to-import-google-analytics-solution-of-whatfix/8174f470-9df9-11e3-8178-386077c653fe/";
				System.getProperty("webdriver.chrome.driver",projectLocation+"/libs/chromedriver/chromedriver");
			    driver = new ChromeDriver();
			    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.get(baseUrl);
				Reporter.log("Url Successfully Launched", true);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
	  }
	  */
	@Test
	public void test1() throws InterruptedException {	
				DriverInit.setDriver();
				DriverInit.driverInit("https://whatfix.com/quickolabs.com/#!flows/how-to-import-google-analytics-solution-of-whatfix/8174f470-9df9-11e3-8178-386077c653fe/");
				driver.findElement(By.linkText("Self Help")).click();
				WebElement ifrm = driver.findElement(By.xpath("//*[@id=\"_widget_launcher_wfx_\"]/iframe"));
				driver.switchTo().frame(ifrm);
				driver.findElement(By.id("wfx-dashboard-self-help-flow-12ec5470-746f-11e8-a994-04013d24cd02")).click();						
				driver.switchTo().defaultContent();
				driver.findElement(By.id("wfx-dashboard-content-embed")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("wfx-dashboard-content-embed-slideshow")).click();	
				Thread.sleep(2000);
				driver.findElement(By.linkText("next")).click();
				driver.switchTo().frame("wfx-frame-endPopup");
				driver.findElement(By.xpath("/html/body/div[2]/a")).click();
				driver.switchTo().defaultContent();
		
	
	}
	
	 @AfterMethod
	  public void closeSession() {
		 driver.quit();
	  }
}
