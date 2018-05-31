package io.mart.screenshot;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.ScreenShooter;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Listeners({ ScreenShooter.class})
public class GoogleTest {

	@BeforeMethod
	public void setUp() throws Exception {
		Configuration.reportsFolder = "test-result/reports";

		//To automatically take screenshots after every test (even succeeded)
		// works of course only in combination with @Listeners({ ScreenShooter.class})
		ScreenShooter.captureSuccessfulTests = true;

	}

	@Test
	public void search_selenide_in_google() {
		open("https://google.com/ncr");

		// you can do it at any time
		screenshot("google opened");

		$(By.name("q")).val("selenide").pressEnter();
		$$("#ires .g").shouldHave(sizeGreaterThan(1));
		$("#ires .g").shouldBe(visible).shouldHave(
				text("Selenide: concise UI tests in Java"),
				text("selenide.org"));
	}
}
