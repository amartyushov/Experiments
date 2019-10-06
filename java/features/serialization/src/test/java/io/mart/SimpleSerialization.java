package io.mart;

import java.io.IOException;

import io.mart.family.Son;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleSerialization {
	
	@Test
	public void whenSerializedAndDeserialized_objectIsTheSame() throws IOException, ClassNotFoundException {
	    // Arrange
		User user = new User();
		user.setAge(20);
		user.setName("theName");
		user.setHeight(180);
		
		String fileName = "theFile.txt";
		SerializationUtils.writeObjectToFile(user, fileName);
		
		// Act
		Object object = SerializationUtils.readObjectFromFile(fileName);
		User deserializedUser = (User) object;
		
		// Assert
		assertThat(deserializedUser.getAge()).isEqualTo(user.getAge());
		assertThat(deserializedUser.getName()).isEqualTo(user.getName());
		
		assertThat(deserializedUser.getHeight()).isNotEqualTo(user.getHeight());
	}
	
	
	@Test
	public void childOfSerializableObject_canBeSerializedAndDeserialized() throws IOException, ClassNotFoundException {
		// Arrange
		Son son = new Son();
		son.setName("theName");
		son.setAge(20);
		
		String fileName = "theFile.txt";
		SerializationUtils.writeObjectToFile(son, fileName);
		
		// Act
		Object object = SerializationUtils.readObjectFromFile(fileName);
		Son deserializedSon = (Son) object;
		
		// Assert
		assertThat(deserializedSon.getAge()).isEqualTo(son.getAge());
		assertThat(deserializedSon.getName()).isEqualTo(son.getName());
	}
}
