package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));



        try {
            driver.get("http://127.0.0.1:5500/index.html");
            Thread.sleep(5000);

            WebElement element1 = driver.findElement(By.id("a")); // alert
            WebElement element2 = driver.findElement(By.id("b")); // prompt
            WebElement element3 = driver.findElement(By.id("c")); // confirm

            // click on Link 1 to call alert
            element1.click();
            // Alert alert = driver.switchTo().alert(); -- don't know alert is showed or not
            Alert alert = wait.until(alertIsPresent());
            alert.accept();

            // click on Link 2 to call prompt, send text and accept
            element2.click();
            Alert prompt = wait.until(alertIsPresent());
            prompt.sendKeys("Super!");
            prompt.accept();

            Alert alert2 = wait.until(alertIsPresent());
            Thread.sleep(2000);
            alert2.accept();

            // click on Link 3 to call confirm window
            element3.click();
            Alert confirm = wait.until(alertIsPresent());
            confirm.dismiss();


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
