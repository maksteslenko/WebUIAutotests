package org.example.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChangeMessagesReadStatusTest extends AbstractTest{

    @Test
    void changeMessagesReadStatus() {
        WebElement menu = getDriver().findElement(By.cssSelector(".s-header-item.s-nav-item__name"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(menu).perform();
        WebElement messagesMenuButton = getDriver().findElement(By.cssSelector(".s-header-sub-list-item__link--messages"));
        messagesMenuButton.click();

        WebElement allMessagesCheckbox = getDriver().findElement(By.id("all_CheckAll_1"));
        allMessagesCheckbox.click();
        WebElement markMessagesUnreadButton = getDriver().findElement(By.id("all_MarkUnread_1"));
        markMessagesUnreadButton.click();
        WebElement markMessagesReadButton = getDriver().findElement(By.id("all_MarkRead_1"));
        new WebDriverWait(getDriver(), Duration.ofSeconds(1)).until(ExpectedConditions.elementToBeClickable(markMessagesReadButton));
        markMessagesReadButton.click();

        //ассерт
        WebElement countOfUnreadMessages = getDriver().findElement(By.cssSelector("#esn_folder_all > span"));
        Assertions.assertEquals("", countOfUnreadMessages.getText().toLowerCase());
    }
}
