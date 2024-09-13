package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchBtnTest {

    @Test
    public void testSearchLaptop() {
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

            // Locate the search input box using the id attribute
            WebElement searchBox = driver.findElement(By.id("inlineFormInputGroupUsername1"));

            // Enter "laptop" into the search box
            searchBox.sendKeys("laptop");

            // Submit the search
            searchBox.submit();

            // Wait for search results to load (can be optimized with explicit waits)
            Thread.sleep(2000); // Basic wait, replace with WebDriverWait for better practice

            // Verify that the search was successful by checking if the title or search results page contains the keyword "laptop"
            assertTrue(driver.getTitle().toLowerCase().contains("laptop") || 
                       driver.getPageSource().toLowerCase().contains("laptop"),
                       "The search results should contain the keyword 'laptop'");

            // Optionally, print a message indicating that the search was successful
            System.out.println("Search for 'laptop' was successful!");

            // Close the browser
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
