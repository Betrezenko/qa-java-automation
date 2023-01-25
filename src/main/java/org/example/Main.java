package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        try {
            driver.get("https://pagination.js.org/");
            Thread.sleep(2000);

            List<WebElement> elements = driver.findElements(By.xpath("//div[@class='data-container']/ul/li"));
            List<WebElement> pages = driver.findElements(By.xpath("//div[@class='paginationjs-pages']/ul/li"));

            String text = elements.get(5).getText();
            System.out.println(text); //check content of elements

            pages.get(2).click(); //change page
            wait.until(ExpectedConditions.stalenessOf(elements.get(5))); //wait until element content disappears
            elements = driver.findElements(By.xpath("//div[@class='data-container']/ul/li")); //update elements list
            text = elements.get(5).getText();
            System.out.println(text); //check content of elements

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}



















/* import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
public class ChromeTest {
    public WebDriver driver;

    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.quit();
    }
}


public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/iktor/IdeaProjects/chromedriver_mac64(1)/chromedriver");
        WebDriver driver = new ChromeDriver();


    }
}
*/