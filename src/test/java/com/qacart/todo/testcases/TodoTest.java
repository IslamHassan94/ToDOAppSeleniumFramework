package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TodoTest extends BaseTest {

    @Test
    public void shouldBeAbleToAddNewTodo() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        String actualResult =
                loginPage
                        .load()
                        .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                        .clickPlusButton()
                        .addNewTask("Learn Selenium")
                        .getTodoText();

        Assert.assertEquals(actualResult, "Learn Selenium");
    }

    @Test(enabled = false)
    public void shouldBeAbleToDeleteTodo() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        boolean isNoTodoDisplayed =
                loginPage
                        .load()
                        .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                        .clickPlusButton()
                        .addNewTask("Learn Selenium")
                        .clickDeleteButton()
                        .isNoTodosMessageDisplayed();

        Assert.assertTrue(isNoTodoDisplayed);
    }
}
