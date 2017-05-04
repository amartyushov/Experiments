package io.mart.dbs.dbUnit;


import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.*;
import org.dbunit.dataset.filter.ITableFilter;
import org.dbunit.dataset.stream.StreamingDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.xml.sax.InputSource;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatasetProvider {

    private List<URL> getYourDatasets() {

        List<URL> myDatasets = new ArrayList<URL>();
        ClassLoader classLoader = this.getClass().getClassLoader();

        myDatasets.add(classLoader.getResource("products.xml"));
        myDatasets.add(classLoader.getResource("categories.xml"));
        myDatasets.add(classLoader.getResource("mapping.xml"));

        return myDatasets;
    }


    public List<IDataSet> buildFlatXmlDatasets() {
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        List<URL> myDatasetFiles = getYourDatasets();
        List<IDataSet> result = new ArrayList<IDataSet>();

        for (URL url : myDatasetFiles) {
            try {
                result.add(builder.build(url));
            } catch (DataSetException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public IDataSet buildCompositeDataset(List<IDataSet> dataSets) {

        try {
            CompositeDataSet dataSet = new CompositeDataSet(dataSets.toArray(new IDataSet[dataSets.size()]));
            return dataSet;
        } catch (DataSetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public IDataSet buildReplacementDataSet(){
        ReplacementDataSet replacementDataSet = new ReplacementDataSet(buildCompositeDataset(buildFlatXmlDatasets()));
        replacementDataSet.addReplacementSubstring("test", "TEST111111111");
        return replacementDataSet;
    }

    public IDataSet buildStreamingDataSet(){
        FlatXmlProducer flatXmlProducer = new FlatXmlProducer(new InputSource("${path.to.dataset}"));
        StreamingDataSet streamingDataSet = new StreamingDataSet(flatXmlProducer);
        return streamingDataSet;
        /* I dont see an optimisation in case of usage of Streaming dataset.
        It is 20% slower rather than FlatXmlDataSet and has some issues while building composite dataset */
    }

    public FilteredDataSet buildFilteredDataset() throws DatabaseUnitException, SQLException {

        IDataSet unfilteredDataset = buildCompositeDataset(buildFlatXmlDatasets());
        ConnectionProvider connectionProvider = new ConnectionProvider();
        ITableFilter iTableFilter = new CachingDatabaseSequenceFilter(connectionProvider.getiDatabaseConnection());

        FilteredDataSet filteredDataSet = new FilteredDataSet(iTableFilter, unfilteredDataset);

        try {
            filteredDataSet.getTable("CATEGORY");
        } catch (NoSuchTableException e) {
            e.printStackTrace();
        }
        return filteredDataSet;
    }
}
