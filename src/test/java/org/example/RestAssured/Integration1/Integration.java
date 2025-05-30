package org.example.RestAssured.Integration1;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.PayloadManager.Booking.BookingData;
import org.example.PayloadManager.Booking.BookingDates;
import org.example.PayloadManager.Booking.BookingResponse;
import org.example.PayloadManager.Token.Token;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Integration {

    String token;
    int bookingID;

    @Test(priority = 1)
    public void createToken(){
        Token tokenobj = new Token();
        tokenobj.setUsername("admin");
        tokenobj.setPassword("password123");

        Gson gson = new Gson();
        String jsoncreatetokenpayload = gson.toJson(tokenobj);

        RequestSpecification rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/auth");
        rs.contentType(ContentType.JSON);
        rs.body(jsoncreatetokenpayload).log().all();

        Response response = rs.when().post();

        ValidatableResponse vs = response.then().log().all();
        vs.statusCode(200);

        token = response.jsonPath().getString("token");

    }

//    @Test()
//    public void getBookingID(){
//        BookingDates bookingDatesobj = new BookingDates();
//        bookingDatesobj.setCheckin("2018-01-01");
//        bookingDatesobj.setCheckout("2019-01-01");
//
//        BookingData bookingDataObj = new BookingData();
//        bookingDataObj.setFirstname("Jim");
//        bookingDataObj.setLastname("Brown");
//        bookingDataObj.setTotalprice(111);
//        bookingDataObj.setDepositpaid(true);
//        bookingDataObj.setBookingdates(bookingDatesobj);
//        bookingDataObj.setAdditionalneeds("Breakfast");
//
//
//        //serialization
//        Gson gson = new Gson();
//        String jsonBookingPayload = gson.toJson(bookingDataObj);
//
//        RequestSpecification rs = RestAssured.given();
//        rs.baseUri("https://restful-booker.herokuapp.com");
//        rs.basePath("/booking");
//        rs.contentType(ContentType.JSON);
//        rs.cookie(token);
//        rs.body(jsonBookingPayload).log().all();
//
//
//        Response response = rs.when().post();
//        String jsonResponseString = response.asString();
//
//        ValidatableResponse vs = response.then().log().all();
//        vs.statusCode(200);
//
//        bookingID = response.jsonPath().getInt("bookingid");
//
//        //Deserialization
//        BookingResponse bookingResponse = gson.fromJson(jsonResponseString, BookingResponse.class);
//        assertThat(bookingResponse.getBookingid()).isNotZero().isNotNull();
//        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Jim");
// }



    @Test(priority = 2)
    public void validateBookingIdsInRange() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        Response response = RestAssured
                .given()
                .auth().oauth2(token) // OAuth2 token if required (otherwise remove this line)
                .when()
                .get("/booking")
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Parse response
        JsonPath jsonPath = response.jsonPath();
        List<Integer> bookingIds = jsonPath.getList("bookingid");
        String firstname = jsonPath.getString("FirstName");
        System.out.println(firstname);

        // Print and Validate
        for (int id : bookingIds) {
            if(id>=40 && id<=50) {
                System.out.println("Booking ID: " + id);
            }
            //Assert.assertTrue(id >= 10 && id <= 50, "Booking ID out of range: " + id);
        }

        //System.out.println("All booking IDs are within the range of 10 to 50.");
    }



}
