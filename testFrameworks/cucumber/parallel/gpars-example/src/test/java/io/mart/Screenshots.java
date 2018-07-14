package io.mart;

import cucumber.api.Scenario;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class Screenshots {

	@Attachment(value = "PNG Attachment {0}", type = "image/png")
	public byte[] createAttachment(WebDriver driver) {
		return fullPageScreenshot(driver);
	}

	@Attachment(value = "DiffNumber")
	public int showDiffSize(ImageDiff diff) {
		return diff.getDiffSize();
	}

	@Attachment(value = "Diff", type = "image/png")
	public byte[] showDiff(ImageDiff diffImage) {
		return imageAsBytes(diffImage.getMarkedImage());
	}

	/**
	 * Consumes more memory on hard disk
	 * @param driver
	 * @return
	 */
	@Attachment(value = "Screenshot", type = "image/png")
	public byte[] captureScreenshotAlternative(WebDriver driver) {
		return  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	private byte[] fullPageScreenshot(WebDriver driver) {
		BufferedImage image = new AShot()
				.shootingStrategy(ShootingStrategies.viewportPasting(100))
				.takeScreenshot(driver).getImage();
		return imageAsBytes(image);
	}

	public BufferedImage readImage(String name) {
		try {
			return ImageIO.read(new File("screenshots/" + name+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("Could not read image");
	}

	public BufferedImage makeElementScreenshot(WebDriver driver, WebElement element) {
		return new AShot()
				.coordsProvider(new WebDriverCoordsProvider())
				.takeScreenshot(driver, element).getImage();
	}

	public void saveScreenshot(String name, BufferedImage image) {
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

	private byte[] imageAsBytes(BufferedImage image) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, "png", baos);
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();
			return imageInByte;
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("Cannot convert Buffered image to bytes[]");
	}

	public String prepareScreenshotName(Scenario scenario) {
		return scenario.getName().replace(" ", "_") + "_chrome_1280x1024";
	}

	public Double diffInPercentage(ImageDiff diff) {
		BufferedImage diffImage = diff.getDiffImage();
		System.out.println("height = " + diffImage.getHeight());
		System.out.println("width = " + diffImage.getWidth());
		Double size = Double.valueOf(diffImage.getHeight() * diffImage.getWidth());
		System.out.println("size is " + size);
		System.out.println("diff size is " + diff.getDiffSize());
		Double percentage = Double.valueOf(diff.getDiffSize()) / size;
		return percentage*100;
	}
}
