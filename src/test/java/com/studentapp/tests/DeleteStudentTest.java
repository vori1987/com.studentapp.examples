package com.studentapp.tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteStudentTest extends TestBase {

    @DisplayName("Delete of student record")
    @Test
    void deleteStudent() {

        given().
                when().
                contentType(ContentType.JSON).
                when().
                delete("/108").
                then().
                statusCode(204);
    }
}
