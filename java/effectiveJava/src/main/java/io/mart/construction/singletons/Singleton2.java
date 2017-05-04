package io.mart.construction.singletons;

/**
 * Pros:
 *      you may put some additional code in factory method, like returning
 *      different instances for each thread
 */
public class Singleton2 {

    private final static Singleton2 INSTANCE = new Singleton2();

    private Singleton2(){}

    public static Singleton2 instance(){
        return INSTANCE;
    }

}
