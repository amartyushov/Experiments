package io.mart.xml.autowire.constructor;

/**
 * @author Aleksandr Martiushov
 */
public class Instrument {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Instrument [name=" + name + "]";
    }
}
