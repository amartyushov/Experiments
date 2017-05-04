package io.mart.javaEight;

/**
 * @author Alexander Martyushov
 */
@FunctionalInterface
public interface Converter<From, To> {
    To convert(From from);
}
