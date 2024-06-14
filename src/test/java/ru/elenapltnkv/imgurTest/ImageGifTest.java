package ru.elenapltnkv.imgurTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ImageGifTest extends BaseTest {
    String imageDeleteHash;

    @Test
    void uploadImageGifTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File("/home/user/IdeaProjects/backend-imgur-project/src/test/resources/HrNfJ.gif"))
                .expect()
                .statusCode(200)
                .when()
                .post("/upload")
                .prettyPeek()
//                .then()
//                .statusCode(200);
                .jsonPath()
                .get("data.deletehash");
    }


}
