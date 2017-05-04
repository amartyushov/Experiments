package io.mart.annotations.autowired.field;

import io.mart.annotations.autowired.setter.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Aleksandr Martiushov
 */
@Component("driverField")
public class Driver {

    @Autowired
    private License license;

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return "Driver [license=" + license + "]";
    }
}