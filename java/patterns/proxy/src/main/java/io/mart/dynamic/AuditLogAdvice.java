package io.mart.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Aleksandr Martiushov
 */
public class AuditLogAdvice implements InvocationHandler {

    private Object target;

    public AuditLogAdvice(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Creating audit log");
        Object result = method.invoke(target, args);
        return result;
    }
}
