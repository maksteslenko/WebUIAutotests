package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class OpenPostsAboutCarsTest {
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

        WebElement friendsButton = driver.findElement(By.cssSelector(".s-header-item__link--friends"));
        friendsButton.click();
        //ожидание подгрузки постов
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement bestoffLJTab = driver.findElement(By.cssSelector(".l-flatslide-feed-nav__item:nth-child(1) > .l-flatslide-feed-nav__text"));
        bestoffLJTab.click();
        //ожидание подгрузки постов
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement postsAboutAutoButton = driver.findElement(By.cssSelector(".aside-menu__item:nth-child(11) > .aside-menu__link"));
        postsAboutAutoButton.click();
        //ожидание подгрузки постов
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement menu = driver.findElement(By.cssSelector(".s-header-item.s-nav-item__name"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();
        WebElement logoutMenuButton = driver.findElement(By.cssSelector(".s-header-sub-list-item__link--logout"));
        logoutMenuButton.click();
        driver.close();
    }
}
