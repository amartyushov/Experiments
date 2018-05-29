package io.mart.advanced.step3;

import io.mart.advanced.step2.elements.Element;
import org.openqa.selenium.WebElement;

public interface Container extends Element {
    void init(WebElement wrappedElement);
}
