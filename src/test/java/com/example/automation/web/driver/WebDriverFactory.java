package com.example.automation.web.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public final class WebDriverFactory {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private WebDriverFactory() {
        // Utility class
    }

    public static WebDriver getDriver() {
        WebDriver driver = DRIVER.get();
        if (driver == null) {
            throw new IllegalStateException("WebDriver has not been initialized for this thread.");
        }
        return driver;
    }

    public static WebDriver initDriver() {
        if (DRIVER.get() == null) {
            DRIVER.set(createWebDriver());
        }
        return DRIVER.get();
    }

    public static void quitDriver() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            try {
                driver.quit();
            } finally {
                DRIVER.remove();
            }
        }
    }

    private static WebDriver createWebDriver() {
        boolean headless = Boolean.parseBoolean(System.getProperty("selenium.headless", "true"));
        try {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if (headless) {
                options.addArguments("--headless=new", "--window-size=1920,1080");
            } else {
                options.addArguments("--window-size=1920,1080");
            }
            options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
            return new ChromeDriver(options);
        } catch (Exception exception) {
            return new HtmlUnitDriver(true);
        }
    }
}
