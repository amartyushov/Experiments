package io.mart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class MobileWeb {

    @Test
    public void firstTest() throws InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");  // for emulator

        // so you do not install any apk during test, but use already preinstalled Chrome apk.
        // if it is not preinstalled => you get an error
        // > adb install [path to local apk]
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);


        try {
            AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

            androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            androidDriver.get("http://udemy.com/");
            androidDriver.findElement(By.xpath("//input[@type='search']")).sendKeys("SoapUI");
            androidDriver.findElement(By.xpath("//input[@type='search']")).sendKeys(Keys.ENTER);
            System.out.println(androidDriver.getTitle());

            System.out.println(androidDriver.findElement(By.xpath("//*[@id=\"courses\"]/li[1]/a/div[2]/div[1]/div/span")).getText());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
