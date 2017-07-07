package qwe;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qwe.framework.BaseTest;
import qwe.framework.Steps;
import qwe.pages.LoginPage;

import java.awt.*;
import java.util.concurrent.TimeUnit;


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