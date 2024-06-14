package ru.elenapltnkv.imgurTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class ImageBase64Test extends BaseTest {
    String imageDeleteHash;

    @Test
    void uploadImageBase64Test() throws FileNotFoundException {
        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new FileInputStream("/home/user/IdeaProjects/backend-imgur-project/src/test/resources/base64.txt"))
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
