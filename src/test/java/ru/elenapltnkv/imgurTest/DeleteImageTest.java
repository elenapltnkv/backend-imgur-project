package ru.elenapltnkv.imgurTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.elenapltnkv.imgurTest.spec.Specifications;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static ru.elenapltnkv.imgurTest.spec.Specifications.positiveResponseSpecification;

public class DeleteImageTest extends BaseTest {
    String imageDeleteHash;

    @BeforeEach
    void setUp() {
        imageDeleteHash = given()
                .body(new File("/home/user/IdeaProjects/backend-imgur-project/src/test/resources/image/img_1.png"))
                .when()
                .post("/upload")
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    public void deleteImageTest() {
        given()
                .spec(Specifications.requestSpecification)
                .expect()
                .spec(positiveResponseSpecification)
                .when()
                .delete("/image/{imageDeleteHash}", imageDeleteHash)
                .prettyPeek();


    }
}
