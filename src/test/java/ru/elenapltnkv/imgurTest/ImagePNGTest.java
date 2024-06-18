package ru.elenapltnkv.imgurTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static ru.elenapltnkv.imgurTest.spec.Specifications.*;

public class ImagePNGTest extends BaseTest {
    String imageDeleteHash;

    @Test
    void uploadImagePNGTest() {
        imageDeleteHash = given(requestSpecification)
                .body(new File("/home/user/IdeaProjects/backend-imgur-project/src/test/resources/image/free-icon-linux-2333464.png"))
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
                .delete("/image/{imageDeleteHash}", imageDeleteHash);


    }

    //todo refactoring добавить поджо, изменить тесты (добавить в недостающие спецификации)
}
