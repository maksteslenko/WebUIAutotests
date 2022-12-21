package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SettingsPage extends AbstractPage{

    @FindBy(css = ".b-menu-item:nth-child(3) > .b-menu-item-link")
    private WebElement displaySettingsTab;

    @FindBy(id = "LJ__Setting__Language_lang")
    private WebElement languageDropdownMenu;

    @FindBy(css = "#settings_save > .b-flatbutton")
    private WebElement saveChangesButton;

    @FindBy(css = ".b-service-title")
    private WebElement settings;



    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement displaySettingsTab() {
        return displaySettingsTab;
    }

    public Select languageDropdownMenu() {
        return new Select(languageDropdownMenu);
    }

    public WebElement saveChangesButton() {
        return saveChangesButton;
    }

    public WebElement settings() {
        return settings;
    }
}
