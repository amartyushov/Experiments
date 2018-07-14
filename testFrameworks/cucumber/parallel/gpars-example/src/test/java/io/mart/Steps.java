package io.mart;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import java.awt.image.BufferedImage;

import static org.assertj.core.api.Assertions.assertThat;

public class Steps {
	private WebDriver driver;
	private Screenshots shots = new Screenshots();
	private Boolean propertyReplaceScreenshot = false;
	private Scenario scenario;

	@Before
	public void setUp(Scenario scenario) throws Exception {
		driver = new ChromeDriver();
		this.scenario = scenario;
	}

	@Given("^google page is opened$")
	public void googlePageIsOpened() {
		driver.get("http://www.google.com");
		shots.captureScreenshotAlternative(driver);
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			shots.createAttachment(driver);
		}
		driver.quit();
	}

	@Then("^search string is empty$")
	public void searchStringIsEmpty() {
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Chees");
		WebElement element = driver.findElement(By.cssSelector("div .tsf-p"));

		String screenshotName = shots.prepareScreenshotName(scenario);
		BufferedImage elementScreenshot = shots.makeElementScreenshot(driver, element);

		if (propertyReplaceScreenshot) {
			shots.saveScreenshot(screenshotName, elementScreenshot);
		} else {
			ImageDiff diff = new ImageDiffer().makeDiff(shots.readImage(screenshotName), elementScreenshot);

			shots.showDiff(diff);
			shots.showDiffSize(diff);
			System.out.println(shots.diffInPercentage(diff));
			assertThat(diff.withDiffSizeTrigger(2100).hasDiff()).isTrue();
		}
	}
}
