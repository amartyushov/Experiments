package io.mart;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("resources")
public class MyApplication extends ResourceConfig {
	
	public MyApplication() {
		register(org.glassfish.jersey.jackson.JacksonFeature.class);
		packages("io.mart");
	}
}