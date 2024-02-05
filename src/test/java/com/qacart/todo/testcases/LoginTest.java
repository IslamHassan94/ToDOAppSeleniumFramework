package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Auth Feature")
public class LoginTest extends BaseTest {

    @Story("Login using email and password")
    @Description("It will login by filling email and password and navigate to Todo page")
    @Test(description = "Test the   login functionality using username and password")
    public void shouldBeAbleToLoginWithEmailAndPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        boolean isWelcomeMessageDisplayed = loginPage
                .load()
                .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                .isWelcomeMessageDisplayed();

        Assert.assertTrue(isWelcomeMessageDisplayed);
    }
}
