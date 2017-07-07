package qwe.framework;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import qwe.Constans;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver; {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Constans.BASE_URL);
    };

    private static final Logger log = Logger.getLogger(BaseTest.class);

    protected void click(WebElement elm, String elmName) {

        log.info("Делаю клик на элемент: " + elmName);
        elm.click();
    }

    protected void sendKeys(WebElement elm, String inputText, String elmName) {
        log.info("Ввожу текст: " + inputText + " в элемент " + elmName);
        elm.sendKeys(inputText);
    }


}
