package io.mart.advanced.initial;

import io.mart.advanced.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SimpleSearchPage implements SearchPage {
    private WebDriver driver;

    @Override
    public void search(final String query) {
        driver.findElement(By.id("text")).sendKeys(query);
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
    }

    @Override
    public void init(final WebDriver driver) {
        this.driver = driver;
    }
}
