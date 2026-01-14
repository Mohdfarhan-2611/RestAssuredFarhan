package org.example.RestAssured.Integration1;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Integration2 {

    @Description("Verify basic authetication")
    @Test
    public void verifyBasicAuth(){
        RequestSpecification rs = RestAssured.given();
        rs.baseUri("");
        rs.basePath("");
        rs.header("content-type", "application-json");
        rs.body("");
        rs.auth().basic("username", "password");
        rs.auth().oauth("consumerKey", "consumerSecret", "tokenAccess", "tokenSecret");
        rs.auth().oauth2("");







    }
}
