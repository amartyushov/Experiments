package io.mart;

import javax.inject.Named;

import com.google.inject.Inject;
import io.mart.services.Service;

/**
 * @author Aleksandr Martiushov
 */
public class MyApplication {

    private Service service;

    // constructor based injection
    @Inject
    public MyApplication(@Named("post") Service service) {
        this.service=service;
    }

    // setter based injection
//    @Inject
//    public void setService(Service service){
//        this.service = service;
//    }

/*
    @Inject
    public void setService(@Named("post") Service service){
        this.service = service;
    }
*/

    public boolean sendMessage(){
        return service.sendMessage();
    }
}
