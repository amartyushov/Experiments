package io.mart.pageFactory;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class GoogleQueryPage {

	private WebDriver driver;

	@FindBy(name = "q")
	private WebElement queryString;

	@FindBy(name = "btnK")
	private WebElement searchButton;


	public GoogleQueryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

		if (!"Google".equals(driver.getTitle())) {
			throw new IllegalStateException("This is not the google search page");
		}
	}

	public GoogleQueryPage searchFor(String value) {
		log.info("Input" + value + " to search string");
		queryString.sendKeys(value);
		return this;
	}

	public SearchResultPage pressSearch() {
		log.info("Press search button");
		searchButton.click();
		return new SearchResultPage(driver);
	}
}
