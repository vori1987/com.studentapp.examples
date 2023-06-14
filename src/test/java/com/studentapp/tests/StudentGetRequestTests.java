package com.studentapp.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StudentGetRequestTests extends TestBase {
    private void styles() {
        RestAssured.given().
                queryParam("", "").
                when().
                get("https://www.google.com/").
                then();

        RestAssured.given().
                expect().
                when();
    }

    @Disabled
    @DisplayName("Getting all the students from DB")
    @Test
    void getAllStudents() {
//        RequestSpecification requestSpecific = RestAssured.given().given();
//        Response response = requestSpecific.get("/list");
//
//        response.prettyPrint();
//        ValidatableResponse validatableResponse = response.then();
//        validatableResponse.statusCode(200);

//        RestAssured.given().
//                when().
//                get("/list").
//                then().
//                statusCode(200);

        given().
                expect().
                statusCode(200).
                when().
                get("/list");

    }

    @Disabled
    @DisplayName("Get a CS student from the list")
    @Test
    void getSingleCSStudent() {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("programme", "Computer Science");
        params.put("limit", 1);

        Response response =
                given().
//                queryParam("programme", "Computer Science").
//                queryParam("limit", "1").when().
//                queryParams("programme", "Computer Science", "limit", "1").
        queryParams(params).
                        get("/list");

        response.prettyPrint();
    }

    @DisplayName("PathParameterExample: Get the firstStudent")
    @Test
    void getTheFirstStudent() {
        Response response =
                given().
                        pathParam("id", 2).
                        when().
                        get("/{id}");

        response.prettyPrint();
    }
}
