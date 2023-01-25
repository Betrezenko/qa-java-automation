package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");
            Thread.sleep(2000);

            WebElement element = driver.findElement(By.id("draggable"));
            WebElement element2 = driver.findElement(By.id("droppable"));

            Actions actions = new Actions(driver);
            /* Drag and Drop mechanism
            actions
                    .moveToElement(element)
                    .clickAndHold()
                    .moveToElement(element2)
                    .release()
                    .build()
                    .perform();
            */
            actions.dragAndDrop(element, element2);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            Thread.sleep(15000);
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