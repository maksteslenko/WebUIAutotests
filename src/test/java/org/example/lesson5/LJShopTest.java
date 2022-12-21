package org.example.lesson5;

import org.example.lesson6.MainMenu;
import org.example.lesson6.ShopPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LJShopTest extends AbstractTest{

    @Test
    void openLJShop() {
        MainMenu mainMenu = new MainMenu(getDriver());
        mainMenu.shopViewButton().click();

        //ассерты
        ShopPage shopPage = new ShopPage(getDriver());
        Assertions.assertEquals("магазин", shopPage.shopViewHeader().getText().toLowerCase());
        Assertions.assertEquals("https://www.livejournal.com/shop/", getDriver().getCurrentUrl());
    }
}
