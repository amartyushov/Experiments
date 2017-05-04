package io.mart.stepDefinitions.appiumSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class AppiumStepDefinitions {

    private final static String FIELD_TEXT = "com.marketlytics.calabashtest:id/editText1";
    private final static String BTN_SEE_DETAILS = "com.marketlytics.calabashtest:id/button2";
    private final static String TITLE_CALENDAR = "com.marketlytics.calabashtest:id/textView1";


    AndroidDriver androidDriver;

    @Given("^I enter main page of application$")
    public void i_enter_main_page_of_application() throws Throwable{
        File src = new File("src");
        File app = new File(src, "app-debug.apk");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");  // for emulator
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, app.getAbsoluteFile());

        try {
            androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }



    @Then("^calendar page is opened$")
    public void calendar_page_is_opened() throws Throwable {
        assertTrue(androidDriver.findElementById(TITLE_CALENDAR).getText().contains("User had put in text"));
    }

    @When("^I enter \"([^\"]*)\" to text field")
    public void I_enter_to_text_button(String arg1) throws Throwable {
        androidDriver.findElementById(FIELD_TEXT).sendKeys(arg1);
    }

    @And("^press button \"([^\"]*)\"$")
    public void press_button(String arg1) throws Throwable {
        androidDriver.findElementById(BTN_SEE_DETAILS).click();
    }
}
