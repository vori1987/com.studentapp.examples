package com.filedownloads.example;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FileDownLoadExample {

    @Description("Download a file and Compare it with an Expected File")
    @Test
    public void verifyDownloadedFile() {
        //REad the input file

        File inputFile = new File(System.getProperty("user.dir") +
                File.separator + "geckodriver-v0.33.0-win-aarch64.zip");

        //Length of input file
        int expectedSize = (int) inputFile.length();

        System.out.println("The size of the expected file is: " + expectedSize + " bytes");


        byte[] actualValue = given().
                when().
                get("https://github.com/mozilla/geckodriver/releases/download/v0.33.0/geckodriver-v0.33.0-win-aarch64.zip").
                then().
                extract().
                asByteArray();
        System.out.println("The size of the actual file is: " + actualValue.length + " bytes");

        assertThat(expectedSize, equalTo(actualValue.length));

    }
}
