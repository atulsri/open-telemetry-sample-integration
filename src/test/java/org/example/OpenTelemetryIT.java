package org.example;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.controller.EmployeeController;
import org.example.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OpenTelemetryIT {

    @BeforeAll
    public static void beforeAll() {

    }

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @LocalServerPort
    private Integer port;

    @Test
    public void testOtelTrace() {
        // Specify the base URL for the RESTful web service
        RestAssured.baseURI = "http://localhost:"+port+ "/myapp";
        // Make a GET request to the endpoint
        Response response = RestAssured.get("/employee");

        // Get the JSON response body as a string
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        // Assert status code
        Assertions.assertEquals(200, response.getStatusCode(), "Status code is not 200");
        System.out.println("hello");
    }

}
