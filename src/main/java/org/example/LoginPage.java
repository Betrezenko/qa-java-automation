package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    WebDriver driver = new ChromeDriver();

    WebElement loginInput = driver.findElement(By.id("login"));
    WebElement passInput = driver.findElement(By.id("password"));
    WebElement enter = driver.findElement(By.id("enter"));

    public void login(String login, String pass) {
        loginInput.sendKeys(login);
        passInput.sendKeys(pass);
        enter.click();
    }

}
