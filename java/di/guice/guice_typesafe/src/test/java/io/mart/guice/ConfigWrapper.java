package io.mart.guice;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ConfigWrapper {

    private static final Config config = ConfigFactory.load();

    private ConfigWrapper() {
    }

    public static Config getConfig() {
        Config override = ConfigFactory.parseResources("gradle.properties")
                .withFallback(config)
                .resolve();
        return override;
    }
}
