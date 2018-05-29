package io.mart.advanced.step3;

import io.mart.advanced.SearchPage;
import io.mart.advanced.step2.ExtendedFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageWithSearchForm implements SearchPage {
    @FindBy(tagName = "form")
    private SearchForm searchForm;

    @Override
    public void search(final String query) {
        searchForm.search(query);
    }

    @Override
    public void init(final WebDriver driver) {
        PageFactory.initElements(new ExtendedFieldDecorator(driver), this);
    }
}
