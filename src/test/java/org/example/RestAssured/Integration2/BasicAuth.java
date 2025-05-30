package org.example.RestAssured.Integration2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class BasicAuth {


    @Test
    public void basicAuth(){

        RestAssured.baseURI = "https://httpbin.org";

        Response response = RestAssured.given()
                .auth().preemptive().basic("user", "passwd")
                .when()
                .get("/basic-auth/user/passwd");

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.getBody().asPrettyString());

    }
}
