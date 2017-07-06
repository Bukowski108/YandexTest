package qwe.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import qwe.Constans;
import qwe.pages.LoginPage;

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
        click(loginPage.loginButton, "Залогиниться");

        new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(loginPage.addPerson)
        );


    }


    protected void createPerson(String firstName, String lastName) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        click(loginPage.addPerson, "Добавить пользователя");
        click(loginPage.lastName, "Фамилия");
        sendKeys(loginPage.lastName, lastName, "Введите фамилию");
        click(loginPage.firstName, "Имя");
        sendKeys(loginPage.firstName, firstName, "Введите имя");
        click(loginPage.ready, "Готово");
        Thread.sleep(3000);
    }


    protected void logout() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        click(loginPage.logoutButton, "Выйти");
        Thread.sleep(3000);
        driver.close();
    }
}
