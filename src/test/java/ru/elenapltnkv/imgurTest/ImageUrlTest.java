package ru.elenapltnkv.imgurTest;

import io.restassured.mapper.ObjectMapperType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;

import static io.restassured.RestAssured.given;

public class ImageUrlTest extends BaseTest {
    String imageDeleteHash;

    @Test
    void uploadImageUrlTest() {
        String URL = "https://pictures.pibig.info/uploads/posts/2023-04/1680603592_pictures-pibig-info-p-realistichnie-risunki-zhivotnikh-instagram-35.jpg";
        imageDeleteHash = given()
                .header("Authorization", token)
                .body(URL)
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
