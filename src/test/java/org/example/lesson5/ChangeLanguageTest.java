package org.example.lesson5;

import org.example.lesson6.MainMenu;
import org.example.lesson6.SettingsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChangeLanguageTest extends AbstractTest{

    @Test
    void changeLanguageFromRusToEng() {

        MainMenu mainMenu = new MainMenu(getDriver());
        mainMenu.moveToElement(mainMenu.menu());
        mainMenu.settingsMenuButton().click();

        SettingsPage settingsPage = new SettingsPage(getDriver());
        settingsPage.displaySettingsTab().click();
        settingsPage.languageDropdownMenu().selectByValue("en_LJ");
        settingsPage.saveChangesButton().click();

        //ассерт
        Assertions.assertEquals("viewing options", settingsPage.settings().getText().toLowerCase());

        settingsPage.languageDropdownMenu().selectByValue("ru");
        settingsPage.saveChangesButton().click();

        //ассерт
        Assertions.assertEquals("настройки просмотра", settingsPage.settings().getText().toLowerCase());
    }
}
