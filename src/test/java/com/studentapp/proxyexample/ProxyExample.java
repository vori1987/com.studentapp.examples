package com.studentapp.proxyexample;

import com.studentapp.tests.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ProxyExample extends TestBase {

    @DisplayName("Check time response")
    @Test
    void getTimeResponse() {
        //set "5555" in postman manually, before run this test

        given().
                spec(rp).
                when().
                get("/list").
                then().
                log().
                body();
    }
}