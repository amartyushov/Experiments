package io.mart.xml.autowire.bytype;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Aleksandr Martiushov
 */
public class ByTypeApp {
    public static void main(String args[]){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("autowire-bytype.xml");

        //autowire=byType
        Employee employee = (Employee)context.getBean("employee");
        System.out.println("Employee Details : "+employee);
    }
}
