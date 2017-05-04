package io.mart;


import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.execchain.MinimalClientExec;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;

import static com.github.tomakehurst.wiremock.client.WireMock.*;


public class EmbeddedMock {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089); // No-args constructor defaults to port 8080

    @Test
    public void exampleTest() throws IOException {
        stubFor(get(urlEqualTo("/my/resource"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("<response>Some content</response>")));

        HttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8089/my/resource");
        System.out.println("Executing request " + httpGet.getRequestLine());

        HttpResponse response = client.execute(httpGet);
        System.out.println("Status line: " + response.getStatusLine().getStatusCode());
        System.out.println("Body: " + IOUtils.toString(response.getEntity().getContent(), Charset.defaultCharset()));

        verify(getRequestedFor(urlMatching("/my/resource")));

    }

}
