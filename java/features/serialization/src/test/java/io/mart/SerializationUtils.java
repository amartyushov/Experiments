package io.mart;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationUtils {
	
	static Object readObjectFromFile(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream
				= new FileInputStream(fileName);
		ObjectInputStream objectInputStream
				= new ObjectInputStream(fileInputStream);
		Object object = objectInputStream.readObject();
		objectInputStream.close();
		return object;
	}
	
	
	static void writeObjectToFile(Object object, String fileName) throws IOException {
		FileOutputStream fileOutputStream
				= new FileOutputStream(fileName);
		ObjectOutputStream objectOutputStream
				= new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(object);
		objectOutputStream.flush();
		objectOutputStream.close();
	}
}
