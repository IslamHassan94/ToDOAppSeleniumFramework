package com.qacart.todo.utils;

import com.github.javafaker.Faker;
import com.qacart.todo.objects.User;

public class UserUtils {
    public static User generateRandomUser() {
        String email = new Faker().internet().emailAddress();
        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();
        String password = new Faker().internet().password();

        User user = new User(email, firstName, lastName, password);
        return user;
    }
}
