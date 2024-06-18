package ru.elenapltnkv.imgurTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static ru.elenapltnkv.imgurTest.spec.Specifications.*;

public class VideoMP4Test extends BaseTest {
    String imageDeleteHash;

    @Test
    void uploadVideoMP4Test() {
        imageDeleteHash = given(requestSpecification)
                .body(new File("/home/user/IdeaProjects/backend-imgur-project/src/test/resources/image/funny-aww-cat-Sesame-is-too-cute.mp4"))
                .expect()
                .spec(positiveResponseSpecification)
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
                .delete("/image/{imageDeleteHash}", imageDeleteHash)
                .then()
                .statusCode(200);

    }
}
