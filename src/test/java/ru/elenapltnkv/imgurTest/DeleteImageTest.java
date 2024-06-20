package ru.elenapltnkv.imgurTest;

import dao.DelImgResponse;
import dao.ImageResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.elenapltnkv.imgurTest.spec.Specifications;

import java.io.File;

import static base.Endpoints.IMAGR_DELETE_HASH;
import static base.Endpoints.UPLOAD_IMG;
import static base.Images.PNG1_IMG;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static ru.elenapltnkv.imgurTest.spec.Specifications.positiveResponseSpecification;

public class DeleteImageTest extends BaseTest {
    String imageDeleteHash;

    @BeforeEach
    void setUp() {
        ImageResponse res = given()
                .spec(Specifications.requestSpecification)
                .multiPart("image", new File(PNG1_IMG.getPath()))
                .when()
                .post(UPLOAD_IMG)
                .then()
                .extract()
                .as(ImageResponse.class);

        imageDeleteHash = res.getData().getDeletehash();
    }

    @Test
    public void deleteImageTest() {
        DelImgResponse response =
                given()
                        .spec(Specifications.requestSpecification)
                        .expect()
                        .spec(positiveResponseSpecification)
                        .when()
                        .delete(IMAGR_DELETE_HASH, imageDeleteHash)
                        .prettyPeek()
                        .then()
                        .extract()
                        .as(DelImgResponse.class);
        assertThat(response.getStatus(), equalTo(200));
        assertThat(response.getSuccess(), equalTo(true));


    }
}
