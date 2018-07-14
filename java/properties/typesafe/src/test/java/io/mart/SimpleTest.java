package io.mart;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * The convenience method ConfigFactory.load() loads the following (first-listed are higher priority):

 system properties
 application.conf (all resources on classpath with this name)
 application.json (all resources on classpath with this name)
 application.properties (all resources on classpath with this name)
 reference.conf (all resources on classpath with this name)
 */
@Slf4j
public class SimpleTest {
    Config defaultConfig = null;
    Config fallbackConfig = null;

    @BeforeClass
    public void setup() {
         defaultConfig = ConfigFactory.load(); // by default searches for application.conf

        fallbackConfig = ConfigFactory.parseResources("override.conf")
                .withFallback(defaultConfig)
                .resolve();
    }



    @Test
    public void propertyWithDefault(){
        log.info("port: {}", defaultConfig.getInt("tomcat_port"));
    }
}
