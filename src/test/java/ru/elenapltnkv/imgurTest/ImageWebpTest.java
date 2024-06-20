package ru.elenapltnkv.imgurTest;


import dao.ErrorResponse;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.io.File;

import static base.Endpoints.UPLOAD_IMG;
import static base.Images.WEBP_IMG;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static ru.elenapltnkv.imgurTest.spec.Specifications.negativeResponseSpecification;


public class ImageWebpTest extends BaseTest {

    @Test
    void uploadImageWebpTest() {
        ErrorResponse response =
                given()
                        .multiPart("image", new File(WEBP_IMG.getPath()))
                        .expect()
                        .spec(negativeResponseSpecification)
                        .when()
                        .post(UPLOAD_IMG)
                        .prettyPeek()
                        .then()
                        .extract()
                        .as(ErrorResponse.class);

        assertThat(response.getData().getError(), equalTo("We don't support that file type!"));


    }


}
