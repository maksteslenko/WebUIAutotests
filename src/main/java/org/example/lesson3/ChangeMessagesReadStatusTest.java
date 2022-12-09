package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ChangeMessagesReadStatusTest {
    public static void main(String[] args) {
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
        loginInput.sendKeys("gb_web_ui");
        WebElement passwordInput = driver.findElement(By.id("lj_loginwidget_password"));
        passwordInput.click();
        passwordInput.sendKeys("GB12345webui");
        WebElement loginActionButton = driver.findElement(By.name("action:login"));
        loginActionButton.click();

        WebElement menu = driver.findElement(By.cssSelector(".s-header-item.s-nav-item__name"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();
        WebElement messagesMenuButton = driver.findElement(By.cssSelector(".s-header-sub-list-item__link--messages"));
        messagesMenuButton.click();

        WebElement allMessagesCheckbox = driver.findElement(By.id("all_CheckAll_1"));
        allMessagesCheckbox.click();
        WebElement markMessagesUnreadButton = driver.findElement(By.id("all_MarkUnread_1"));
        markMessagesUnreadButton.click();
        WebElement markMessagesReadButton = driver.findElement(By.id("all_MarkRead_1"));
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.elementToBeClickable(markMessagesReadButton));
        markMessagesReadButton.click();

        menu = driver.findElement(By.cssSelector(".s-header-item.s-nav-item__name"));
        actions.moveToElement(menu).perform();
        WebElement logoutMenuButton = driver.findElement(By.cssSelector(".s-header-sub-list-item__link--logout"));
        logoutMenuButton.click();
        driver.close();
    }
}
