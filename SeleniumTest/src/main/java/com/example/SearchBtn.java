package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchBtn {
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

            // Locate the search input box using the id attribute
            WebElement searchBox = driver.findElement(By.id("inlineFormInputGroupUsername1"));

            // Enter "laptop" into the search box
            searchBox.sendKeys("laptop");

            // Submit the search (if there's no dedicated search button, you can simulate pressing ENTER)
            searchBox.submit();

            // Optionally, print a message indicating that the search was successful
            System.out.println("Search for 'laptop' completed!");

            // Close the browser
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
