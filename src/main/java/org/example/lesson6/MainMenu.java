package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainMenu extends AbstractPage{

    @FindBy(css = ".s-header-item__link--login")
    private WebElement loginButton;

    @FindBy(id = "lj_loginwidget_password")
    private WebElement passwordInput;

    @FindBy(name = "action:login")
    private WebElement loginActionButton;

    @FindBy(css = ".s-header-item.s-nav-item__name")
    private WebElement menu;

    @FindBy(css = ".s-header-sub-list-item__link--logout")
    private WebElement logoutMenuButton;

    @FindBy(id = "user")
    private WebElement loginInput;

    @FindBy(css = ".s-header-sub-list-item__link--settings")
    private WebElement settingsMenuButton;

    @FindBy(css = ".s-header-sub-list-item__link--messages")
    private WebElement messagesMenuButton;

    @FindBy(css = ".s-nav-rootlink-shop")
    private WebElement shopViewButton;

    @FindBy(css = ".s-header-sub-list-item__link--statistics")
    private WebElement statisticViewButton;

    @FindBy(css = ".s-nav-item__name")
    private WebElement loginName;

    @FindBy(css = ".s-header-item__link--friends")
    private WebElement friendsButton;

    public MainMenu(WebDriver driver) {
        super(driver);
    }

    public void moveToElement(WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
    }

    public WebElement loginButton() {
        return loginButton;
    }

    public WebElement loginInput() {
        return loginInput;
    }

    public WebElement passwordInput() {
        return passwordInput;
    }

    public WebElement loginActionButton() {
        return loginActionButton;
    }

    public WebElement menu() {
        return menu;
    }

    public WebElement logoutMenuButton() {
        return logoutMenuButton;
    }

    public WebElement settingsMenuButton() {
        return settingsMenuButton;
    }

    public WebElement messagesMenuButton() {
        return messagesMenuButton;
    }

    public WebElement shopViewButton() {
        return shopViewButton;
    }

    public WebElement statisticViewButton() {
        return statisticViewButton;
    }

    public WebElement loginName() {
        return loginName;
    }

    public WebElement friendsButton() {
        return friendsButton;
    }
}
