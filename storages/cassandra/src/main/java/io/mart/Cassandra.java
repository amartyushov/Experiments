package io.mart;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;

public class Cassandra {

    private MappingManager manager;

    public MappingManager getManager(){
        if (manager == null) {
            manager = init();
        }
        return manager;
    }

    private MappingManager init() {
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        Session session = cluster.connect("test_keyspace");
        return new MappingManager(session);
    }

    public <T> Mapper<T> getMapper(Class<T> clazz){
        return getManager().mapper(clazz);
    }
}
