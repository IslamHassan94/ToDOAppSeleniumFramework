package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid='email']")
    private WebElement emailInput;

    @FindBy(css = "[data-testid='password']")
    private WebElement passwordInput;

    @FindBy(css = "[data-testid='submit']")
    private WebElement submit;

    public LoginPage load() {
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        return this;
    }

    public TodoPage login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submit.click();
        return new TodoPage(driver);
    }

}
