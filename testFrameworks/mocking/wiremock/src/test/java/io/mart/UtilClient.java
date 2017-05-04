package io.mart;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.nio.charset.Charset;

public class UtilClient {


    public static void get(String request) throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(request);
        System.out.println("Executing request " + httpGet.getRequestLine());

        HttpResponse response = client.execute(httpGet);
        System.out.println("Status line: " + response.getStatusLine().getStatusCode());
        System.out.println("Body: " + IOUtils.toString(response.getEntity().getContent(), Charset.defaultCharset()));

    }
}
