package io.mart.construction.singletons;


/**
 * BEST WAY TO IMPLEMENT SINGLETONE!!!
 *
 * serializable for free
 * it is singletone anyway, even in case of serializable and reflection attacks
 */
public enum Singleton3 {

    INSTANCE;

    void doSmth(){}

}
