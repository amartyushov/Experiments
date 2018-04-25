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
    public void overriding(){
        log.info("name: {}", defaultConfig.getString("conf.name"));
        log.info("name: {}", fallbackConfig.getString("conf.name"));
        log.info("title: {}", defaultConfig.getString("conf.title"));
        log.info("title: {}", fallbackConfig.getString("conf.title"));
    }

    @Test
    public void placeHolders(){
        log.info("combined: {}", fallbackConfig.getString("conf.combined"));
    }

    @Test
    public void durationResolution(){
        log.info("redis.ttl minutes: {}", fallbackConfig.getDuration("redis.ttl", TimeUnit.MINUTES));
        log.info("redis.ttl seconds: {}", fallbackConfig.getDuration("redis.ttl", TimeUnit.SECONDS));
    }

    @Test
    public void memoryResolution(){
        // Any path in the configuration can be treated as a separate Config object.
        Config uploadService = fallbackConfig.getConfig("uploadService");
        log.info("maxChunkSize bytes: {}", uploadService.getMemorySize("maxChunkSize").toBytes());
        log.info("maxFileSize bytes: {}", uploadService.getMemorySize("maxFileSize").toBytes());
    }

    @Test
    public void handlingLists(){
        List<Integer> whiteList = fallbackConfig.getIntList("conf.nested.whitelistIds");
        log.info("whitelist: {}", whiteList);
        List<String> whiteListStrings = fallbackConfig.getStringList("conf.nested.whitelistIds");
        log.info("whitelist as Strings: {}", whiteListStrings);
    }

    @Test
    public void handlingBooleans(){
        log.info("yes: {}", fallbackConfig.getBoolean("featureFlags.featureA"));
        log.info("true: {}", fallbackConfig.getBoolean("featureFlags.featureB"));
    }

    @Test
    public void propertyWithDefault(){
        log.info("port: {}", fallbackConfig.getInt("tomcat_port"));
    }
}
