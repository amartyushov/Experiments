package io.mart;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.mart.tree.model.ignoreFields.BasicClass;
import io.mart.tree.model.ignoreFields.BasicClassFieldLevelIgnorance;
import io.mart.tree.model.ignoreFields.BasicClassWithIgnoredFieldsAsList;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IgnoringFields {
	
	@Test
	public void checkSerialization_withoutFieldIgnoring_allFieldsAreReturned()
			throws JsonProcessingException {
		// Arrange
		BasicClass basicClass = new BasicClass();
		basicClass.setId(1);
		basicClass.setName("class name");
		basicClass.setUnnecessaryField("unnecessary field");
		basicClass.setUnnecessaryId(10);
		
		// Act
		ObjectMapper mapper = new ObjectMapper();
		String valueAsString = mapper.writeValueAsString(basicClass);
		System.out.println(valueAsString);
		
		// Assert
		assertThat(valueAsString).contains("unnecessary field");
		assertThat(valueAsString).contains("10");
	}
	
	@Test
	public void checkDeserialization_withoutFieldIgnoring_allFieldsAreReturned()
			throws IOException {
		// Arrange
		BasicClass basicClass = new BasicClass();
		basicClass.setId(1);
		basicClass.setName("class name");
		basicClass.setUnnecessaryField("unnecessary field");
		basicClass.setUnnecessaryId(10);
		
		ObjectMapper mapper = new ObjectMapper();
		String valueAsString = mapper.writeValueAsString(basicClass);
		System.out.println(valueAsString);
		
		// Act
		BasicClass finalValue = mapper.readValue(valueAsString, BasicClass.class);
		System.out.println(finalValue.toString());
		
		// Assert
		assertThat(finalValue.getUnnecessaryField()).isEqualTo("unnecessary field");
		assertThat(finalValue.getUnnecessaryId()).isEqualTo(10);
	}
	
	@Test
	public void checkSerialization_withFieldIgnoringAsAList_theseFieldsWillNotBeShownInString()
			throws JsonProcessingException {
		// Arrange
		BasicClassWithIgnoredFieldsAsList basicClass = new BasicClassWithIgnoredFieldsAsList();
		basicClass.setId(1);
		basicClass.setName("class name");
		basicClass.setUnnecessaryField("unnecessary field");
		basicClass.setUnnecessaryId(10);
		
		// Act
		ObjectMapper mapper = new ObjectMapper();
		String valueAsString = mapper.writeValueAsString(basicClass);
		System.out.println(valueAsString);
		
		// Assert
		assertThat(valueAsString).doesNotContain("unnecessary field");
		assertThat(valueAsString).doesNotContain("10");
	}
	
	@Test
	public void checkDeserialization_withFieldIgnoringAsAList_ignoredFieldsHaveDefaultValues()
			throws IOException {
		// Arrange
		BasicClassWithIgnoredFieldsAsList basicClass = new BasicClassWithIgnoredFieldsAsList();
		basicClass.setId(1);
		basicClass.setName("class name");
		basicClass.setUnnecessaryField("unnecessary field");
		basicClass.setUnnecessaryId(10);
		
		ObjectMapper mapper = new ObjectMapper();
		String valueAsString = mapper.writeValueAsString(basicClass);
		System.out.println(valueAsString);
		
		// Act
		BasicClass finalValue = mapper.readValue(valueAsString, BasicClass.class);
		System.out.println(finalValue.toString());
		
		// Assert
		assertThat(finalValue.getUnnecessaryField()).isNull();
		assertThat(finalValue.getUnnecessaryId()).isEqualTo(0);
	}
	
	
	@Test
	public void checkSerialization_withParticularFieldIgnoring_theseFieldsWillNotBeShownInString()
			throws JsonProcessingException {
		// Arrange
		BasicClassFieldLevelIgnorance basicClass = new BasicClassFieldLevelIgnorance();
		basicClass.setId(1);
		basicClass.setName("class name");
		basicClass.setUnnecessaryField("unnecessary field");
		basicClass.setUnnecessaryId(10);
		
		// Act
		ObjectMapper mapper = new ObjectMapper();
		String valueAsString = mapper.writeValueAsString(basicClass);
		System.out.println(valueAsString);
		
		// Assert
		assertThat(valueAsString).doesNotContain("unnecessary field");
		assertThat(valueAsString).doesNotContain("10");
	}
	
	
	@Test
	public void checkDeserialization_withParticularFieldIgnoring_ignoredFieldsHaveDefaultValues()
			throws IOException {
		// Arrange
		BasicClassFieldLevelIgnorance basicClass = new BasicClassFieldLevelIgnorance();
		basicClass.setId(1);
		basicClass.setName("class name");
		basicClass.setUnnecessaryField("unnecessary field");
		basicClass.setUnnecessaryId(10);
		
		ObjectMapper mapper = new ObjectMapper();
		String valueAsString = mapper.writeValueAsString(basicClass);
		System.out.println(valueAsString);
		
		// Act
		BasicClass finalValue = mapper.readValue(valueAsString, BasicClass.class);
		System.out.println(finalValue.toString());
		
		// Assert
		assertThat(finalValue.getUnnecessaryField()).isNull();
		assertThat(finalValue.getUnnecessaryId()).isEqualTo(0);
	}
}
