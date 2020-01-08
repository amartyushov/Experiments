package io.mart;

import java.io.IOException;

import io.mart.custom.Address;
import io.mart.custom.ClassWithCustomSerialization;
import io.mart.custom.Person;
import org.junit.Test;

public class CustomSerializationTest {
	
	
	private static final String FILE_NAME = "customSerialization.txt";
	
	
	@Test
	public void whenCustomSerializingAndDeserializing_ThenObjectIsTheSame() throws IOException, ClassNotFoundException {
	    // Arrange
		Address address = new Address();
		address.setStreet("theStreet");
		address.setHouseNumber(10);
		
		Person person = new Person();
		person.setName("theName");
		
		ClassWithCustomSerialization theObject = new ClassWithCustomSerialization();
		theObject.setPerson(person);
		theObject.setAddress(address);
		
		// Act
		SerializationUtils.writeObjectToFile(theObject, FILE_NAME);
		Object object = SerializationUtils.readObjectFromFile(FILE_NAME);
		
		ClassWithCustomSerialization deserializedObject = (ClassWithCustomSerialization) object;
		
		// Assert
		
	}
	
}
