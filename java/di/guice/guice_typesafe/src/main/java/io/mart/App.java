package io.mart;

import com.github.racc.tscg.TypesafeConfig;
import com.github.racc.tscg.TypesafeConfigModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    // https://github.com/racc/typesafeconfig-guice

    public static void main(String[] args) {
        Config config = ConfigFactory.load();

        Injector injector = Guice.createInjector(TypesafeConfigModule.fromConfigWithPackage(config, "io.mart"),
                new MyModule());

        PojoExample instance = injector.getInstance(PojoExample.class);
        log.info(instance.getValue());
    }
}
