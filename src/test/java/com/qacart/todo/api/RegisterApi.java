package com.qacart.todo.api;

import com.qacart.todo.objects.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RegisterApi {

    private Cookies restAssuredCookies;
    private String accessToken;
    private String userId;
    private String firstName;

    public String getAccessToken() {
        return this.accessToken;
    }

    public Cookies getRestAssuredCookies() {
        return this.restAssuredCookies;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void register() {
        User user = UserUtils.generateRandomUser();
        Response response =
                given()
                        .baseUri("https://todo.qacart.com")
                        .header("Content-Type", "application/json")
                        .body(user)
                        .log()
                        .all()
                        .when()
                        .post("/api/v1/users/register")
                        .then()
                        .log()
                        .all()
                        .extract().response();

        if (response.statusCode() != 201) {
            throw new RuntimeException("Something went wrong with the request");
        }
        restAssuredCookies = response.detailedCookies();
        accessToken = response.path("access_token");
        userId = response.path("userID");
        firstName = response.path("firstName");
    }
}
