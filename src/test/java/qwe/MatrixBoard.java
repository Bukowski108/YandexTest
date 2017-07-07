package qwe;


import org.testng.annotations.Test;
import qwe.framework.Steps;

import java.awt.*;


public class MatrixBoard extends Steps {


    @Test(priority = 0)
    public void first() throws InterruptedException {
        login("testforpflb", "testforpflb108");
    }


    @Test(dependsOnMethods = {"first"}, priority = 1)

    public void letsWriteAMessageTest() throws InterruptedException, AWTException {
        write("testforpflb@yandex.ru", "Someone","Sweet dreams are made of this\n" +
                "Who am I to disagree?\n" +
                "I travel the world\n" +
                "And the seven seas,\n" +
                "Everybody's looking for something");

    }


    @Test(dependsOnMethods = {"first"}, priority = 2)

    public void CheckDraftsTest() throws InterruptedException {
        check();

    }



}