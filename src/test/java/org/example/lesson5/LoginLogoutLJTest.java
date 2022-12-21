package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.lesson6.MainMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LoginLogoutLJTest {

    private String loginLJ = "gb_web_ui";

    @Test
    void loginLogout() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        MainMenu mainMenu = new MainMenu(driver);
        driver.get("https://www.livejournal.com");
        mainMenu.loginButton().click();
        mainMenu.loginInput().click();
        mainMenu.loginInput().sendKeys("gb_web_ui");
        mainMenu.passwordInput().click();
        mainMenu.passwordInput().sendKeys("GB12345webui");
        mainMenu.loginActionButton().click();
        //ассерт
        Assertions.assertEquals(loginLJ, mainMenu.loginName().getText().toLowerCase());

        mainMenu.moveToElement(mainMenu.menu());
        mainMenu.logoutMenuButton().click();
        //ассерт
        Assertions.assertEquals("войти", mainMenu.loginButton().getText().toLowerCase());
        driver.close();
    }
}
