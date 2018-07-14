package io.mart;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceProviderFramework {
	// Example based on JDBC
}

//Service interface (e.g. Connection)
interface Service {
	// Service specific methods are here
}

// Service provider interface (Driver)
interface Provider {
	Service newService();
}

// Noninstantiable class for service registration and access
class Services {
	private Services(){}; // prevent instantiation

	private static final Map<String, Provider> providers = new ConcurrentHashMap<>();
	public static final String DEFAULT_PROVIDER_NAME = "<def>";


	//Provider registration API
	public static void registerDefaultProvider(Provider p) {
		registerProvider(DEFAULT_PROVIDER_NAME, p);
	}
	private static void registerProvider(String name, Provider p) {
		providers.put(name, p);
	}

	//Service access API
	public static Service newInstance() {
		return newInstance(DEFAULT_PROVIDER_NAME);
	}

	private static Service newInstance(String name) {
		Provider p = providers.get(name);
		if (p == null) {
			throw new IllegalStateException("No provider registered with name: " + name);
		}
		return p.newService();
	}
}