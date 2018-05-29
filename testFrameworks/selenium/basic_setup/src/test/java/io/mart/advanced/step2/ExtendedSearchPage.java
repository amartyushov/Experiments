package io.mart.advanced.step2;

import io.mart.advanced.SearchPage;
import io.mart.advanced.step2.elements.Button;
import io.mart.advanced.step2.elements.TextField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExtendedSearchPage implements SearchPage {
    @FindBy(id = "text")
    private TextField searchField;

    @FindBy(css = "button[type=\"submit\"]")
    private Button searchButton;

    @Override
    public void search(final String query) {
        searchField.clearAndType(query);
        searchButton.click();
    }

    @Override
    public void init(final WebDriver driver) {
        PageFactory.initElements(new ExtendedFieldDecorator(driver), this);
    }
}
