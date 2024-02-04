package com.qacart.todo.api;

import com.qacart.todo.config.Endpoints;
import com.qacart.todo.objects.Task;
import com.qacart.todo.utils.ConfigUtils;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TaskApi {

    public void addTask(String token) {
        Task task = new Task("Take vitamins", false);
        Response response = given()
                .baseUri(ConfigUtils.getInstance().getBaseUrl())
                .header("Content-Type", "application/json")
                .body(task)
                .auth().oauth2(token)
                .when()
                .post(Endpoints.API_TASK_ENDPOINT)
                .then()
                .log().all().extract().response();

        if (response.statusCode() != 201) {
            throw new RuntimeException("Something went wrong while adding the task");
        }
    }
}
