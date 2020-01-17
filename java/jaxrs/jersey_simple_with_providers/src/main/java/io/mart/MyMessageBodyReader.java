package io.mart;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.mart.dto.Car;

@Provider
public class MyMessageBodyReader implements MessageBodyReader<Car> {
	
	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return type.equals(Car.class);
	}
	
	
	@Override
	public Car readFrom(Class<Car> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		ObjectMapper mapper = new ObjectMapper();
		Car car = mapper.readValue(entityStream, Car.class);
		
		car.setModel(car.getModel() + "_patched_version");
		
		return car;
	}
}
