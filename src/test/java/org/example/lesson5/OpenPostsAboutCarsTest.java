package org.example.lesson5;

import org.example.lesson6.MainMenu;
import org.example.lesson6.PostsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OpenPostsAboutCarsTest extends AbstractTest{

    @Test
    void openPostsAboutCars() {
        MainMenu mainMenu = new MainMenu(getDriver());
        mainMenu.friendsButton().click();

        PostsPage postsPage = new PostsPage(getDriver());
        //ассерт
        Assertions.assertEquals("лучшее в жж", postsPage.bestoffLJTab().getText().toLowerCase());

        postsPage.bestoffLJTab().click();
        postsPage.postsAboutAutoButton().click();

        //ассерт
        Assertions.assertEquals("https://gb-web-ui.livejournal.com/media/feed/avto", getDriver().getCurrentUrl());
    }
}
