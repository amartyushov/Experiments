package io.mart;

import java.io.IOException;
import java.io.InvalidClassException;

import io.mart.inheritance.incorrect.ChildClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class SerializationInheritanceForSubclassIncorrectCase {
	
	@Test
	public void whenNonSerializableSuperclassHasNoZeroArgsConstructor_exceptionIsThrown()
			throws IOException {
	    // Arrange
		ChildClass childClass = new ChildClass("valueForParentClass");
		childClass.setName("childClassName");
		
		// Act
		String anyFile = "anyFile.txt";
		SerializationUtils.writeObjectToFile(childClass, anyFile);
		Throwable thrown = catchThrowable(() -> SerializationUtils.readObjectFromFile(anyFile));
		
		// Assert
		assertThat(thrown).isInstanceOf(InvalidClassException.class)
				.hasStackTraceContaining("no valid constructor");
	}
	
}
