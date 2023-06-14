package com.studentapp.tests.jsonassert;

import com.studentapp.tests.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SoftHardAssertExample extends TestBase {
    @DisplayName("Hard Assertion in Students app")
    @Test
    public void hardAsserts() {
        given().
                when().
                get("/list").
                then().
                body("[0].firstName", equalTo("Vernon")).
                body("[0].lastName", equalTo("Harper")).
                body("[0].email", equalTo("egestas.rhoncus.Proin@massaQuisqueporttitor.org")).
                body("[0].programme", equalTo("Financial Analysis")).
                statusCode(200);
    }

    @DisplayName("Soft Assertion in Students app")
    @Test
    public void softAsserts() {
        given().
                when().
                get("/list").
                then().
                body("[0].firstName", equalTo("Vernon"), "[0].lastName",
                        equalTo("Harper"), "[0].email",
                        equalTo("egestas.rhoncus.Proin@massaQuisqueporttitor.org"),
                        "[0].programme", equalTo("Financial Analysis")).
                statusCode(200);
    }
}

