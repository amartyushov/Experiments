package io.mart;

import java.io.IOException;
import java.io.NotSerializableException;

import io.mart.composition.Car;
import io.mart.composition.Forest;
import io.mart.composition.House;
import io.mart.composition.RootClass;
import io.mart.composition.Subclass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class SerializationComposition {
	
	@Test
	public void whenAllComposedFieldsImplSerializable_noException() throws IOException, ClassNotFoundException {
	    // Arrange
	    RootClass rootClass = prepareRootClass();
	    
	    // Act
		String fileName = "anyName.txt";
		SerializationUtils.writeObjectToFile(rootClass, fileName);
		Object object = SerializationUtils.readObjectFromFile(fileName);
		
		RootClass deserializedRootClass = (RootClass) object;
		
		// Assert
		assertThat(rootClass.getCar().getModel()).isEqualTo(deserializedRootClass.getCar().getModel());
		assertThat(rootClass.getHouse().getSquare()).isEqualTo(deserializedRootClass.getHouse().getSquare());
	}
	
	@Test
	public void whenNotAllComposedFieldsImplSerializable_exceptionIsThrown() throws IOException {
	    // Arrange
		Subclass subclass = prepareSubclass();
	    
	    // Act
		String fileName = "anyName.txt";
		Throwable thrown = catchThrowable(() -> SerializationUtils.writeObjectToFile(subclass, fileName));

		// Assert
		assertThat(thrown).isInstanceOf(NotSerializableException.class);
	}
	
	@Test
	public void whenNonSerializableField_isNotSet_noException() throws IOException, ClassNotFoundException {
	    // Arrange
		Subclass subclass = prepareSubclassWithoutNonSerializableField();
	    
	    // Act
		String fileName = "anyName.txt";
		SerializationUtils.writeObjectToFile(subclass, fileName);
		Object object = SerializationUtils.readObjectFromFile(fileName);
		
		Subclass deserializedSubClass = (Subclass) object;
		
		// Assert
		assertThat(subclass.getCar().getModel()).isEqualTo(deserializedSubClass.getCar().getModel());
		assertThat(subclass.getHouse().getSquare()).isEqualTo(deserializedSubClass.getHouse().getSquare());
	}
	
	
	private Subclass prepareSubclassWithoutNonSerializableField() {
		Subclass subclass = new Subclass();
		Car car = new Car();
		car.setModel("theModel");
		House house = new House();
		house.setSquare(100);
		subclass.setCar(car);
		subclass.setHouse(house);
		return subclass;
	}
	
	
	private Subclass prepareSubclass() {
		Subclass sub = prepareSubclassWithoutNonSerializableField();
		Forest forest = new Forest();
		forest.setColor("theColor");
		sub.setForest(forest);
		return sub;
	}
	
	
	private RootClass prepareRootClass() {
		RootClass rootClass = new RootClass();
		Car car = new Car();
		car.setModel("theModel");
		House house = new House();
		house.setSquare(100);
		rootClass.setCar(car);
		rootClass.setHouse(house);
		return rootClass;
	}
	
}
