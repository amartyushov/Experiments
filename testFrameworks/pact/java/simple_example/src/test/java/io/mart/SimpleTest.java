package io.mart;

import java.util.HashMap;
import java.util.Map;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import org.junit.Rule;
import org.junit.Test;

public class SimpleTest {
	
	@Rule
	public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("test_provider", "localhost", 3333, this);
	
	@Pact(consumer = "test_consumer")
	public RequestResponsePact createPact(PactDslWithProvider builder) {
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		
		return builder
			   .given("test GET")
				.uponReceiving("GET REQUEST")
				.path("/pact")
				.method("GET")
			   .willRespondWith()
				.status(200)
				.headers(headers)
				.body("{\"condition\": true, \"name\": \"tom\"}")
				.toPact();
		
	}
	
	@Test
	@PactVerification()
	public void givenGet_whenSendRequest_shouldReturn200WithProperHeaderAndBody() {
		
		// when
		ResponseEntity<String> response = new RestTemplate()
				.getForEntity(mockProvider.getUrl() + "/pact", String.class);
		
		// then
		assertThat(response.getStatusCode().value()).isEqualTo(200);
		assertThat(response.getHeaders().get("Content-Type").contains("application/json")).isTrue();
		assertThat(response.getBody()).contains("condition", "true", "name", "tom");
	}
	
}
