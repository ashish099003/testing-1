package test.TestNG;

import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class newWhatFix {
	private static WebDriver driver;


@BeforeMethod
public void setUp() {
	  try {
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("chrome.switches","--disable-extensions");
		  	String projectLocation = System.getProperty("user.dir");
			String baseUrl = "https://whatfix.com/quickolabs.com/#!flows/recent/";
			System.getProperty("webdriver.chrome.driver",projectLocation+"/libs/chromedriver/chromedriver");
		    driver = new ChromeDriver(options);
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(baseUrl);
			Reporter.log("Url Successfully Launched", true);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
}

@Test()
public void test1() throws InterruptedException, AWTException{	
		String str= "how to";
				
	
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
		
			driver.findElement(By.partialLinkText("Self Help")).click();
			
			int count=0;
			WebElement ifrm = driver.findElement(By.xpath("//*[@id=\"_widget_launcher_wfx_\"]/iframe"));
			driver.switchTo().frame(ifrm);
			Thread.sleep(2000);
		
		
		WebElement	ele=driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/div/div/table/tbody/tr/td[2]/input"));
			
		ele.sendKeys(str);
		WebElement	ele1=driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/div/div/table/tbody/tr/td[1]"));
			while(ele1.isDisplayed()){
				count =count+1;
						
			}
			ele.sendKeys(Keys.ENTER);
			java.util.List<WebElement> totalLink = driver.findElements(By.xpath("/html/body/table/tbody/tr[4]/td/div/div/div/div/div//a"));
			int sizeLink = totalLink.size()/2;
			System.out.println(totalLink.size());
			System.out.println(sizeLink);
			System.out.println(count);
			
			
			
			
			
}

@AfterMethod
public void closeSession() {
	 driver.quit();
}

}
