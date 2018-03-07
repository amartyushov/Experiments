package io.mart;

import com.github.racc.tscg.TypesafeConfig;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class PojoExample {

    @TypesafeConfig("conf.name") @Inject
    private String value;

    public String getValue() {
        return value;
    }
}
