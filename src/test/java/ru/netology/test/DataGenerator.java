package ru.netology.test;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import ru.netology.data.UserData;

import java.util.Locale;

import static io.restassured.RestAssured.given;

public class DataGenerator {

    static final String MAIN_URI = "http://localhost";
    static final String MAIN_URI_2 = "/api/system/users";
    static final Integer MAIN_PORT = 9999;

    static Faker faker = new Faker(new Locale("en"));

    private static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(MAIN_URI)
            .setPort(MAIN_PORT)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    static void addUser(UserData user) {
        given()
                .spec(requestSpec)
                .body(user)
                .when()
                .post(MAIN_URI_2)
                .then()
                .statusCode(200);
    }

    public static UserData generateUser(String status) {
        UserData user = new UserData(faker.name().fullName(), faker.internet().password(), status);
        addUser(user);
        return user;
    }
}
