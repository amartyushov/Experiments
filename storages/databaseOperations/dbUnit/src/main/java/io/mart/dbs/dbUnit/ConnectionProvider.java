package io.mart.dbs.dbUnit;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.IDatabaseConnection;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.sql.SQLException;

/**
 * @author Alexander Martyushov
 */
public class ConnectionProvider {

    private IDatabaseConnection iDatabaseConnection;

    public IDatabaseConnection getiDatabaseConnection() throws DatabaseUnitException, SQLException {
        if (iDatabaseConnection == null) {
            initConnection();
        }
        return iDatabaseConnection;
    }

    private void initConnection() throws SQLException, DatabaseUnitException {
        SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
        dataSource.setAutoCommit(true);
        dataSource.setSuppressClose(true);
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/mydb");

        iDatabaseConnection = new PostgresqlConection(dataSource.getConnection(), null);
    }
}
