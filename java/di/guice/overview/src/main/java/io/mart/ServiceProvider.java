package io.mart;

import com.google.inject.Provider;
import io.mart.services.Service;
import io.mart.services.ServiceForProvider;

/**
 * @author Aleksandr Martiushov
 */
public class ServiceProvider implements Provider<Service> {
    public Service get() {
        return new ServiceForProvider();
    }
}
