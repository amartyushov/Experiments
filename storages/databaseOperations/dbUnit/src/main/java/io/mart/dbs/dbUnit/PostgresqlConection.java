package io.mart.dbs.dbUnit;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.ext.postgresql.PostgresqlDataTypeFactory;

import java.sql.Connection;

/**
 * @author Alexander Martyushov
 */
public class PostgresqlConection extends DatabaseConnection {

    public PostgresqlConection(Connection connection, String schema) throws DatabaseUnitException {
        super(connection, schema);
        getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new PostgresqlDataTypeFactory());
    }
}
