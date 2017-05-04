package io.mart;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.nio.charset.Charset;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class MockByFiles {

    public static void main(String[] args) throws IOException {
        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8089));
        wireMockServer.start();

        UtilClient.get("http://localhost:8089/api/mytest");

        wireMockServer.stop();
    }
}
