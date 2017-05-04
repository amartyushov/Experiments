package io.mart.annotations.autowired.setter;

import io.mart.annotations.resource.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author Aleksandr Martiushov
 */
public class AppMain {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Driver driver = (Driver) context.getBean("driver");
        System.out.println(driver);
    }
}
