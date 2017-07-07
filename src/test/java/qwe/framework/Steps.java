package qwe.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import qwe.Constans;
import qwe.pages.LoginPage;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class Steps extends BaseTest {

    public static WebDriver driver;


    protected void login(String user, String password) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Constans.BASE_URL);

        LoginPage loginPage = new LoginPage(driver);
        sendKeys(loginPage.loginField, user, "Введите логин");
        sendKeys(loginPage.passwordField, password, "Введите пароль");
        click(loginPage.loginButton, "Логин");

        new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(loginPage.writeMsg)
        );


    }


    protected void write(String address, String theme, String message ) throws InterruptedException, AWTException {
        try {
        LoginPage loginPage = new LoginPage(driver);
        click(loginPage.writeMsg, "Написать");
        click(loginPage.address, "Кому");
        Thread.sleep(500);
        sendKeys(loginPage.address, address, "Кому");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        click(loginPage.theme, "Тема письма");
        Thread.sleep(500);
        sendKeys(loginPage.theme, theme, "Тема письма");
        Thread.sleep(500);
        click(loginPage.message, "Поле для ввода письма");
        sendKeys(loginPage.message, message, "Поле для ввода письма");
        Thread.sleep(1000);
        } catch (AWTException e) {

            e.printStackTrace();

        }
    }

    protected void check() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        click(loginPage.draftButton, "Черновики");

        if ( loginPage.saveChanges.isDisplayed()) {
            click(loginPage.saveChanges, "Сохранить и перейти");
        }

        click(loginPage.messageButton, "Черновое письмо");
        click(loginPage.sendMessage, "Отправить");
        Thread.sleep(3000);
        driver.close();

    }

}
