package ru.elenapltnkv.imgurTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static base.Endpoints.IMAGR_DELETE_HASH;
import static base.Endpoints.UPLOAD_IMG;
import static base.Images.WEBM_VIDEO;
import static io.restassured.RestAssured.given;
import static ru.elenapltnkv.imgurTest.spec.Specifications.*;

public class VideoWebmTest extends BaseTest {
    String imageDeleteHash;

    @Test
    void uploadVideoWebmTest() {
        imageDeleteHash = given(requestSpecification)
                .multiPart("image",new File(WEBM_VIDEO.getPath()))
                .expect()
                .spec(positiveResponseSpecification)
                .when()
                .post(UPLOAD_IMG)
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
                .delete(IMAGR_DELETE_HASH, imageDeleteHash);

    }
}
