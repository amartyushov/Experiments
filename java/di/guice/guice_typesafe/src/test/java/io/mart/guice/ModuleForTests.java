package io.mart.guice;

import com.google.inject.AbstractModule;
import com.typesafe.config.Config;

public class ModuleForTests extends AbstractModule {

    @Override
    protected void configure() {
        bind(Config.class).toInstance(ConfigWrapper.getConfig());
    }
}
