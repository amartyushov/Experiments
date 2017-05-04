package io.mart.xml.setter;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Aleksandr Martiushov
 */
public class SetterMain {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("setter-config.xml");
        Communication app = (Communication) context.getBean("communication");
        app.communicate();
    }
}
