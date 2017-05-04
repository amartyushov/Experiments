package io.mart.dbs.DBSetup;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;

/**
 * @author Alexander Martyushov
 */
public class InsertTest {

    @Test
    public void tryInsert() {

        SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
        dataSource.setAutoCommit(true);
        dataSource.setSuppressClose(true);
        dataSource.setDriverClassName("com.ibm.db2.jcc.DB2Driver");
        dataSource.setUrl("${database.url}");
        dataSource.setUsername("${database.user}");
        dataSource.setPassword("${database.password}");

        Operation operation = sequenceOf(
                insertInto("FOB")
                        .columns("FOB_ID", "FOB_NAME", "ENABLED", "LAST_MODIFIED", "CREATED")
                        .values(10, "testFob", "Y", "2009-03-30 02:01:56.20265", "2009-03-30 02:01:56.20265")
                        .build());

        DbSetup dbSetup = new DbSetup(new DataSourceDestination(dataSource), operation);
        dbSetup.launch();
    }
}
