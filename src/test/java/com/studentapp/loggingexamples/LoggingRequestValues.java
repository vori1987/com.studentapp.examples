package com.studentapp.loggingexamples;

import com.github.javafaker.Faker;
import com.studentapp.model.StudentPojo;
import com.studentapp.tests.TestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class LoggingRequestValues extends TestBase {

    @Test
    public void test001() {
        System.out.println("_________________Printing Request Headers________________");
        given().
                log().
                headers().
                when().
                get("/1").
                then().
                statusCode(200);

    }

    @Test
    public void test002() {
        System.out.println("_________________Printing Request Parameters________________");
        given().
                param("programme", "Computer Science").
                param("limit", 1).
                log().
                parameters().
                when().
                get("/list").
                then().
                statusCode(200);
    }

    @Test
    public void test003() {
        System.out.println("_________________Printing Request Body________________");
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
                log().
                body().
                when().
                body(student).
                post().
                then().
                statusCode(201);
    }

    @Test
    public void test004() {
        System.out.println("_________________Printing all the request details________________");
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
                log().
                all().
                when().
                body(student).
                post().
                then().
                statusCode(201);
    }

    @Test
    public void test005() {
        System.out.println("_________________Printing all the request details if validation fails________________");
        StudentPojo student = new StudentPojo();
        Faker fake = new Faker();

        List<String> courses = new ArrayList<>();
        courses.add("Java");
        courses.add("C++");

        student.setFirstName(fake.name().firstName());
        student.setLastName(fake.name().lastName());
        student.setEmail("egestas.rhoncus.Proin@massaQuisqueportytitor.org");
        student.setProgramme("Computer Science");
        student.setCourses(courses);

        given().
                contentType(ContentType.JSON).
                log().
                ifValidationFails().
                when().
                body(student).
                post().
                then().
                statusCode(201);
    }
}

