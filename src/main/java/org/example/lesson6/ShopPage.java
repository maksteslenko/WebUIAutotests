package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends AbstractPage{

    @FindBy(css = ".b-service-title")
    private WebElement shopViewHeader;

    public ShopPage(WebDriver driver) {
        super(driver);
    }

    public WebElement shopViewHeader() {
        return shopViewHeader;
    }
}
