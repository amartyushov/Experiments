package io.mart.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {

	By resultLocator = By.cssSelector("#ires .g");

	private WebDriver driver;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
	}

	public void elementContainsText(String text) {
		assert driver.findElements(resultLocator).get(0).getText().contains(text);
	}
}
