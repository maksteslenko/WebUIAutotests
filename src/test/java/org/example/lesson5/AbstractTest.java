package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

    private static WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeAll
    static void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @BeforeEach
    @Order(1)
    void goTo() {
        driver.get("https://www.livejournal.com");
    }

    @BeforeEach
    @Order(2)
    void login() {
        WebElement loginButton = driver.findElement(By.cssSelector(".s-header-item__link--login"));
        loginButton.click();
        WebElement loginInput = driver.findElement(By.id("user"));
        loginInput.click();
        loginInput.sendKeys("gb_web_ui");
        WebElement passwordInput = driver.findElement(By.id("lj_loginwidget_password"));
        passwordInput.click();
        passwordInput.sendKeys("GB12345webui");
        WebElement loginActionButton = driver.findElement(By.name("action:login"));
        loginActionButton.click();
    }

    @AfterEach
    void logout() {
        WebElement menu = driver.findElement(By.cssSelector(".s-header-item.s-nav-item__name"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();
        WebElement logoutMenuButton = driver.findElement(By.cssSelector(".s-header-sub-list-item__link--logout"));
        logoutMenuButton.click();
    }

    @AfterAll
    static void close() {
        driver.close();
    }
}
