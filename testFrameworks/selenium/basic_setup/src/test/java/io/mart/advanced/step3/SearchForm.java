package io.mart.advanced.step3;

import io.mart.advanced.step2.elements.Button;
import io.mart.advanced.step2.elements.TextField;
import org.openqa.selenium.support.FindBy;

public class SearchForm extends AbstractContainer {
    @FindBy(id = "text")
    private TextField searchField;

    @FindBy(css = "button[type=\"submit\"]")
    private Button searchButton;

    public void search(final String query) {
        searchField.clearAndType(query);
        searchButton.click();
    }
}
