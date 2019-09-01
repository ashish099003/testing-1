import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Setup {
	
	WebDriver driver;
	
	@BeforeMethod
	public void browserSetup() throws InterruptedException
	{
		Reporter.log("Browser session started", true);
		String	baseUrl ="http://www.coviam.com/";
		String projectLocation = System.getProperty("user.dir");
    	System.getProperty("webdriver.chrome.driver",projectLocation+"/libs/chromedriver/chromedriver");
    	WebDriver driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(baseUrl);
		Assert.assertEquals(baseUrl, driver.getCurrentUrl());
		
		Reporter.log("Suceessfully launched", true);	
		
	}
	@AfterMethod
	public void closeSession()
	{
		driver.quit();
		
		Reporter.log("Browser session ended", true);
	}
 

}
