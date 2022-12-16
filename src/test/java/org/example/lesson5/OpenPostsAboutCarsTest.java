package org.example.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OpenPostsAboutCarsTest extends AbstractTest{

    @Test
    void openPostsAboutCars() {
        WebElement friendsButton = getDriver().findElement(By.cssSelector(".s-header-item__link--friends"));
        friendsButton.click();
        //ожидание подгрузки постов
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement bestoffLJTab = getDriver().findElement(By.cssSelector(".l-flatslide-feed-nav__item:nth-child(1) > .l-flatslide-feed-nav__text"));
        //ассерт
        Assertions.assertEquals("лучшее в жж", bestoffLJTab.getText().toLowerCase());

        bestoffLJTab.click();
        //ожидание подгрузки постов
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement postsAboutAutoButton = getDriver().findElement(By.cssSelector(".aside-menu__item:nth-child(11) > .aside-menu__link"));


        postsAboutAutoButton.click();
        //ожидание подгрузки постов
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //ассерт
        Assertions.assertEquals("https://gb-web-ui.livejournal.com/media/feed/avto", getDriver().getCurrentUrl());
    }
}
