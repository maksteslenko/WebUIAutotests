package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagesPage extends AbstractPage {

    @FindBy(id = "all_CheckAll_1")
    private WebElement allMessagesCheckbox;

    @FindBy(id = "all_MarkUnread_1")
    private WebElement markMessagesUnreadButton;

    @FindBy(id = "all_MarkRead_1")
    private WebElement markMessagesReadButton;

    @FindBy(css = "#esn_folder_all > span")
    private WebElement countOfUnreadMessages;

    public MessagesPage(WebDriver driver) {
        super(driver);
    }

    public WebElement allMessagesCheckbox() {
        return allMessagesCheckbox;
    }

    public WebElement markMessagesUnreadButton() {
        return markMessagesUnreadButton;
    }

    public WebElement markMessagesReadButton() {
        return markMessagesReadButton;
    }

    public WebElement countOfUnreadMessages() {
        return countOfUnreadMessages;
    }

    public WebElement waitUntilElementToBeClickable(WebElement element) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(1)).until(ExpectedConditions.elementToBeClickable(element));
    }
}
