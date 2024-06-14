package ru.elenapltnkv.imgurTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ImageImgTest extends BaseTest {
    String imageDeleteHash;

    @Test
    void uploadImageImgTest() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File("/home/user/IdeaProjects/backend-imgur-project/src/test/resources/img.png"))
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

    @AfterEach
    void tearDown() {
        given()
                .when()
                .header("Authorization", token)
                .delete("/image/{imageDeleteHash}", imageDeleteHash)
                .then()
                .statusCode(200);

    }
}
