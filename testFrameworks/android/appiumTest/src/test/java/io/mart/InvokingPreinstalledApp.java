package io.mart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class InvokingPreinstalledApp {

    @Test
    public void firstTest() {


        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");   // for real device

        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);

        // APP_PACKAGE + APP_ACTIVITY, provides you an ability to directly open some screen of app
        // it means that if you have vk app installed, you will open news page of this app on real device
        desiredCapabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.vkontakte.android");
        desiredCapabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.vkontakte.android.MainActivity");


        try {
            AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }
}
