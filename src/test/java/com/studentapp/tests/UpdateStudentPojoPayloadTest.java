package com.studentapp.tests;

import com.github.javafaker.Faker;
import com.studentapp.model.StudentPojo;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UpdateStudentPojoPayloadTest extends TestBase {

    @DisplayName("Update a new student by sending payload as Pojo")
    @Test
    void updateStudent() {

        StudentPojo student = new StudentPojo();
        Faker fake = new Faker();

        List<String> courses = new ArrayList<>();
        courses.add("Java");
        courses.add("C++");

        student.setFirstName(fake.name().firstName());
        student.setLastName(fake.name().lastName());
        student.setEmail(fake.internet().emailAddress());
        student.setProgramme("Computer Science");
        student.setCourses(courses);

        given().
                when().
                contentType(ContentType.JSON).
                when().
                body(student).
                put("/106").
                then().
                statusCode(200);
    }

}
