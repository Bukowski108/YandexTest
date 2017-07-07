package qwe.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qwe.Constans;
import qwe.pages.DraftPage;
import qwe.pages.LetterPage;
import qwe.pages.LoginPage;
import qwe.pages.MainPage;

import java.awt.*;
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

        MainPage mainPage = new MainPage(driver);
        new WebDriverWait(driver, 10).until(

                ExpectedConditions.elementToBeClickable(mainPage.writeMsg)
        );


    }


    protected void write(String address, String theme, String message) throws InterruptedException, AWTException {
        try {
            MainPage mainPage = new MainPage(driver);
            LetterPage letterPage = new LetterPage(driver);
            click(mainPage.writeMsg, "Написать");
            click(letterPage.address, "Кому");
            Thread.sleep(500);
            sendKeys(letterPage.address, address, "Кому");
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            click(letterPage.theme, "Тема письма");
            Thread.sleep(500);
            sendKeys(letterPage.theme, theme, "Тема письма");
            Thread.sleep(500);
            click(letterPage.message, "Поле для ввода письма");
            sendKeys(letterPage.message, message, "Поле для ввода письма");
            Thread.sleep(1000);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    protected void check() throws InterruptedException {
        LetterPage letterPage = new LetterPage(driver);
        DraftPage draftPage = new DraftPage(driver);

        click(letterPage.draftButton, "Черновики");

        if (letterPage.saveChanges.isDisplayed()) {
            click(letterPage.saveChanges, "Сохранить и перейти");
        }

        click(draftPage.messageButton, "Черновое письмо");
        click(draftPage.sendMessage, "Отправить");
        Thread.sleep(3000);
        driver.close();

    }

}
