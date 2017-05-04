package io.mart.annotations.autowired.field;

import io.mart.annotations.resource.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author Aleksandr Martiushov
 */
public class AppMain {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        io.mart.annotations.autowired.field.Driver driver = (io.mart.annotations.autowired.field.Driver) context.getBean("driverField");
        System.out.println(driver);
    }
}
