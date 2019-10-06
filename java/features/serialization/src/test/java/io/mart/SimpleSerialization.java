package io.mart;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
		writeObjectToFile(user, fileName);
		
		// Act
		Object object = readObjectFromFile(fileName);
		User deserializedUser = (User) object;
		
		// Assert
		assertThat(deserializedUser.getAge()).isEqualTo(user.getAge());
		assertThat(deserializedUser.getName()).isEqualTo(user.getName());
		
		assertThat(deserializedUser.getHeight()).isNotEqualTo(user.getHeight());
	}
	
	
	private Object readObjectFromFile(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream
				= new FileInputStream(fileName);
		ObjectInputStream objectInputStream
				= new ObjectInputStream(fileInputStream);
		Object object = objectInputStream.readObject();
		objectInputStream.close();
		return object;
	}
	
	
	private void writeObjectToFile(User user, String fileName) throws IOException {
		FileOutputStream fileOutputStream
				= new FileOutputStream(fileName);
		ObjectOutputStream objectOutputStream
				= new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(user);
		objectOutputStream.flush();
		objectOutputStream.close();
	}
}
