package io.mart;

import com.google.common.collect.ImmutableMap;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.assertj.core.api.BDDAssertions.then;


/**
 * @author Aleksandr Martiushov
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private String url(String path){
        return "http://localhost:" + this.port + "/"+path;
    }

    @Ignore
    @Test
    public void saveCustomer() throws Exception {
         Map<String,String> params = new HashMap<String,String>(){{
             put("firstName", "Pavel");
             put("lastName", "First");
         }};


        ResponseEntity<Void> result = this.testRestTemplate.getForEntity(
                url("save"),
                Void.class,
                params);

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        //java.lang.NoClassDefFoundError: io/netty/handler/codec/http/FullHttpRequest
    }
}
