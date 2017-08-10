package io.mart;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class ApplicationConfig extends AbstractCassandraConfiguration {
    protected String getKeyspaceName() {
        return "spring-data-cassandra";
    }

    @Override
    protected String getContactPoints() {
        return "localhost";
    }
}
