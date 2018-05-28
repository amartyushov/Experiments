package io.mart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BasicTest {

	@Test
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();

		System.out.println("Page title is: " + driver.getTitle());
		(new WebDriverWait(driver, 10)).until(
				(ExpectedCondition<Boolean>) d -> d.getTitle().toLowerCase().startsWith("cheese!"));

		System.out.println("Page title is: " + driver.getTitle());

		driver.quit();
	}
}
