package io.mart;

import java.io.IOException;
import java.io.InvalidClassException;

import io.mart.composition.RootClass;
import io.mart.serial.version.ClassWithVersion;
import io.mart.serial.version.ClassWithoutVersion;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Execute test methods due to instructions
 */
public class SerialVersionUIDTest {
	private static final String FILE_WITH_CLASS_WITH_VERSION = "withVersion.txt";
	private static final String FILE_WITH_CLASS_WITHOUT_VERSION = "withoutVersion.txt";
	private static final String VALUE = "theValue";
	
	
	@Test
	public void serializeObjects() throws IOException {
		// Arrange
		ClassWithVersion classWithVersion = new ClassWithVersion();
		classWithVersion.setValue(VALUE);
		
		ClassWithoutVersion classWithoutVersion = new ClassWithoutVersion();
		classWithoutVersion.setValue(VALUE);
		
		// Act
		SerializationUtils.writeObjectToFile(classWithVersion, FILE_WITH_CLASS_WITH_VERSION);
		SerializationUtils.writeObjectToFile(classWithoutVersion, FILE_WITH_CLASS_WITHOUT_VERSION);
	}
	
	
	/**
	 * Before executing the test, change modifier for {@link ClassWithVersion#value} and {@link ClassWithoutVersion#value}
	 */
	@Test
	public void deserializeObjectWithSerialVersionUID() throws IOException, ClassNotFoundException {
		// Checking class with serialVersionUID
		Object object = SerializationUtils.readObjectFromFile(FILE_WITH_CLASS_WITH_VERSION);
		ClassWithVersion deserializedObject = (ClassWithVersion) object;
		assertThat(VALUE).isEqualTo(deserializedObject.getValue());
		
		// Checking class without serialVersionUID
		assertThatThrownBy(() -> SerializationUtils.readObjectFromFile(FILE_WITH_CLASS_WITHOUT_VERSION))
				.isInstanceOf(InvalidClassException.class);
	}
}
