package io.mart.iOS;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class UICatalogTest {

    IOSDriver iosDriver;

    @Before
    public void setup() throws MalformedURLException {

        File src = new File("src");
        File app = new File(src, "UI-Catalog-App.zip");
        //File app = new File(src, "UICatalog.app"); // This way it works as well

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, app.getAbsoluteFile());
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 900);
        // after this timeout emulator shuts down

        iosDriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
    }

    @Test
    public void switchTest(){
        iosDriver.scrollTo("Controls").click();
        System.out.println(iosDriver.findElement(By.className("UIASwitch")).getAttribute("value"));
        iosDriver.findElement(By.className("UIASwitch")).click();
        System.out.println(iosDriver.findElement(By.className("UIASwitch")).getAttribute("value"));
    }

    @Test
    public void pickerTest(){
        iosDriver.scrollTo("Pickers").click();
        System.out.println(iosDriver.findElements(By.className("UIAPickerWheel")).get(0).getAttribute("value"));
        iosDriver.findElements(By.className("UIAPickerWheel")).get(0).sendKeys("Serena Auroux");
        System.out.println(iosDriver.findElements(By.className("UIAPickerWheel")).get(0).getAttribute("value"));

    }

    @Test
    public void alertTest(){
        iosDriver.scrollTo("Alerts").click();
        iosDriver.findElement(By.name("Show Simple")).click(); //Locator Strategy 'name' is not supported for this session
        //iosDriver.findElementByName("Show Simple").click();
        iosDriver.switchTo().alert().accept();
    }
}
