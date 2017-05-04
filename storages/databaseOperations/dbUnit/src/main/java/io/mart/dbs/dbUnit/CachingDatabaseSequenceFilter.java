package io.mart.dbs.dbUnit;

import org.apache.commons.io.IOUtils;
import org.dbunit.database.AmbiguousTableNameException;
import org.dbunit.database.DatabaseSequenceFilter;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITableIterator;
import org.dbunit.dataset.filter.ITableFilter;
import org.dbunit.dataset.filter.SequenceTableFilter;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.SQLException;

public class CachingDatabaseSequenceFilter implements ITableFilter {

    private SequenceTableFilter delegate;

    public CachingDatabaseSequenceFilter(IDatabaseConnection connection) {
        try {
            InputStream cachedTablesInputStream = this.getClass().getClassLoader().getResourceAsStream("cached-tables.txt");
            String[] sortedTableNames = null;

            if (cachedTablesInputStream != null) {
                sortedTableNames = loadSortedTableNamesFromResource(cachedTablesInputStream);
            }
            if (sortedTableNames == null) {
                sortedTableNames = loadSortedTableNamesFromDatabase(connection);
            }
            delegate = new SequenceTableFilter(sortedTableNames);
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (AmbiguousTableNameException exc) {
            exc.printStackTrace();
        } catch (DataSetException exc) {
            exc.printStackTrace();
        }
    }

    public static String[] loadSortedTableNamesFromDatabase(IDatabaseConnection connection) throws DataSetException, SQLException {
        String[] sortedTableNames;
        long startTime = System.currentTimeMillis();
        String[] unsortedTableNames = connection.createDataSet().getTableNames();
        try {
            Method sortTableNamesMethod = DatabaseSequenceFilter.class.getDeclaredMethod("sortTableNames", IDatabaseConnection.class, String[].class);
            sortTableNamesMethod.setAccessible(true);
            sortedTableNames = (String[]) sortTableNamesMethod.invoke(null, connection, unsortedTableNames);
            System.out.println(String.format("Sorting completed in %d ms.", System.currentTimeMillis() - startTime));
        } catch (Exception e) {
            throw new RuntimeException("Unable to sort table names.", e);
        }
        return sortedTableNames;
    }

    private String[] loadSortedTableNamesFromResource(InputStream inputStream) {
        String[] sortedTableNames = null;
        try {
            sortedTableNames = IOUtils.toString(inputStream, "UTF-8").split(";");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return sortedTableNames;
    }

    public String[] getTableNames(IDataSet dataSet) throws DataSetException {
        return delegate.getTableNames(dataSet);
    }

    public ITableIterator iterator(IDataSet dataSet, boolean reversed) throws DataSetException {
        return delegate.iterator(dataSet, reversed);
    }

    public boolean accept(String tableName) throws DataSetException {
        return delegate.accept(tableName);
    }
}