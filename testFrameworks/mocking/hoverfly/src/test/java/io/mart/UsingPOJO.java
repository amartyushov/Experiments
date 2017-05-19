package io.mart;

import io.specto.hoverfly.junit.rule.HoverflyRule;
import org.junit.ClassRule;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.specto.hoverfly.junit.core.SimulationSource.dsl;
import static io.specto.hoverfly.junit.dsl.HoverflyDsl.service;
import static io.specto.hoverfly.junit.dsl.HttpBodyConverter.json;
import static io.specto.hoverfly.junit.dsl.ResponseCreators.success;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author Aleksandr Martiushov
 */
public class UsingPOJO {
    private static Car myCar = new Car("Ford", "Focus");

    @ClassRule
    public static HoverflyRule hoverflyRule = HoverflyRule.inSimulationMode(dsl(
            service("www.testwithcarobject.com")
                    .get("/getmycar")
                    .willReturn(success(json(myCar)))
    ));

    @Test
    public void testStubGetCarObject() {

        given().
                when().
                get("http://www.testwithcarobject.com/getmycar").
                then().
                log().
                body().
                and().
                assertThat().
                body("make", equalTo("Ford"));
    }


    public static class Car {
        String make;
        String model;

        public Car(String make, String model) {
            this.make = make;
            this.model = model;
        }

        public String getMake() {
            return make;
        }

        public Car setMake(String make) {
            this.make = make;
            return this;
        }

        public String getModel() {
            return model;
        }

        public Car setModel(String model) {
            this.model = model;
            return this;
        }
    }
}
