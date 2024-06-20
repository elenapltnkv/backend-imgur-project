package ru.elenapltnkv.imgurTest;

import dao.AccountResponse;
import dao.AccountSettings;
import io.restassured.response.Response;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;


import static base.Endpoints.ACCOUNT_AC;
import static base.Endpoints.ACCOUNT_SETTINGS;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static ru.elenapltnkv.imgurTest.spec.Specifications.positiveResponseSpecification;
import static ru.elenapltnkv.imgurTest.spec.Specifications.requestSpecification;


public class AccountTestProp extends BaseTest {


    @Test
    public void getAccountTest() {
        AccountResponse dataAuthResponse =
                given(requestSpecification)
                        .when()
                        .get(ACCOUNT_AC, username)
                        .prettyPeek()
                        .then()
                        .extract()
                        .as(AccountResponse.class);
        assertThat(dataAuthResponse.getData().getUrl(), is(username));
    }

    @Test
    void getAccountSettingsTest() {

        AccountSettings response =
                given(requestSpecification)
                        .expect()
                        .spec(positiveResponseSpecification)
                        .when()
                        .get(host + ACCOUNT_SETTINGS)
                        .prettyPeek()
                        .then()
                        .extract()
                        .as(AccountSettings.class);
        assertThat(response.getData().getEmail(), equalTo("elenapltnkv@gmail.com"));


    }
}
