package io.mart.javaEight;

/**
 * @author Alexander Martyushov
 */
public interface PersonFactory<R extends Person> {
    R create(String name, String family);
}
