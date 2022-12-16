package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

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

        driver.get("https://www.livejournal.com");
        WebElement loginButton = driver.findElement(By.cssSelector(".s-header-item__link--login"));
        loginButton.click();
        WebElement loginInput = driver.findElement(By.id("user"));
        loginInput.click();
        loginInput.sendKeys(loginLJ);
        WebElement passwordInput = driver.findElement(By.id("lj_loginwidget_password"));
        passwordInput.click();
        passwordInput.sendKeys("GB12345webui");
        WebElement loginActionButton = driver.findElement(By.name("action:login"));
        loginActionButton.click();

        //ассерт
        WebElement loginName = driver.findElement(By.cssSelector(".s-nav-item__name"));
        Assertions.assertEquals(loginLJ, loginName.getText().toLowerCase());

        WebElement menu = driver.findElement(By.cssSelector(".s-nav-item__name"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();
        WebElement logoutMenuButton = driver.findElement(By.cssSelector(".s-header-sub-list-item__link--logout"));
        logoutMenuButton.click();

        //ассерт
        WebElement loginButtonAfterLogout = driver.findElement(By.cssSelector(".s-header-item__link--login"));
        Assertions.assertEquals("войти", loginButtonAfterLogout.getText().toLowerCase());

        driver.close();
    }
}
