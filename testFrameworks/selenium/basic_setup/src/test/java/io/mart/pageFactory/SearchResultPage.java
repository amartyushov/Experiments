package io.mart.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage {

	private WebDriver driver;

	@FindBy(css = "#ires .g")
	private List<WebElement> results;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void elementContainsText(String text) {
		assert results.get(0).getText().contains(text);
	}
}
