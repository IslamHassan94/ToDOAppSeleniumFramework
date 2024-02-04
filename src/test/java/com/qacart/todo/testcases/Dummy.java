package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.objects.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Dummy {
    public static void main(String[] args) {
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        System.out.println(registerApi.getAccessToken());
        System.out.println(registerApi.getUserId());
        System.out.println(registerApi.getFirstName());
    }
}
