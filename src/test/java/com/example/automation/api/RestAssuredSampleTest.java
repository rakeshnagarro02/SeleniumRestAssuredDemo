package com.example.automation.api;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class RestAssuredSampleTest {
    @Test
    void getTodoById() {
        Response response = given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .get("/todos/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .extract()
                .response();

        System.out.println("API response: " + response.asString());
    }
}
