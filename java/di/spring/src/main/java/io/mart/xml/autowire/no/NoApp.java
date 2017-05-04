package io.mart.xml.autowire.no;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Aleksandr Martiushov
 */
public class NoApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("autowire-no.xml");

        //autowire=default
        Driver driver = (Driver)context.getBean("driver");
        System.out.println("Driver Details : "+driver);

    }
}
