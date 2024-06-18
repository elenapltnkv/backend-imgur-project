package ru.elenapltnkv.imgurTest;


import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static ru.elenapltnkv.imgurTest.spec.Specifications.negativeResponseSpecification;


public class ImageWebpTest extends BaseTest {

    @Test
    void uploadImageWebpTest() {
        given()
                .body(new File("/home/user/IdeaProjects/backend-imgur-project/src/test/resources/image/i.webp"))
                .expect()
                .spec(negativeResponseSpecification)
                .when()
                .post("/upload")
                .prettyPeek()
                .then()
                .body("data.error", CoreMatchers.equalTo("We don't support that file type!"));

    }


}
