package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTitleTest {

    @Test
    public void testPageTitle() {
        try {
            // Ensure ChromeDriver matches the installed Chrome browser version
            WebDriverManager.chromedriver().browserVersion("128.0.6613.137").setup();

            // Configure Chrome options
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("start-maximized");

            // Initialize Chrome WebDriver with options
            WebDriver driver = new ChromeDriver(options);

            // Navigate to Sindabad.com
            driver.get("https://sindabad.com/");

            // Get the title of the current page
            String pageTitle = driver.getTitle();
            System.out.println("Title of the page: " + pageTitle);

            // Verify that the title contains "Sindabad" (or any other expected keyword)
            assertTrue(pageTitle.toLowerCase().contains("sindabad"), "Page title should contain 'Sindabad'");

            // Close the browser
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
}
