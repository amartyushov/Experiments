package io.mart.xml.autowire.byname;

/**
 * @author Aleksandr Martiushov
 */
public class Application {

    private ApplicationUser applicationUser1;

    public ApplicationUser getApplicationUser1() {
        return applicationUser1;
    }

    /**
     * As far as you inject ApplicationUser using setter method within autowiring
     * this method name should be exact this (e.g. setApplicationUser1 does not work already)
     * Basically name of bean, which is going to be injected, has to be the same as used in setter
     * field name (applicationUser1) does not impact here
     * @param applicationUser1
     */
    public void setApplicationUser(ApplicationUser applicationUser1) {
        this.applicationUser1 = applicationUser1;
    }

    @Override
    public String toString() {
        return "Application [applicationUser=" + applicationUser1 + "]";
    }
}