package io.mart;

import com.github.racc.tscg.TypesafeConfig;
import com.google.inject.Inject;

public class Executor {

    @Inject
    private Client client;

    @Inject @TypesafeConfig("conf.name")
    private String value;

    //@Inject @TypesafeConfig("server.host")
    private String gradleProp;

    public String getResponse() {
        return client.call();
    }

    public String getValue() {
        return value;
    }

    public String getGradleProp() {
        return gradleProp;
    }
}
