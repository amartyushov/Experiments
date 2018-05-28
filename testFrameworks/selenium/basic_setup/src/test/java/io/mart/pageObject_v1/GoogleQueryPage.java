package io.mart.pageObject_v1;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class GoogleQueryPage {

	private By queryStringLocator = By.name("q");
	private By searchButtonLocator = By.name("btnK");

	private WebDriver driver;

	public GoogleQueryPage(WebDriver driver) {
		this.driver = driver;

		if (!"Google".equals(driver.getTitle())) {
			throw new IllegalStateException("This is not the google search page");
		}
	}

	public GoogleQueryPage searchFor(String value) {
		log.info("Input" + value + " to search string");
		driver.findElement(queryStringLocator).sendKeys(value);
		return this;
	}

	public SearchResultPage pressSearch() {
		log.info("Press search button");
		driver.findElement(searchButtonLocator).click();
		return new SearchResultPage(driver);
	}
}
