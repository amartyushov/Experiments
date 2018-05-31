package io.mart.webdriver.provider;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.visible;


public class DiffWebdriverProvidersTest {

	@Test
	public  void OpenURL() {
		Configuration.browser = "geckoDriverProvider";
		open("https://www.youtube.com/");
		SelenideElement loginPageLocator = $(By.id("logo-icon-container"));
		loginPageLocator.shouldBe(visible);
	}

	@Test
	public void testRRR() throws Exception {
		WebDriverRunner.setWebDriver(new ChromeDriver());
		open("https://www.youtube.com/");
		SelenideElement loginPageLocator = $(By.id("logo-icon-container"));
		loginPageLocator.shouldBe(visible);
		WebDriverRunner.closeWebDriver();
	}
}
