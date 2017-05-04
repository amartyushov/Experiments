package io.mart.dbs.dbUnit;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;

import java.sql.SQLException;

public class OperationInvoker {

    public void doInsertOperation(IDatabaseConnection connection, IDataSet dataSet){
        try {
            DatabaseOperation.INSERT.execute(connection, dataSet);
        } catch (DatabaseUnitException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
