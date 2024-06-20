package ru.elenapltnkv.imgurTest;

import dao.ImageResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static base.Endpoints.IMAGR_DELETE_HASH;
import static base.Endpoints.UPLOAD_IMG;
import static base.Images.NEW_PNG;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static ru.elenapltnkv.imgurTest.spec.Specifications.*;

public class ImagePNGTest extends BaseTest {
    String imageDeleteHash;

    @Test
    void uploadImagePNGTest() {
        ImageResponse response =
                given(requestSpecification)
                        .multiPart("image", new File(NEW_PNG.getPath()))
                        .expect()
                        .spec(positiveResponseSpecification)
                        .when()
                        .post(UPLOAD_IMG)
                        .prettyPeek()
                        .then()
                        .extract()
                        .as(ImageResponse.class);

        imageDeleteHash = response.getData().getDeletehash();

        assertThat(response.getData().getAccountId(), equalTo(179239057));
        assertThat(response.getData().getType(), equalTo("image/png"));

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
