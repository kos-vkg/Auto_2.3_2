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

    static final String mainUri = "http://localhost";
    static final String mainUri2 = "/api/system/users";
    static final Integer mainPort = 9999;

    static Faker faker = new Faker(new Locale("en"));

    private static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(mainUri)
            .setPort(mainPort)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    static void addUser(UserData user) {
        given()
                .spec(requestSpec)
                .body(user)
                .when()
                .post(mainUri2)
                .then()
                .statusCode(200);
    }

    public static UserData generateUser(String status) {
        UserData user = new UserData(faker.name().fullName(), faker.internet().password(), status);
        addUser(user);
        return user;

    }
}
