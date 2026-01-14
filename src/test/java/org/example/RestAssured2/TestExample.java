package org.example.RestAssured2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.example.PayloadManager.Booking.BookingData;
import org.example.PayloadManager.Booking.BookingDates;
import org.testng.annotations.Test;


public class TestExample {


    @Test
    public void testexample() {

        BookingDates bookingDatesobj = new BookingDates();
        bookingDatesobj.setCheckin("2018-01-01");
        bookingDatesobj.setCheckout("2019-01-01");

        BookingData bookingDataObj = new BookingData();
        bookingDataObj.setFirstname("Jim");
        bookingDataObj.setLastname("Brown");
        bookingDataObj.setTotalprice(111);
        bookingDataObj.setDepositpaid(true);
        bookingDataObj.setBookingdates(bookingDatesobj);
        bookingDataObj.setAdditionalneeds("Breakfast");

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        Response response = RestAssured
                .given()
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .header("content-type", "application/json")
                .auth().oauth("", "", "", "")
                .body(bookingDataObj)
                .with().post()
                .then().log().all()
                .statusCode(200).extract().response();


        JsonPath jsonPath = response.jsonPath();
        String firstName = jsonPath.getString("booking.firstname");
        System.out.println(firstName);
        int bookingID = jsonPath.getInt("bookingid");
        System.out.println(bookingID);


    }
}
