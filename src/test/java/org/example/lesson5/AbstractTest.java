package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.lesson6.MainMenu;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
        getDriver().get("https://www.livejournal.com");
    }

    @BeforeEach
    @Order(2)
    void login() {
        MainMenu mainMenu = new MainMenu(getDriver());
        mainMenu.loginButton().click();
        mainMenu.loginInput().click();
        mainMenu.loginInput().sendKeys("gb_web_ui");
        mainMenu.passwordInput().click();
        mainMenu.passwordInput().sendKeys("GB12345webui");
        mainMenu.loginActionButton().click();
    }

    @AfterEach
    void logout() {
        MainMenu mainMenu = new MainMenu(getDriver());
        mainMenu.moveToElement(mainMenu.menu());
        mainMenu.logoutMenuButton().click();
    }

    @AfterAll
    static void close() {
        driver.close();
    }
}
