package io.mart;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Aleksandr Martiushov
 */
public class StandartProxy {

    interface DemoInterface {
        void originalMethod(String s);
        void secondMethod(String s);
    }

    static class Original implements DemoInterface {
        @Override
        public void originalMethod(String s) {
            System.out.println(s);
        }
        @Override
        public void secondMethod(String s) {
            System.out.println("SECOND METHOD" + s);
        }
    }

    static class Handler implements InvocationHandler {
        private final DemoInterface demoInterface;

        Handler(DemoInterface demoInterface) {
            this.demoInterface = demoInterface;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("BEFORE");
            method.invoke(demoInterface, args);
            System.out.println("AFTER");
            return null;
        }
    }

    public static void main(String[] args) {
        DemoInterface original = new Original();
        Handler handler = new Handler(original);

        original.originalMethod("REAL INVOCATION WITHOUT PROXY");

        DemoInterface proxyInstance = (DemoInterface) Proxy.newProxyInstance(
                DemoInterface.class.getClassLoader(),
                new Class[]{DemoInterface.class},
                handler);
        proxyInstance.originalMethod("PROXIED INVOCATION");
        proxyInstance.secondMethod("SECOND PROXIED INVOCATION");
        // it means that each invocation of method from Interface will be handled by proxy
    }
}
