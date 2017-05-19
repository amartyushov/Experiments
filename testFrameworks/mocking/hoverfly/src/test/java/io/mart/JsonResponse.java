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
public class JsonResponse {

    @ClassRule
    public static HoverflyRule hoverflyRule2 = HoverflyRule.inSimulationMode(dsl(
            service("ergast.com")
                    .get("/api/f1/drivers/max_verstappen.json")
                    .willReturn(success("{\"permanentNumber\": \"999\"}", "application/json"))
    ));

    @Test
    public void testStubFakeVerstappen() {

        given().
                when().
                get("http://ergast.com/api/f1/drivers/max_verstappen.json").
                then().
                assertThat().
                body("permanentNumber",equalTo("999"));
    }
}
