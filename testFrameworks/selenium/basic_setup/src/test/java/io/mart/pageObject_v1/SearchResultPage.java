package io.mart.pageObject_v1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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
