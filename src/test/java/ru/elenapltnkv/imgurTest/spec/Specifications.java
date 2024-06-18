package ru.elenapltnkv.imgurTest.spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.CoreMatchers;
import ru.elenapltnkv.imgurTest.BaseTest;

public class Specifications extends BaseTest {


    public static RequestSpecification requestSpecification = new RequestSpecBuilder()
            .addHeader("Authorization", token)
            .log(LogDetail.ALL)
            .build();

    public static ResponseSpecification positiveResponseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody("success", CoreMatchers.is(true))
            .build();

    public static ResponseSpecification positiveUploadResponseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();

    public static ResponseSpecification negativeResponseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(400)
            .expectBody("success", CoreMatchers.is(false))
            .build();

}
