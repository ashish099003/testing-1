package test.TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class NewTest {
	private static WebDriver driver;
 
  @BeforeMethod
  public void setUp() {
	  try {
			String projectLocation = System.getProperty("user.dir");
			System.getProperty("webdriver.chrome.driver",projectLocation+"/libs/chromedriver/chromedriver");
		    driver = new ChromeDriver();	
			driver.get("http://bit.ly/dxqatest-online");
			Reporter.log("Url Successfully Launched", true);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
  }
  
  @Test
  public static void testForm() {
	  String textElement=null;
	  WebElement ele=driver.findElement(By.id("//*[@id=\"js-link-box-en\"]/strong"));
	  ele.sendKeys("deltaX");
	  textElement=ele.getText();
	  System.out.println(textElement);
	  Assert.assertTrue(textElement.length()>1);
	  ele=driver.findElement(By.xpath("//*[@name='last_name']"));
	  ele.sendKeys("lastname");
  }

  @AfterMethod
  public void closeSession() {
	  	driver.quit();
		Reporter.log("Browser session ended", true);
		Scanner scan = new Scanner(System.in);
		System.out.println("");
  }

}
