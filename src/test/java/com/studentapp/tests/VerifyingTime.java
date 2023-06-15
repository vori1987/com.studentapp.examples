package com.studentapp.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class VerifyingTime extends TestBase {

    @DisplayName("Check time response")
    @Test
    void getTimeResponse() {
        long responseTime = given().
                pathParam("id", 2).
                when().
                get("/{id}").
                timeIn(TimeUnit.SECONDS);
        System.out.println("Response time is: " + responseTime + "seconds");
    }

    @DisplayName("Assert time response")
    @Test
    void checkTimeResponse() {
        given().
                pathParam("id", 2).
                when().
                get("/{id}").
                then().
                time(lessThan(5L), TimeUnit.SECONDS);
    }
}
