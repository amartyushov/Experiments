package io.mart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver driver;

    @FindBy(id = "com.marketlytics.calabashtest:id/editText1")
    private WebElement textField;

    @FindBy(id = "com.marketlytics.calabashtest:id/button2")
    private WebElement btn_clickMe;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public WebElement textField() {
        return textField;
    }

    public WebElement btn_clickMe() {
        return btn_clickMe;
    }
}
