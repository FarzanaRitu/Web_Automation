package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MenuButtonTest {

    @Test
    public void testMenuButtonClick() {
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

            // Locate the menu button using its class name and click on it
            WebElement menuButton = driver.findElement(By.cssSelector(".toggle.header-toggle-hamburg.cursor-pointer"));
            menuButton.click();

            // Verify if the menu button was clicked by checking for a visible element that appears after the click
            // (Here you might want to check that a menu or another element is displayed after the button is clicked)
            WebElement menu = driver.findElement(By.cssSelector(".some-menu-class")); // Update with actual menu locator
            assertTrue(menu.isDisplayed(), "Menu should be displayed after clicking the menu button");

            // Close the browser
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldAnswerWithTrue() {
        // This is a placeholder test
        assertTrue(true);
    }
}
