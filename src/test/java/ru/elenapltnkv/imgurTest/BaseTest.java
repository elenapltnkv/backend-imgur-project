package ru.elenapltnkv.imgurTest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.requestSpecification;
import static ru.elenapltnkv.imgurTest.spec.Specifications.negativeResponseSpecification;
import static ru.elenapltnkv.imgurTest.spec.Specifications.positiveResponseSpecification;

public abstract class BaseTest {
    static Properties properties;
    static String host;
    static String username;
    protected static String token;
//    static ResponseSpecification positiveResponseSpecification;
//    static RequestSpecification requestSpecification;

    @BeforeAll
    public static void beforeAll() throws IOException {
//        positiveResponseSpecification = new ResponseSpecBuilder()
//                .expectStatusCode(200)
//                .expectBody("success", CoreMatchers.is(true))
//                .build();


        properties = new Properties();
        properties.load(new FileInputStream("/home/user/IdeaProjects/backend-imgur-project/src/test/resources/application.properties"));
        host = (String) properties.get("host");
        token = (String) properties.get("token");
        username = (String) properties.get("username");

        RestAssured.baseURI = host;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

//        requestSpecification = new RequestSpecBuilder()
//                .addHeader("Authorization", token)
//                .log(LogDetail.ALL)
//                .build();
        //RestAssured.requestSpecification = requestSpecification;

        //responseSpecification = positiveResponseSpecification;
        //RestAssured.responseSpecification = negativeResponseSpecification;



    }
}
