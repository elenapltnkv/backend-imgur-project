package ru.elenapltnkv.imgurTest;

import dao.ImageResponse;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static base.Endpoints.IMAGR_DELETE_HASH;
import static base.Endpoints.UPLOAD_IMG;
import static base.Images.URL_IMG;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static ru.elenapltnkv.imgurTest.spec.Specifications.*;

public class ImageUrlTest extends BaseTest {
    String imageDeleteHash;

    @Test
    void uploadImageUrlTest() throws FileNotFoundException {
        ImageResponse response =
                given(requestSpecification)
                        .multiPart("image", URL_IMG.getPath())
                        .expect()
                        .spec(positiveResponseSpecification)
                        .when()
                        .post(UPLOAD_IMG)
                        .prettyPeek()
                        .then()
                        .extract()
                        .as(ImageResponse.class);

        imageDeleteHash = response.getData().getDeletehash();

        assertThat(response.getData().getType(), equalTo("image/jpeg"));
        assertThat(response.getData().getInGallery(), equalTo(false));

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
