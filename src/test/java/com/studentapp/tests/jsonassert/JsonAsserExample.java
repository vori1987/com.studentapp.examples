package com.studentapp.tests.jsonassert;

import com.studentapp.tests.TestBase;
import io.restassured.RestAssured;
import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonAsserExample extends TestBase {

    @DisplayName("Assertion in Students app")
    @Test
    public void getStudents() throws IOException, JSONException {
        String expectedValue = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")
                + File.separator + "test_assert.txt")));

        String actualValue = RestAssured.given().
                when().
                get("/list").asString();

        System.out.println(expectedValue);
        System.out.println(actualValue);

//        JSONAssert.assertEquals(expectedValue, actualValue, JSONCompareMode.STRICT);
        JSONAssert.assertEquals(expectedValue, actualValue, JSONCompareMode.LENIENT);
    }
}
