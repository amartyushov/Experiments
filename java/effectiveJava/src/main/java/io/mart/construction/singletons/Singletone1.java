package io.mart.construction.singletons;


/**
 * There is no performance boost in this case (while direct access to object reference)
 */
public class Singletone1 {

    public final static Singletone1 INSTANCE = new Singletone1();

    /**
     * Even if constructor is private, there is a possibility to invoke is via reflection.
     * Constructor provides defence for it.
     */
    private Singletone1(){

        if (INSTANCE != null){
            throw new IllegalStateException("You should not use reflection and invoke constructor" +
                    "explicitly");
        }
    }

    public void doSmth(){}
}
