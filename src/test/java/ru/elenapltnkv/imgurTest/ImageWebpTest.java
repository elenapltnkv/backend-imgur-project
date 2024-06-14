package ru.elenapltnkv.imgurTest;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Matcher;

import static io.restassured.RestAssured.given;

public class ImageWebpTest extends BaseTest {

    @Test
    void uploadImageTest() {
        given()
                .header("Authorization", token)
                .body(new File("/home/user/IdeaProjects/backend-imgur-project/src/test/resources/image/i.webp"))
                .expect()
                .when()
                .post("/upload")
                .prettyPeek()
                .then()
                .statusCode(400)
                .body("success", CoreMatchers.is(false))
                .body("data.error", CoreMatchers.equalTo("We don't support that file type!"));

    }


}
