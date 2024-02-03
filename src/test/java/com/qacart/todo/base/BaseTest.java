package com.qacart.todo.base;

import com.qacart.todo.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
}
