package io.mart.xml.setter.casting;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Aleksandr Martiushov
 */
public class SetterCastingMain {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("setter-config-casting.xml");
        Communication communication1 = context.getBean("communication", Communication.class);
        communication1.communicate();
        System.out.println(communication1.getCommType());

        ICommunication communication2 = context.getBean("communication", ICommunication.class);
        communication2.communicate();
        //System.out.println(communication2.getCommType());
        // you cannot do it because you cast to ICommunication, but ICommunication does not have method getCommType()

    }
}
