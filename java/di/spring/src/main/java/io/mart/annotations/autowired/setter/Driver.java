package io.mart.annotations.autowired.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Aleksandr Martiushov
 */
@Component("driver")
public class Driver {

    private License license;

    @Autowired
    public void setLicense(License license) {
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