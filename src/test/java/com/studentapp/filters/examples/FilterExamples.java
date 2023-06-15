package com.studentapp.filters.examples;

import com.studentapp.tests.TestBase;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class FilterExamples extends TestBase {

    @DisplayName("Get Student list")
    @Test
    void getStudent() {
        given().
                filter(new RequestLoggingFilter(requestCapture)).
                filter(new ResponseLoggingFilter(responseCapture)).
                when().
                get("/list");

        System.out.println(requestWriter.toString());
        System.out.println(responseWriter.toString());
    }

    @DisplayName("Get Wrong Student list")
    @Test
    void getWrongStudent() {
        given().
                filter(new ErrorLoggingFilter(errorCapture)).
                when().
                get("/lists");

        System.err.println(errorWriter.toString().toUpperCase());
    }
}
