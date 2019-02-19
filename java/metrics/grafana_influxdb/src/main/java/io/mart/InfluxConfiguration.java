package io.mart;

import java.time.Duration;

import io.micrometer.influx.InfluxConfig;

public class InfluxConfiguration implements InfluxConfig {
	
	@Override
	public String get(String key) {
		return null;
	}
	
	
	@Override
	public String db() {
		return "my-db";
	}
	
	
	@Override
	public String uri() {
		return "http://localhost:8086";
	}
	
	
	@Override
	public boolean autoCreateDb() {
		return true;
	}
	
	
	@Override
	public Duration step() {
		return Duration.ofSeconds(5);
	}
}
