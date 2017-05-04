package io.mart;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class AppTest{

    private final static String BTN_CLICK_ME = "com.marketlytics.calabashtest:id/button1";
    private final static String BTN_SEE_DETAILS = "com.marketlytics.calabashtest:id/button2";
    private final static String TEXT_HEADER = "com.marketlytics.calabashtest:id/textView1";
    private final static String TEXT_BODY = "com.marketlytics.calabashtest:id/textView3";
    private final static String FIELD_TEXT = "com.marketlytics.calabashtest:id/editText1";
    private final static String CHECK_BOX = "com.marketlytics.calabashtest:id/checkBox1";
    private final static String RADION_BTNS = "android.widget.RadioButton";

    @Test
    public void firstTest() {

        File src = new File("src");
        File app = new File(src, "app-debug.apk");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");   // for real device
        //desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");  // for emulator
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, app.getAbsoluteFile());

        try {
            AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

            List<WebElement> radioButtons = androidDriver.findElements(By.className(RADION_BTNS));
            for (WebElement radio : radioButtons) {
                radio.click();
                Thread.sleep(1000);
            }

            String text = androidDriver.findElementById(TEXT_HEADER).getText();
            System.out.println(text);
            androidDriver.findElement(By.id(BTN_CLICK_ME)).click();
            text = androidDriver.findElementById(TEXT_HEADER).getText();
            System.out.println(text);

            androidDriver.findElementById(CHECK_BOX).click();
            androidDriver.findElementById(FIELD_TEXT).sendKeys("text message");
            androidDriver.findElementById(BTN_SEE_DETAILS).click();

            MobileElement element = (MobileElement) androidDriver.findElementById("android:id/numberpicker_input");
            element.swipe(SwipeElementDirection.UP, 10000);

            //TouchAction

            // another way to find elements using embedded framework
            //androidDriver.findElementByAndroidUIAutomator("new UiSelector().text(\"See details\")").click();

            // ability to press phone buttons
            androidDriver.sendKeyEvent(AndroidKeyCode.HOME);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
