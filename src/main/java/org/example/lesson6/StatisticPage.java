package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StatisticPage extends AbstractPage{

    @FindBy(css = ".b-service-title")
    private WebElement statisticViewHeader;

    public StatisticPage(WebDriver driver) {
        super(driver);
    }

    public WebElement statisticViewHeader() {
        return statisticViewHeader;
    }
}
