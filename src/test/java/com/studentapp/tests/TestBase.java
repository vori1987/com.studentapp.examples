package com.studentapp.tests;

import io.restassured.RestAssured;
import org.apache.commons.io.output.WriterOutputStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.PrintStream;
import java.io.StringWriter;

public class TestBase {
    public static StringWriter requestWriter;
    public static PrintStream requestCapture;

    public static StringWriter responseWriter;
    public static PrintStream responseCapture;


    public static StringWriter errorWriter;
    public static PrintStream errorCapture;
    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/student";
    }

    @BeforeEach
    public void beforeEachTest() {
        requestWriter = new StringWriter();
        requestCapture = new PrintStream(new WriterOutputStream(requestWriter),true);

        responseWriter = new StringWriter();
        responseCapture = new PrintStream(new WriterOutputStream(responseWriter),true);

        errorWriter = new StringWriter();
        errorCapture = new PrintStream(new WriterOutputStream(errorWriter),true);
    }

}
