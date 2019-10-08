package io.mart;

import java.io.IOException;
import java.io.InvalidClassException;

import io.mart.inheritance.correct.Child;
import io.mart.inheritance.incorrect.ChildClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class SerializationInheritanceForSubclassCorrectCase {
	
	@Test
	public void whenNonSerializableSuperclassHasZeroArgsConstructor_noExceptionIsThrown()
			throws IOException, ClassNotFoundException {
	    // Arrange
		Child child = new Child();
		child.setName("theName");
		child.setValue("theParentValue");
		
		// Act
		String someFile = "someFile.txt";
		SerializationUtils.writeObjectToFile(child, someFile);
		Object object = SerializationUtils.readObjectFromFile(someFile);
		
		Child deserializedChild = (Child) object;
		
		// Assert
		assertThat(child.getName()).isEqualTo(deserializedChild.getName());
		assertThat(deserializedChild.getValue()).isNull();
	}
	
}
