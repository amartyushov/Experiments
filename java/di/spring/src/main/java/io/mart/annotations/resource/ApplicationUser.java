package io.mart.annotations.resource;

import org.springframework.stereotype.Component;

/**
 * @author Aleksandr Martiushov
 */
@Component("applicationUser")
public class ApplicationUser {

    private String name = "defaultName";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ApplicationUser [name=" + name + "]";
    }
}