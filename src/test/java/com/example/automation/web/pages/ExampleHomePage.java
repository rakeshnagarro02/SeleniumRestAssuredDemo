package com.example.automation.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExampleHomePage extends BasePage {
    private static final String PAGE_URL = "https://example.com";
    private static final By HEADER_TEXT = By.cssSelector("h1");
    private static final By DESCRIPTION_TEXT = By.cssSelector("p");

    public ExampleHomePage(WebDriver driver) {
        super(driver);
    }

    public ExampleHomePage open() {
        driver.get(PAGE_URL);
        return this;
    }

    public String getHeaderText() {
        WebElement header = waitUntil(driver -> driver.findElement(HEADER_TEXT));
        return header.getText();
    }

    public String getDescriptionText() {
        WebElement description = waitUntil(driver -> driver.findElement(DESCRIPTION_TEXT));
        return description.getText();
    }
}
