package io.mart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.cropper.indent.IndentCropper;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Paths;
import java.util.List;

import static ru.yandex.qatools.ashot.cropper.indent.IndentFilerFactory.blur;

public class SimpleTest {
	WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {
//		driver = new ChromeDriver();

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("firefox");
		capabilities.setVersion("60.0");
		capabilities.setCapability("enableVNC", true);
		capabilities.setCapability("enableVideo", true);
		capabilities.setCapability("videoName", "my-cool-video.mp4");
		capabilities.setCapability("name", "myCoolTestName");    // session have this name on UI


		driver = new RemoteWebDriver(
				URI.create("http://localhost:4444/wd/hub").toURL(),
				capabilities
		);
	}

	@Test
	public void testFullPageScreenshot() throws Exception {
		driver.get("http://www.google.com");

		BufferedImage image = new AShot()
				.shootingStrategy(ShootingStrategies.viewportPasting(100))
				.takeScreenshot(driver).getImage();
		saveScreenshot("full", image);
	}

	@Test
	public void testWebElementScreenshot() throws Exception {
		driver.get("http://www.google.com");

		WebElement element = driver.findElement(By.cssSelector("div .tsf-p"));
		BufferedImage image = new AShot()
				.coordsProvider(new WebDriverCoordsProvider())
				.takeScreenshot(driver, element).getImage();

		saveScreenshot("element", image);
	}

	@Test
	public void testSeveralWebElementScreenshot() throws Exception {
		driver.get("http://www.google.com");

		List<WebElement> element = driver.findElements(By.cssSelector(".tsf-p, .gb_P"));
		BufferedImage image = new AShot()
				.coordsProvider(new WebDriverCoordsProvider())
				.takeScreenshot(driver, element).getImage();

		saveScreenshot("elements", image);
	}

	@Test
	public void testWebElementScreenshotCropper() throws Exception {
		driver.get("http://www.google.com");

		WebElement element = driver.findElement(By.cssSelector("div .tsf-p"));
		BufferedImage image = new AShot()
				.imageCropper(new IndentCropper().addIndentFilter(blur()))
				.coordsProvider(new WebDriverCoordsProvider())
				.takeScreenshot(driver, element).getImage();

		saveScreenshot("blur", image);
	}

	@Test
	public void testImageComparison() {
		driver.get("http://www.google.com");
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Cheese!");


		WebElement element = driver.findElement(By.cssSelector("div .tsf-p"));
		BufferedImage actualImage = new AShot()
				.coordsProvider(new WebDriverCoordsProvider())
				.takeScreenshot(driver, element).getImage();

		ImageDiff diff = new ImageDiffer().makeDiff(readImage("element"), actualImage);

		saveScreenshot("diffMarkedImage", diff.getMarkedImage());
		saveScreenshot("DiffImage", diff.getDiffImage());
		Assert.assertFalse(diff.hasDiff());
	}

	private void saveScreenshot(String name, BufferedImage image) {
		File outputfile = new File("screenshots/" + name + ".png");
		outputfile.getParentFile().mkdir();
		try {
			outputfile.createNewFile();
			ImageIO.write(image, "png", outputfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(outputfile.getAbsolutePath());
	}

	private BufferedImage readImage(String name) {
		try {
			BufferedImage read = ImageIO.read(new File("screenshots/" + name+".png"));
			return read;
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("Could not read image");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
}
