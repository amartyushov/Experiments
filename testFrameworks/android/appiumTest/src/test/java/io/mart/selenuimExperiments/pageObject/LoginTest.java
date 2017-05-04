package io.mart.selenuimExperiments.pageObject;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {

    @Test
    public void simpleLoginTest(){
        WebDriver driver = new FirefoxDriver();
        driver.get("http://login.com");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.name().sendKeys("your_name");
        loginPage.password().sendKeys("your_pass");
        loginPage.button().click();
    }

}
