package io.mart.annotations.beanExpose;

/**
 * Created by Aleksandr Martiushov.
 */
public class EngineImpl implements Engine {
    @Override
    public void getEngine() {
        System.out.println("Preparing engine for the car");
    }
}
