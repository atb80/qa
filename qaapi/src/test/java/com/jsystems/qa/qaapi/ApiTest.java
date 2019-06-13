package com.jsystems.qa.qaapi;

import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

@DisplayName("Api tests")
public class ApiTest {

    @Test
    public void firstTest() {

                RestAssured
                        .given()
                        .get("http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .body("name", equalTo("Piotr"))
                        .body("surname", equalTo("Kowalski"));
    }

}
