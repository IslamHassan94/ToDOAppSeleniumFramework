package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {

    public TodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement welcomeMessage;

    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement addButton;

    @FindBy(css = "[data-testid=\"todo-item\"]")
    private WebElement todoItem;

    @FindBy(css = "[data-testid=\"delete\"]")
    private WebElement deleteButton;

    @FindBy(css = "[data-testid=\"no-todos\"]")
    private WebElement noTodosMessage;


    public boolean isWelcomeMessageDisplayed() {
        return welcomeMessage.isDisplayed();
    }

    public NewTodoPage clickPlusButton() {
        addButton.click();
        return new NewTodoPage(driver);
    }

    public String getTodoText() {
        return todoItem.getText();
    }

    public TodoPage clickDeleteButton() {
        deleteButton.click();
        return this;
    }

    public boolean isNoTodosMessageDisplayed() {
        return noTodosMessage.isDisplayed();
    }

}
