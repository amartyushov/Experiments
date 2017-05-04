package io.mart.xstream.tweakingOutput;

import com.thoughtworks.xstream.converters.SingleValueConverter;

public class AuthorConverter implements SingleValueConverter {
    public String toString(Object o) {
        return ((Author) o).getName();
    }

    public Object fromString(String s) {
        return new Author(s);
    }

    public boolean canConvert(Class aClass) {
        return aClass.equals(Author.class);
    }
}
