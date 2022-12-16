package org.example.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class StatisticLJTest extends AbstractTest{

    @Test
    void openStatisticLJ(){
        WebElement menu = getDriver().findElement(By.cssSelector(".s-header-item.s-nav-item__name"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(menu).perform();
        WebElement logoutMenuButton = getDriver().findElement(By.cssSelector(".s-header-sub-list-item__link--statistics"));
        logoutMenuButton.click();

        //ассерт
        Assertions.assertEquals("https://www.livejournal.com/statistics/promo/journal/", getDriver().getCurrentUrl());
    }

}
