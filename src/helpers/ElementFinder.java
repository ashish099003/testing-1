package helpers;

import org.openqa.selenium.By;

public class ElementFinder {

	public static By getByType(String locatorType, String locatorValue) {		
		locatorType = locatorType.toLowerCase();
		if (locatorType == "id") {
			Log.info("Element located by id");
			return (By.id(locatorValue));
		}
		else if (locatorType == "name") {
			Log.info("Element located by name");
			return (By.name(locatorValue));
		}
		else if (locatorType == "xpath") {
			Log.info("Element located by xpath");
			return (By.xpath(locatorValue));
		}
		else if (locatorType == "css") {
			Log.info("Element located by css");
			return (By.cssSelector(locatorValue));
		}
		else if (locatorType == "classname") {
			Log.info("Element located by classname");
			return (By.className(locatorValue));
		}
		else if (locatorType == "linktext") {
			Log.info("Element located by link text");
			return (By.linkText(locatorValue));
		}
		return null;
	}
}
