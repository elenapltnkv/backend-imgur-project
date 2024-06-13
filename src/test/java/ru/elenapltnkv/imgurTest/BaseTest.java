package ru.elenapltnkv.imgurTest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class BaseTest {
    static Properties properties;
    static String host;
    static String username;
    static String token;

    @BeforeAll
    public static void beforeAll() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream("/home/user/IdeaProjects/backend-imgur-project/src/test/resources/application.properties"));
        host = (String) properties.get("host");
        token = (String) properties.get("token");
        username= (String) properties.get("username");
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.baseURI= host;
    }
}
