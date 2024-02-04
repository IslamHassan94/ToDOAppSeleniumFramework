package com.qacart.todo.base;

import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.utils.CookieUtil;
import io.restassured.http.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new DriverFactory().initializeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void injectCookiesToBrowser(List<Cookie> restAssuredCookies) {
        CookieUtil.convertRestAssuredCookiesToSeleniumCookies(restAssuredCookies).stream().forEach(cookie -> driver.manage().addCookie(cookie));
    }
}

