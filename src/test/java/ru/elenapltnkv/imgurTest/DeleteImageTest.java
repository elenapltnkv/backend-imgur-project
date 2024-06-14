package ru.elenapltnkv.imgurTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class DeleteImageTest extends BaseTest {
    String imageDeleteHash;

    @BeforeEach
    void setUp() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File("/home/user/IdeaProjects/backend-imgur-project/src/test/resources/image/img_1.png"))
                .when()
                .post("/upload")
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    public void deleteImageTest() {
        given()
                .when()
                .header("Authorization", token)
                .delete("/image/{imageDeleteHash}", imageDeleteHash)
                .prettyPeek()
                .then()
                .statusCode(200);

    }
}
