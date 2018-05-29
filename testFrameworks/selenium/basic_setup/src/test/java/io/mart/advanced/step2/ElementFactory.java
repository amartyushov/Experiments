package io.mart.advanced.step2;

import io.mart.advanced.step2.elements.Element;
import org.openqa.selenium.WebElement;

public interface ElementFactory {
    <E extends Element> E create(Class<E> elementClass, WebElement wrappedElement);
}
