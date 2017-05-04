package io.mart.iOS;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SafariTest {

    IOSDriver iosDriver;

    @Before
    public void setup() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 5");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 900);
        // after this timeout emulator shuts down

        iosDriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

    }

    @Test
    public void gmailTest(){
        iosDriver.get("http://gmail.com");
        // here is same concept
        // you need useragent for safari to get actual ids for mobile representation
    }
}
