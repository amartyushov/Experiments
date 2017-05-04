package io.mart.selenuimExperiments.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(xpath = "some_xpath")
    private WebElement name;

    @FindBy(className = "some_class_name")
    private WebElement password;

    @FindBy(name = "some_name")
    private WebElement button;

    LoginPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement name() {
        return name;
    }

    public WebElement password() {
        return password;
    }

    public WebElement button() {
        return button;
    }


}
