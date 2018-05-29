package io.mart.advanced;

import io.mart.advanced.initial.SimpleSearchPage;
import io.mart.advanced.step1.AnnotatedSearchPage;
import io.mart.advanced.step2.ExtendedSearchPage;
import io.mart.advanced.step3.SearchPageWithSearchForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest {
    @Test(dataProvider = "pageObjects")
    public void testSearch(final SearchPage searchPage) {
        searchPage.init(driver);
        driver.get("http://ya.ru");
        searchPage.search("Bolek i Lolek");
    }

    @DataProvider
    private Object[][] pageObjects() {
        return new Object[][]{
                {new SimpleSearchPage()},
                {new AnnotatedSearchPage()},
                {new ExtendedSearchPage()},
                {new SearchPageWithSearchForm()}
        };
    }

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
