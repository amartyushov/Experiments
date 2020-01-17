package io.mart.extensions;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Provider
public class MyFilter implements ContainerRequestFilter, ContainerResponseFilter {
	
	private static final Logger LOGGER = LogManager.getLogger(MyFilter.class.getName());
	
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		LOGGER.info("Inside of request filter");
	}
	
	
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		LOGGER.info("Inside of response filter");
	}
}
