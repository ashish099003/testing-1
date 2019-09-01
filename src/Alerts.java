import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
	
	private static String loc;
	
	
	public static void main( String [] args) {
		
		loc = System.getProperty("user.dir");
	//	System.getProperty("webdriver.chrome.driver", loc+"/libs/chromedriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");
		driver.manage().window().maximize();
//		System.out.println(driver.getWindowHandles());
		String handle = driver.getWindowHandle();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/p[4]/button")));
		driver.findElement(By.xpath("//*[@id=\"content\"]/p[4]/button")).click();
		Alert simpleAlert=driver.switchTo().alert();
		simpleAlert.accept();// simple alert done
		driver.switchTo().window(handle);
		WebElement ele=driver.findElement(By.xpath("//*[@id=\"content\"]/p[8]/button"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ele);
		Alert confirmationAlert=driver.switchTo().alert();
		confirmationAlert.accept();// confirmation alert
		driver.switchTo().window(handle);
		WebElement ele1=driver.findElement(By.xpath("//*[@id=\"content\"]/p[11]/button"));
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ele1);
		Alert prompt=driver.switchTo().alert();
		prompt.accept();// confirmation alert
		
		
		
		
		
		
		
	}
}
