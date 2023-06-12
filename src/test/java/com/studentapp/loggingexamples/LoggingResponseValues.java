package com.studentapp.loggingexamples;

import com.studentapp.tests.TestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LoggingResponseValues extends TestBase {

    @Test
    public void test001() {
        System.out.println("_________________Printing Response Headers________________");
        given().
                param("programme", "Computer Science").
                param("limit", 1).
                when().
                get("/list").
                then().
                log().
                headers().
                statusCode(200);
    }
    @Test
    public void test002() {
        System.out.println("_________________Printing Response Status Line________________");
        given().
                param("programme", "Computer Science").
                param("limit", 1).
                when().
                get("/list").
                then().
                log().
                status().
                statusCode(200);
    }
    @Test
    public void test003() {
        System.out.println("_________________Printing Response Body________________");
        given().
                param("programme", "Computer Science").
                param("limit", 1).
                when().
                get("/list").
                then().
                log().
                body().
                statusCode(200);
    }
    @Test
    public void test004() {
        System.out.println("_________________Printing Response Body if error________________");
        given().
                param("programme", "Computer Science").
                param("limit", -1).
                when().
                get("/list").
                then().
                log().
                ifError().
                statusCode(200);
    }
}

