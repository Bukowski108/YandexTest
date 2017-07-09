package qwe.framework;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qwe.pages.DraftPage;
import qwe.pages.LetterPage;
import qwe.pages.LoginPage;
import qwe.pages.MainPage;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Steps extends BaseTest {


    protected void login(String user, String password) {

        LoginPage loginPage = new LoginPage(driver);
        sendKeys(loginPage.loginField, user, "Введите логин");
        sendKeys(loginPage.passwordField, password, "Введите пароль");
        click(loginPage.loginButton, "Логин");

        MainPage mainPage = new MainPage(driver);
        new WebDriverWait(driver, 5).until(
                ExpectedConditions.elementToBeClickable(mainPage.writeMsg)
        );

    }


    protected void write(String address, String theme, String message) throws InterruptedException, AWTException {
        try {
            MainPage mainPage = new MainPage(driver);
            LetterPage letterPage = new LetterPage(driver);
            click(mainPage.writeMsg, "Написать");
            new WebDriverWait(driver, 5).until(
                    ExpectedConditions.elementToBeClickable(letterPage.address)
            );
            click(letterPage.address, "Кому");
            sendKeys(letterPage.address, address, "Кому");
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            click(letterPage.theme, "Тема письма");
            sendKeys(letterPage.theme, theme, "Тема письма");
            click(letterPage.message, "Поле для ввода письма");
            sendKeys(letterPage.message, message, "Поле для ввода письма");
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    protected void check() throws InterruptedException {
        LetterPage letterPage = new LetterPage(driver);
        DraftPage draftPage = new DraftPage(driver);

        click(letterPage.draftButton, "Черновики");

        if (letterPage.saveChanges.isDisplayed()){
            click(letterPage.saveChanges, "Сохранить и перейти");
        }


        new WebDriverWait(driver, 5).until(
                ExpectedConditions.elementToBeClickable(draftPage.messageButton)
        );
        click(draftPage.messageButton, "Черновое письмо");

        click(draftPage.sendMessage, "Отправить");
        click(letterPage.sentButton, "Отправленные");

        driver.navigate().refresh();
         new WebDriverWait(driver, 5).until(
                ExpectedConditions.elementToBeClickable(letterPage.draftButton)
        );


        click(letterPage.draftButton, "Черновики");

        new WebDriverWait(driver, 5).until(
                ExpectedConditions.elementToBeClickable(draftPage.backToMain)
        );


    }

    protected void logout() throws InterruptedException {
        DraftPage draftPage = new DraftPage(driver);
        MainPage mainPage = new MainPage(driver);
        click(draftPage.backToMain,"Вернуться во входящие");
        click(mainPage.avatar,"Профиль пользователя");
        new WebDriverWait(driver, 5).until(
                ExpectedConditions.elementToBeClickable(mainPage.logout)
        );
        click(mainPage.logout,"Выйти");

    }

}
