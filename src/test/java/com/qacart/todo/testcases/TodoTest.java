package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TaskApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TodoTest extends BaseTest {

    @Test
    public void shouldBeAbleToAddNewTodo() {
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        NewTodoPage newTodoPage = new NewTodoPage(driver);
        newTodoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());
        String actualResult = newTodoPage
                .load()
                .addNewTask("Learn Selenium")
                .getTodoText();

        Assert.assertEquals(actualResult, "Learn Selenium");
    }

    @Test(enabled = true)
    public void shouldBeAbleToDeleteTodo() {
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        TaskApi taskApi = new TaskApi();
        taskApi.addTask(registerApi.getAccessToken());

        TodoPage todoPage = new TodoPage(driver);
        todoPage.load();

        NewTodoPage newTodoPage = new NewTodoPage(driver);
        newTodoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());
        boolean isNoTodoDisplayed = todoPage
                .load()
                .clickDeleteButton()
                .isNoTodosMessageDisplayed();

        Assert.assertTrue(isNoTodoDisplayed);
    }
}
