/*
 Launch new Browser
Open URL “http://toolsqa.wpengine.com/automation-practice-table/”
Get the value from cell ‘Dubai’ and print it on the console
Click on the link ‘Detail’ of the first row and last column
 */
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DynamicHandling {
	public static String baseUrl=null;
	private static String projectLocation = null;
	private static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		baseUrl = "http://toolsqa.wpengine.com/automation-practice-table";
		projectLocation =System.getProperty("user.dir");
		System.getProperty("webdriver.chrome.driver",projectLocation+"/libs/chromedriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		/*
		WebElement ele=driver.findElement(By.xpath("//*[@id=\"content\"]//tbody/tr//td[2]"));
		System.out.println(ele.getText());
		Thread.sleep(3000);
		ele= driver.findElement(By.xpath("//*[@id=\"content\"]//tbody/tr//td[6]/a"));
		ele.click();
		Thread.sleep(5000);
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Thread.sleep(2000);
	    Assert.assertTrue(currentUrl.contains("/automation-practice-table"));
		*/
		int i =1;
		while(driver.findElements(By.xpath("//*[@id=\"content\"]//tbody/tr[2]//td["+i+"]")).size()!=0) {
			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]//tbody/tr[2]//td["+i+"]")).getText());
			
			i++;
		}
		 System.out.println("Passed");
		driver.quit();
	}

}
