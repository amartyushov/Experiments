package io.mart;

import org.infinispan.Cache;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.persistence.jdbc.configuration.JdbcStringBasedStoreConfigurationBuilder;
import org.testcontainers.containers.MySQLContainer;

/**
 * https://infinispan.org/tutorials/
 */
public class DbBackedInfinispanCache {
	
	private static final boolean DROP_ON_EXIT = false;
	private static final boolean CREATE_ON_START = false;
	private static final String TABLE_PREFIX = "ISPN";
	private static final String ID_COLUMN = "ID_COLUMN";
	private static final String DATA_COLUMN = "DATA_COLUMN";
	private static final String TIMESTAMP_COLUMN = "TIMESTAMP_COLUMN";
	
	
	public static void main(String[] args) {
		registerMySqlDriver();
		MySQLContainer mysqlContainer = new MySQLContainer("mysql:5.7");
		mysqlContainer.start();
		
		// @formatter:off
		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
		configurationBuilder
				.persistence()
					.addStore(JdbcStringBasedStoreConfigurationBuilder.class)
				.table()
					.dropOnExit(DROP_ON_EXIT)
					.createOnStart(CREATE_ON_START)
					.tableNamePrefix(TABLE_PREFIX)
					.idColumnName(ID_COLUMN)
					.dataColumnName(DATA_COLUMN)
					.timestampColumnName(TIMESTAMP_COLUMN)
				.connectionPool()
					.connectionUrl(mysqlContainer.getJdbcUrl())
					.driverClass(mysqlContainer.getDriverClassName())
					.username(mysqlContainer.getUsername())
					.password(mysqlContainer.getPassword());
		// @formatter:on
		
		DefaultCacheManager cacheManager = new DefaultCacheManager();
		cacheManager.defineConfiguration("local_db", configurationBuilder.build());
		
		Cache<String, String> cache = cacheManager.getCache("local_db");
//		cache.put("key_db", "value_db");
		// Does not work so far
		System.out.printf("key = %s\n", cache.get("key"));
		
		cacheManager.stop();
		mysqlContainer.stop();
	}
	
	
	private static void registerMySqlDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Could not load db driver: com.mysql.jdbc.Driver", e);
		}
	}
}
