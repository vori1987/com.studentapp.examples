package com.studentapp.tests;

import com.github.javafaker.Faker;
import com.studentapp.model.StudentPojo;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UpdateStudentPojoPayloadTest extends TestBase {

    @DisplayName("Update an email of student by sending payload as Pojo")
    @Test
    void updateStudentEmail() {

        StudentPojo student = new StudentPojo();
        Faker fake = new Faker();

        student.setEmail(fake.internet().emailAddress());

        given().
                when().
                contentType(ContentType.JSON).
                when().
                body(student).
                patch("/106").
                then().
                statusCode(200);
    }
}
