package io.mart;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib is an open source library that capable creating and loading class files in memory during Java run time.
 * To do that it uses Java byte-code generation library ‘asm’, which is a very low level byte code creation tool
 *
 * @author Aleksandr Martiushov
 */
public class CglibDemo {

    static class Original {
        public void originalMethod(String s) {
            System.out.println(s);
        }
    }

    static class Handler implements MethodInterceptor {
        private final Original original;

        public Handler(Original original) {
            this.original = original;
        }

        public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            System.out.println("BEFORE");
            method.invoke(original, args);
            System.out.println("AFTER");
            return null;
        }
    }

    public static void main(String[] args) {
        Original original = new Original();
        MethodInterceptor handler = new Handler(original);
        Original f = (Original) Enhancer.create(Original.class, handler);
        f.originalMethod("Hallo");
    }
}
