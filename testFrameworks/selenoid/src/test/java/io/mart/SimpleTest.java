package io.mart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;

public class SimpleTest {

	@Test
	public void testMethod() throws InterruptedException, MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("firefox");
		capabilities.setVersion("66.0");
		capabilities.setCapability("enableVNC", true);
//		capabilities.setCapability("enableVideo", true);
//		capabilities.setCapability("videoName", "my-cool-video.mp4");
		capabilities.setCapability("name", "myCoolTestName");    // session have this name on UI


		RemoteWebDriver driver = new RemoteWebDriver(
				URI.create("http://172.16.9.235:4446/wd/hub").toURL(),
				capabilities
		);


		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(10000);

		System.out.println("Page title is: " + driver.getTitle());
		(new WebDriverWait(driver, 10)).until(
				(ExpectedCondition<Boolean>) d -> d.getTitle().toLowerCase().startsWith("cheese!"));

		System.out.println("Page title is: " + driver.getTitle());

		driver.quit();
	}
}
