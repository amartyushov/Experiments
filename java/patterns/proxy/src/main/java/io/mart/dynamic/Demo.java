package io.mart.dynamic;

import java.lang.reflect.Proxy;

/**
 * @author Aleksandr Martiushov
 */
public class Demo {

    public static void main(String[] args) {

        CustomerService service = new CustomerServiceImpl();
        AuditLogAdvice handler = new AuditLogAdvice(service);

        ClassLoader cl = Demo.class.getClassLoader();

        CustomerService proxiedService =
                (CustomerService) Proxy.newProxyInstance( // class is created (bytecode is generated),
                        // which implements interfaces specified in array below
                        cl,
                        new Class[]{CustomerService.class},
                        handler);

        proxiedService.saveCustomer();
    }
}
