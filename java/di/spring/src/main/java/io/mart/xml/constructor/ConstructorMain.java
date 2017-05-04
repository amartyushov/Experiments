package io.mart.xml.constructor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Aleksandr Martiushov
 */
public class ConstructorMain {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("constructor-config.xml");
        Communication app = (Communication) context.getBean("communication");
        app.communicate();
    }
}
