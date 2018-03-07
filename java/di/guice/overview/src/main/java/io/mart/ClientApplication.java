package io.mart;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Aleksandr Martiushov
 */
public class ClientApplication {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AppInjector());

        MyApplication application = injector.getInstance(MyApplication.class);
        application.sendMessage();
    }
}
