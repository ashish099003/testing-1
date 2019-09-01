package helpers;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import helpers.Log;

public class DriverInit {

	public static WebDriver driver = null;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver() {
		String projectLocation = System.getProperty("user.dir");
		System.getProperty("webdriver.chrome.driver",projectLocation+"/libs/chromedriver/chromedriver" );
		driver = new ChromeDriver();
		
		Log.info("Chrome is launched");
	}

	public static void driverInit(String baseUrl) {
		driver.get(baseUrl);
		//driver.manage().window().maximize();
		Log.info("Base URL is launched");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Log.info("10 seconds implicit wait is implemented");
	}

	public static void driverClose() {
		driver.close();
	}
}
