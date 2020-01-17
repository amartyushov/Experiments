package io.mart.interceptors;

import java.io.IOException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Provider
public class MyInterceptor implements ReaderInterceptor, WriterInterceptor {
	private static final Logger LOGGER = LogManager.getLogger(MyInterceptor.class.getName());
	
	
	@Override
	public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
		LOGGER.info("Inside of reader interceptor");
		context.getHeaders().keySet().forEach(LOGGER::info);
		return context.proceed();
	}
	
	
	@Override
	public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
		LOGGER.info("Inside of writer interceptor");
		context.proceed();
	}
}
