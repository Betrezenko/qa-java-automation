package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("http://127.0.0.1:5500/index.html");
            Thread.sleep(5000);

            LoginPage lg = new LoginPage(); // new class example
            lg.login("admin", "admin"); // login method from class LoginPage

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
