package io.mart;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class QuickParsing {
	
	@Test
	public void whenParsingJsonStringIntoJsonNode_thenCorrect()
			throws IOException {
		String jsonString = "{\"k1\":\"v1\",\"k2\":\"v2\"}";
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = mapper.readTree(jsonString);
		
 		assertNotNull(actualObj);
	}
	
	@Test
	public void givenUsingLowLevelApi_whenParsingJsonStringIntoJsonNode_thenCorrect()
			throws IOException {
		String jsonString = "{\"k1\":\"v1\",\"k2\":\"v2\"}";
		
		ObjectMapper mapper = new ObjectMapper();
		JsonFactory factory = mapper.getFactory();
		JsonParser parser = factory.createParser(jsonString);
		JsonNode actualObj = mapper.readTree(parser);
		
		assertNotNull(actualObj);
	}
	
	@Test
	public void givenTheJsonNode_whenRetrievingDataFromId_thenCorrect()
			throws IOException {
		String jsonString = "{\"k1\":\"v1\",\"k2\":\"v2\"}";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = mapper.readTree(jsonString);
		
		// When
		JsonNode jsonNode1 = actualObj.get("k1");
		assertEquals(jsonNode1.textValue(), "v1");
	}
	
}
