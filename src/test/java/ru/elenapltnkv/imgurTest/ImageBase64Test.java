package ru.elenapltnkv.imgurTest;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;


import static io.restassured.RestAssured.given;
import static ru.elenapltnkv.imgurTest.spec.Specifications.positiveResponseSpecification;
import static ru.elenapltnkv.imgurTest.spec.Specifications.requestSpecification;


public class ImageBase64Test extends BaseTest {
    String imageDeleteHash;
    static String UP_FILE = "/home/user/IdeaProjects/backend-imgur-project/src/test/resources/image/img.png";
    String base64Image;

    @BeforeEach
    void setUp() throws IOException {
        byte[] imgByte = FileUtils.readFileToByteArray(new File(UP_FILE));
        base64Image = Base64.getEncoder().encodeToString(imgByte);
    }

    @Test
    void uploadImageBase64Test() throws FileNotFoundException {
        imageDeleteHash = given(requestSpecification)
                .multiPart("image", base64Image)
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
                .spec(positiveResponseSpecification)
                .when()
                .delete("/image/{imageDeleteHash}", imageDeleteHash);


    }
}
