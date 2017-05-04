package io.mart.selenuimExperiments.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;
    private By name = By.name("some_name");
    private By password = By.id("some_id");
    private By button = By.className("some_class_name");

    LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement name(){
        return driver.findElement(name);
    }

    public WebElement password(){
        return driver.findElement(password);
    }

    public WebElement button(){
        return driver.findElement(button);
    }


}
