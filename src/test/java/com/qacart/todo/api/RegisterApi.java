package com.qacart.todo.api;

import com.qacart.todo.config.Endpoints;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {

    private List<Cookie> cookies;
    private String accessToken;
    private String userId;
    private String firstName;

    public String getAccessToken() {
        return this.accessToken;
    }

    public List<Cookie> getCookies() {
        return this.cookies;
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
                        .baseUri(ConfigUtils.getInstance().getBaseUrl())
                        .header("Content-Type", "application/json")
                        .body(user)
                        .log()
                        .all()
                        .when()
                        .post(Endpoints.API_REGISTER_ENDPOINT)
                        .then()
                        .log()
                        .all()
                        .extract().response();

        if (response.statusCode() != 201) {
            throw new RuntimeException("Something went wrong with the request");
        }
        cookies = response.detailedCookies().asList();
        accessToken = response.path("access_token");
        userId = response.path("userID");
        firstName = response.path("firstName");
    }
}
