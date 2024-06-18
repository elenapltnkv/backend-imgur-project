package ru.elenapltnkv.imgurTest;

import io.restassured.mapper.ObjectMapperType;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

import static io.restassured.RestAssured.given;
import static ru.elenapltnkv.imgurTest.spec.Specifications.*;

public class ImageUrlTest extends BaseTest {
    String imageDeleteHash;

    @Test
    void uploadImageUrlTest() throws FileNotFoundException {
        String imgURL = "https://pictures.pibig.info/uploads/posts/2023-04/1680603592_pictures-pibig-info-p-realistichnie-risunki-zhivotnikh-instagram-35.jpg";
        imageDeleteHash = given(requestSpecification)
                .formParam("image", imgURL)
                .expect()
                .spec(positiveResponseSpecification)
                .body("data.type", CoreMatchers.equalTo("image/jpeg"))
                .when()
                .post("/upload")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @AfterEach
    void tearDown() {
        given(requestSpecification)
                .expect()
                .spec(positiveUploadResponseSpecification)
                .when()
                .delete("/image/{imageDeleteHash}", imageDeleteHash);

    }
}
