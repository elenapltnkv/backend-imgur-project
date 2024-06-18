package ru.elenapltnkv.imgurTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.elenapltnkv.imgurTest.spec.Specifications;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static ru.elenapltnkv.imgurTest.spec.Specifications.positiveUploadResponseSpecification;

public class ImageImgTest extends BaseTest {
    String imageDeleteHash;

    @Test
    void uploadImageImgTest() {
        imageDeleteHash = given()
                .spec(Specifications.requestSpecification)
                .body(new File("/home/user/IdeaProjects/backend-imgur-project/src/test/resources/image/img.png"))
                .expect()
                .spec(positiveUploadResponseSpecification)
                .when()
                .post("/upload")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @AfterEach
    void tearDown() {
        given()
                .spec(Specifications.requestSpecification)
                .expect()
                .spec(positiveUploadResponseSpecification)
                .when()
                .delete("/image/{imageDeleteHash}", imageDeleteHash);


    }
}
