package com.example.automation.web;

import com.example.automation.web.driver.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = WebDriverFactory.initDriver();
    }

    @AfterEach
    void tearDown() {
        WebDriverFactory.quitDriver();
    }
}
