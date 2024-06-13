package ru.elenapltnkv.imgurTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class AccountTest {
    @BeforeAll
    public static void beforeAll() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void getAccountTest() {
        given()
                .header("Authorization", "Bearer 61bb09cf6c8bc60ca33c508263305a1570a919c5")
                .log()
                .method()
                .log()
                .uri()
                .when()
                .get("https://api.imgur.com/3/account/samelena")
                .prettyPeek()
                .then()
                .statusCode(200)
                .body("success", CoreMatchers.is(true))
                .body("data.url", CoreMatchers.equalTo("samelena"));
    }

    @Test
    void getAccountSettingsTest() {
        //https://api.imgur.com/3/account/me/settings
        Response response =
        given()
                .header("Authorization", "Bearer 61bb09cf6c8bc60ca33c508263305a1570a919c5")
                .log()
                .all()
                .expect()
                .body("data.email", CoreMatchers.equalTo("elenapltnkv@gmail.com"))//"email": "elenapltnkv@gmail.com"
                .body("success", CoreMatchers.is(true))
                .when()
                .get("https://api.imgur.com/3/account/me/settings")
                .prettyPeek();
//                .then()
//                .statusCode(200);
        assertThat(response.jsonPath().get("data.email"), equalTo("elenapltnkv@gmail.com"));

    }
}
