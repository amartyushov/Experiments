package io.mart;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.ios.IOSDriver;

public class SauseLabExample {
    public static void main(String[] args) throws MalformedURLException {

        // for sauselabs API of DesiredCapabilities is a little bit different
        DesiredCapabilities capabilities = DesiredCapabilities.iphone();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "7.1");
        capabilities.setCapability("appiumVersion", "1.3.4");
        capabilities.setCapability("deviceName", "iphone Simulator");
        capabilities.setCapability("browserName", "safari");

        IOSDriver driver = new IOSDriver(new URL("http://user:pass@saucelab_host:4723/wd/hub"), capabilities);
        driver.get("http://google.com");

        // it is possible to upload your app to saucelab and test is there, within capability "app"

    }

}
