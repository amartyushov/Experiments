package io.mart.pageObject_v1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PageObjectTest {

	private WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
	}

	@Test
	public void testGoogleSearch() throws Exception {
		driver.get("http://google.com");
		GoogleQueryPage queryPage = new GoogleQueryPage(driver);
		queryPage
				.searchFor("Cheese")
				.pressSearch()
				.elementContainsText("Cheese");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
	}
}
