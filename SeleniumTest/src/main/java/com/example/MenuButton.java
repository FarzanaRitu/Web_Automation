package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MenuButton {
    public static void main(String[] args) {
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

            // Optionally, print a message indicating that the menu was clicked
            System.out.println("Menu button clicked successfully!");

            // Close the browser
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
