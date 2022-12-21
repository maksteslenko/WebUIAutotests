package org.example.lesson5;

import org.example.lesson6.MainMenu;
import org.example.lesson6.MessagesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChangeMessagesReadStatusTest extends AbstractTest{

    @Test
    void changeMessagesReadStatus() {
        MainMenu mainMenu = new MainMenu(getDriver());
        mainMenu.moveToElement(mainMenu.menu());
        mainMenu.messagesMenuButton().click();

        MessagesPage messagesPage = new MessagesPage(getDriver());
        messagesPage.allMessagesCheckbox().click();
        messagesPage.markMessagesUnreadButton().click();
        messagesPage.waitUntilElementToBeClickable(messagesPage.markMessagesReadButton());
        messagesPage.markMessagesReadButton().click();

        //ассерт
        Assertions.assertEquals("", messagesPage.countOfUnreadMessages().getText().toLowerCase());
    }
}
