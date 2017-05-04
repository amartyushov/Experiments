package io.mart.annotations.autowired.constructor;

import io.mart.annotations.resource.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author Aleksandr Martiushov
 */
public class AppMain {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        io.mart.annotations.autowired.constructor.Driver driver =
                (io.mart.annotations.autowired.constructor.Driver) context.getBean("driverConstructor");
        System.out.println(driver);
    }
}
