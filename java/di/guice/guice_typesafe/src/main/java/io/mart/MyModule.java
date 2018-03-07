package io.mart;

import com.google.inject.AbstractModule;

public class MyModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(PojoExample.class).asEagerSingleton();
    }
}
