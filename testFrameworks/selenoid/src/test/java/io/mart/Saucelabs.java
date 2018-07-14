package io.mart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Saucelabs {

	public static final String USERNAME = "amartiushov";
	public static final String ACCESS_KEY = "1031b748-b0d0-46a5-89cb-9c58528fff08";
	public static final String URL_1 = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	public static void main(String[] args) throws Exception {

		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "latest");

		WebDriver driver = new RemoteWebDriver(new URL(URL_1), caps);

		/**
		 * Goes to Sauce Lab's guinea-pig page and prints title
		 */

//		driver.get("https://saucelabs.com/test/guinea-pig");
//		System.out.println("title of page is: " + driver.getTitle());

		driver.get("https://www.google.com/ncr");
//		Thread.sleep(10000); //slow down for demo purposes
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("webdriver");
		element.submit();
//		Thread.sleep(5000);

		driver.quit();
	}
}