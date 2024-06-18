package ru.elenapltnkv.imgurTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static ru.elenapltnkv.imgurTest.spec.Specifications.positiveResponseSpecification;
import static ru.elenapltnkv.imgurTest.spec.Specifications.requestSpecification;


public class AccountTestProp extends BaseTest {


    @Test
    public void getAccountTest() {
        given(requestSpecification)
                .when()
                .get("/account/{username}", username)
                .prettyPeek()
                .then()
                .body("data.url", CoreMatchers.equalTo(username));
    }

    //todo
    @Test
    void getAccountSettingsTest() {
        //host=https://api.imgur.com/3
        //https://api.imgur.com/3/account/me/settings
        Response response =
                given(requestSpecification)
                        .expect()
                        .spec(positiveResponseSpecification)
                        .body("data.email", CoreMatchers.equalTo("elenapltnkv@gmail.com"))//"email": "elenapltnkv@gmail.com"
                        .when()
                        .get(host+"/account/me/settings")
                        .prettyPeek();
        assertThat(response.jsonPath().get("data.email"), equalTo("elenapltnkv@gmail.com"));

    }
}
