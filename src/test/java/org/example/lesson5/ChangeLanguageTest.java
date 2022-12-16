package org.example.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ChangeLanguageTest extends AbstractTest{

    @Test
    void changeLanguageFromRusToEng() {
        WebElement menu = getDriver().findElement(By.cssSelector(".s-header-item.s-nav-item__name"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(menu).perform();
        WebElement settingsMenuButton = getDriver().findElement(By.cssSelector(".s-header-sub-list-item__link--settings"));
        settingsMenuButton.click();

        WebElement displaySettingsTab = getDriver().findElement(By.cssSelector(".b-menu-item:nth-child(3) > .b-menu-item-link"));
        displaySettingsTab.click();
        Select languageDropdownMenu = new Select(getDriver().findElement(By.id("LJ__Setting__Language_lang")));
        languageDropdownMenu.selectByValue("en_LJ");
        WebElement saveChangesButton = getDriver().findElement(By.cssSelector("#settings_save > .b-flatbutton"));
        saveChangesButton.click();
        // ожидание для просмотра измененного языка страницы
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //ассерт
        WebElement settings = getDriver().findElement(By.cssSelector(".b-service-title"));
        Assertions.assertEquals("viewing options", settings.getText().toLowerCase());

        //без повторной инициализации объекта languageDropdownMenu взаимодействие с элементом не происходит
        languageDropdownMenu = new Select(getDriver().findElement(By.id("LJ__Setting__Language_lang")));
        languageDropdownMenu.selectByValue("ru");
        //без повторной инициализации объекта saveChangesButton взаимодействие с элементом не происходит
        saveChangesButton = getDriver().findElement(By.cssSelector("#settings_save > .b-flatbutton"));
        saveChangesButton.click();
        // ожидание для просмотра измененного языка страницы
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //ассерт
        settings = getDriver().findElement(By.cssSelector(".b-service-title"));
        Assertions.assertEquals("настройки просмотра", settings.getText().toLowerCase());
    }
}
