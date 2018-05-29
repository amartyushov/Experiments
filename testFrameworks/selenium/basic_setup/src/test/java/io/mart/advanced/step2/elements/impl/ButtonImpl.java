package io.mart.advanced.step2.elements.impl;

import io.mart.advanced.step2.elements.Button;
import org.openqa.selenium.WebElement;

class ButtonImpl extends AbstractElement implements Button {
    protected ButtonImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void click() {
        wrappedElement.click();
    }
}
