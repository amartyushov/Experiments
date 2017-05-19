package io.mart;

import io.specto.hoverfly.junit.rule.HoverflyRule;
import org.junit.ClassRule;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.specto.hoverfly.junit.core.SimulationSource.dsl;
import static io.specto.hoverfly.junit.dsl.HoverflyDsl.service;
import static io.specto.hoverfly.junit.dsl.ResponseCreators.success;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author Aleksandr Martiushov
 */
public class BasicTest {

    @ClassRule
    public static HoverflyRule hoverflyRule = HoverflyRule.inSimulationMode(dsl(
            service("www.afirststub.com")
                    .get("/test")
                    .willReturn(success("Success","text/plain"))
    ));


    @Test
    public void testAFirstStub() {
        given().
                when().
                get("http://www.afirststub.com/test").
                then().
                assertThat().
                statusCode(200).
                and().
                body(equalTo("Success"));
    }


}
