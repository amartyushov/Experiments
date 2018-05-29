package io.mart.advanced.step2.elements.impl;

import io.mart.advanced.step2.elements.Element;
import org.openqa.selenium.WebElement;

abstract class AbstractElement implements Element {
    protected final WebElement wrappedElement;

    protected AbstractElement(final WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    @Override
    public boolean isDisplayed() {
        return wrappedElement.isDisplayed();
    }
}
