package com.example.automation.testng;

import com.example.automation.web.BaseTest;
import com.example.automation.web.pages.ExampleHomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestNGSmokeTest extends BaseTest {

    @Test
    public void examplePageLoadsSuccessfully() {
        ExampleHomePage exampleHomePage = new ExampleHomePage(driver).open();

        assertEquals(exampleHomePage.getTitle(), "Example Domain");
        assertEquals(exampleHomePage.getHeaderText(), "Example Domain");
    }
}
