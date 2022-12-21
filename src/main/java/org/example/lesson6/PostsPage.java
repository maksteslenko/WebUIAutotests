package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostsPage extends AbstractPage {

    @FindBy(css = ".l-flatslide-feed-nav__item:nth-child(1) > .l-flatslide-feed-nav__text")
    private WebElement bestoffLJTab;

    @FindBy(css = ".aside-menu__item:nth-child(11) > .aside-menu__link")
    private WebElement postsAboutAutoButton;

    public PostsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement bestoffLJTab() {
        return bestoffLJTab;
    }

    public WebElement postsAboutAutoButton() {
        return postsAboutAutoButton;
    }
}
