package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor)driver;

        try {
            driver.get("http://127.0.0.1:5500/index.html");
            Thread.sleep(5000);

            String window1 = driver.getWindowHandle(); // get active window id
            js.executeScript("window.open()"); // use js to open new window

            Set<String> currentWindows = driver.getWindowHandles(); // create opened windows array

            String window2 = null; // create new window variable and set value to null for writing id

            for (String window : currentWindows) {
                if (!window.equals(window1)) {
                    window2 = window;
                    break;
                }
            }

            driver.switchTo().window(window2);
            driver.get("http://127.0.0.1:5500/index.html");
            Thread.sleep(5000);
            driver.close();
            driver.switchTo().window(window1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
