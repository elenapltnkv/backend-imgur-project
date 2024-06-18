package ru.elenapltnkv.imgurTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class ImageGifTest extends BaseTest {
    String imageDeleteHash;

    @Test
    void uploadImageGifTest() {
        imageDeleteHash = given()
                .body(new File("/home/user/IdeaProjects/backend-imgur-project/src/test/resources/image/HrNfJ.gif"))
                .when()
                .post("/upload")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }


}
