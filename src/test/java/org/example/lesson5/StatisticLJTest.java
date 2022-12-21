package org.example.lesson5;

import org.example.lesson6.MainMenu;
import org.example.lesson6.StatisticPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatisticLJTest extends AbstractTest{

    @Test
    void openStatisticLJ(){
        MainMenu mainMenu = new MainMenu(getDriver());
        mainMenu.moveToElement(mainMenu.menu());
        mainMenu.statisticViewButton().click();

        //ассерт
        StatisticPage statisticPage = new StatisticPage(getDriver());
        Assertions.assertEquals("статистика", statisticPage.statisticViewHeader().getText().toLowerCase());
        Assertions.assertEquals("https://www.livejournal.com/statistics/promo/journal/", getDriver().getCurrentUrl());
    }

}
