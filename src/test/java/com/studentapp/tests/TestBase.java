package com.studentapp.tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.ProxySpecification;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.output.WriterOutputStream;
import org.apache.http.client.methods.RequestBuilder;
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

    public static RequestSpecBuilder rspec;
    public static RequestSpecification rp;

    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/student";
        ProxySpecification ps = new ProxySpecification("localhost",5555,"http");

        rspec = new RequestSpecBuilder();
        rspec.setProxy(ps);

        rp = rspec.build();
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
