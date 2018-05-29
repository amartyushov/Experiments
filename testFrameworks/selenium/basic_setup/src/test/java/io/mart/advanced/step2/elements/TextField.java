package io.mart.advanced.step2.elements;

public interface TextField extends Element {
    void type(String text);

    void clear();

    void clearAndType(String text);
}
