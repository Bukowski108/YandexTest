package qwe;


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

import java.util.concurrent.TimeUnit;


public class MatrixBoard extends Steps {


    @Test(priority = 0)
    public void first() throws InterruptedException {
        login("admin", "admin");
    }


    @Test(dependsOnMethods = {"first"}, priority = 1)

    public void secondTest() throws InterruptedException {
        createPerson("Spider", "Man");

    }


    @Test(dependsOnMethods = {"first"}, priority = 2)

    public void logoutTest() throws InterruptedException {
        logout();
    }


}