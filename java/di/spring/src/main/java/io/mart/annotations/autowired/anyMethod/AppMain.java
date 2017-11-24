package io.mart.annotations.autowired.anyMethod;

import io.mart.annotations.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author Aleksandr Martiushov
 */
public class AppMain {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        io.mart.annotations.autowired.anyMethod.Driver driver = (io.mart.annotations.autowired.anyMethod.Driver) context.getBean("anyMethodDriver");
        System.out.println(driver);
    }
}
