package io.mart.dbs.dbUnit;

import org.dbunit.DatabaseUnitException;

import java.sql.SQLException;

/**
 * @author Alexander Martyushov
 */
public class DbUnitEvaluation {


    public static void main(String[] args) {

        DatasetProvider datasetProvider = new DatasetProvider();
        ConnectionProvider connectionProvider = new ConnectionProvider();
        OperationInvoker operationInvoker = new OperationInvoker();


        try {
            long start = System.currentTimeMillis();
            operationInvoker.doInsertOperation(
                    connectionProvider.getiDatabaseConnection(),
                    datasetProvider.buildCompositeDataset(datasetProvider.buildFlatXmlDatasets())
            );
            long duration = System.currentTimeMillis() - start;
            System.out.println("execution time = " + duration);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DatabaseUnitException e) {
            e.printStackTrace();
        }

    }
}
