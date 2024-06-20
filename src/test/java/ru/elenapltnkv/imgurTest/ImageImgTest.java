package ru.elenapltnkv.imgurTest;

import dao.ImageResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.elenapltnkv.imgurTest.spec.Specifications;

import java.io.File;

import static base.Endpoints.IMAGR_DELETE_HASH;
import static base.Endpoints.UPLOAD_IMG;
import static base.Images.PNG_IMG;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static ru.elenapltnkv.imgurTest.spec.Specifications.positiveUploadResponseSpecification;

public class ImageImgTest extends BaseTest {
    String imageDeleteHash;

    @Test
    void uploadImageImgTest() {
        ImageResponse response =
                given()
                        .spec(Specifications.requestSpecification)
                        .multiPart("image", new File(PNG_IMG.getPath()))
                        .expect()
                        .spec(positiveUploadResponseSpecification)
                        .when()
                        .post(UPLOAD_IMG)
                        .prettyPeek()
                        .then().extract()
                        .as(ImageResponse.class);

        assertThat(response.getData().getAccountUrl(), equalTo(username));
        assertThat(response.getData().getType(), equalTo("image/png"));

        imageDeleteHash = response.getData().getDeletehash();
    }

    @AfterEach
    void tearDown() {
        given()
                .spec(Specifications.requestSpecification)
                .expect()
                .spec(positiveUploadResponseSpecification)
                .when()
                .delete(IMAGR_DELETE_HASH, imageDeleteHash);


    }
}
