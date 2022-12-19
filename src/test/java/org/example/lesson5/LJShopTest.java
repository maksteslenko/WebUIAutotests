package org.example.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LJShopTest extends AbstractTest{

    @Test
    void openLJShop() {
        WebElement shopViewButton = getDriver().findElement(By.cssSelector(".s-nav-rootlink-shop"));
        shopViewButton.click();

        //ассерты
        WebElement shopViewHeader = getDriver().findElement(By.cssSelector(".b-service-title"));
        Assertions.assertEquals("магазин", shopViewHeader.getText().toLowerCase());
        Assertions.assertEquals("https://www.livejournal.com/shop/", getDriver().getCurrentUrl());
    }
}
