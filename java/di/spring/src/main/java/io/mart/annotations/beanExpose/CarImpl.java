package io.mart.annotations.beanExpose;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksandr Martiushov.
 */
public class CarImpl implements Car {

    private Engine engine;

    CarImpl(Engine engine) {
        this.engine = engine;
    }

    public void embeddingEngine(){
        engine.getEngine();
    }

    @Override
    public String drive() {
        return "I am driving";
    }
}
