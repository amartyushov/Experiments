package io.mart.annotations.autowired.anyMethod;

import io.mart.annotations.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Aleksandr Martiushov
 */
@Component("anyMethodDriver")
public class Driver {

    private License license;

    @Autowired
    public void anyMethod(License license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return "Driver [license=" + license + "]";
    }

    public License getLicense() {
        return license;
    }
}