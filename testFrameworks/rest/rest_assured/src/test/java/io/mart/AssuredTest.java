package io.mart;

import io.restassured.response.*;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.get;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author Aleksandr Martiushov
 */
public class AssuredTest {

    @Test
    public void simple(){
        get("/hello")
                .then()
                .body("content", equalTo("Hello, Stranger!"));
    }

    @Test
    public void simpleRoot(){
        get("/")
                .then()
                .body("", equalTo("Hello world"));
    }

    @Test
    public void simpleSchemaValidation(){
        get("/json-validation-simple")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema.json"));
    }

    @Test
    public void schemaValidation(){
        // http://json-schema.org/
        get("/json-validation")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemaComplicated.json"));
    }

    @Test
    public void schemaValidationUnchecked(){
        get("/json-validation")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemaComplicated.json")
                .using(settings.with().checkedValidation(false)));
        // strange, I get NPE
        // java.lang.NullPointerException
        // at io.mart.AssuredTest.schemaValidationUnchecked(AssuredTest.java:44)
    }

    @Test
    public void responseRetrieving(){
        System.out.println(get("/json-validation-simple").asString());
    }

    @Test
    public void extractingParts(){
        ArrayList<String> string = get("/json-validation-simple")
                .then()
                .body("name", equalTo("yourName"))
                .extract()
                .path("tags");
        System.out.println(string);

        Response response = get("/json-validation-simple")
                .then()
                .body("name", equalTo("yourName"))
                .extract()
                .response();

        ArrayList<String> tags = response.path("tags");
        System.out.println(tags);
        System.out.println(response.asString());
    }

}
