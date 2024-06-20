package ru.elenapltnkv.imgurTest;

import dao.ImageResponse;
import dao.VideoResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static base.Endpoints.IMAGR_DELETE_HASH;
import static base.Endpoints.UPLOAD_IMG;
import static base.Images.MP4_VIDEO;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static ru.elenapltnkv.imgurTest.spec.Specifications.*;

public class VideoMP4Test extends BaseTest {
    String imageDeleteHash;

    @Test
    void uploadVideoMP4Test() {
        VideoResponse response =
                given(requestSpecification)
                        .multiPart("image", new File(MP4_VIDEO.getPath()))
                        .expect()
                        .spec(positiveResponseSpecification)
                        .when()
                        .post(UPLOAD_IMG)
                        .prettyPeek()
                        .then()
                        .extract()
                        .as(VideoResponse.class);

        imageDeleteHash = response.getData().getDeletehash();
        assertThat(response.getData().getType(), equalTo("video/mp4"));
        assertThat(response.getData().getMp4Size(), equalTo(7087562));

    }

    @AfterEach
    void tearDown() {
        given(requestSpecification)
                .expect()
                .spec(positiveUploadResponseSpecification)
                .when()
                .delete(IMAGR_DELETE_HASH, imageDeleteHash)
                .then()
                .statusCode(200);

    }
}
