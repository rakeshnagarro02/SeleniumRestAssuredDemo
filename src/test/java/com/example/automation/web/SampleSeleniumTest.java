package com.example.automation.web;

import com.example.automation.web.pages.ExampleHomePage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SampleSeleniumTest extends BaseTest {
    @Test
    void examplePageLoadsSuccessfully() {
        ExampleHomePage exampleHomePage = new ExampleHomePage(driver).open();

        assertEquals("Example Domain", exampleHomePage.getTitle());
        assertEquals("Example Domain", exampleHomePage.getHeaderText());
        assertEquals("This domain is for use in documentation examples without needing permission. Avoid use in operations.", exampleHomePage.getDescriptionText());
    }
}
