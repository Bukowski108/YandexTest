package qwe;


import org.testng.annotations.Test;
import qwe.framework.Steps;
import qwe.pages.DraftPage;
import qwe.pages.MainPage;

import java.awt.*;

import static org.testng.Assert.assertEquals;


public class MatrixBoard extends Steps {


    @Test(priority = 0)
    public void login() throws InterruptedException {
        login("testforpflb", "testforpflb108");
        MainPage mainPage = new MainPage(driver);
        assertEquals(mainPage.writeMsg.isDisplayed(),true);
    }


    @Test(dependsOnMethods = {"login"}, priority = 1)

    public void letsWriteAMessageTest() throws InterruptedException, AWTException {
        write("testforpflb@yandex.ru", "Some theme","Sweet dreams are made of this\n" +
                "Who am I to disagree?\n" +
                "I travel the world\n" +
                "And the seven seas,\n" +
                "Everybody's looking for something");

    }


    @Test(dependsOnMethods = {"login","letsWriteAMessageTest"}, priority = 2)

    public void CheckDraftsTest() throws InterruptedException {
        check();
        DraftPage draftPage = new DraftPage(driver);
        assertEquals(draftPage.backToMain.isDisplayed(),true);
    }

    @Test(dependsOnMethods = {"login","letsWriteAMessageTest","CheckDraftsTest"}, priority = 3)

    public void logoutTest() throws InterruptedException {
        logout();
        MainPage mainPage = new MainPage(driver);
        assertEquals(mainPage.maps.isDisplayed(),true);
        driver.close();
    }



}