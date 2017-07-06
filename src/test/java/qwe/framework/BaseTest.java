package qwe.framework;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import sun.rmi.runtime.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import org.apache.log4j.Logger;

public class BaseTest {

    private static final Logger log = Logger.getLogger(BaseTest.class);

    protected void click(WebElement elm, String elmName) {
        log.info("Делаю клик на элемент " + elmName);
        elm.click();
    }

    protected void sendKeys(WebElement elm, String inputText, String elmName) {
        log.info("Ввожу текст " + inputText + " в элемент " + elmName);
        elm.sendKeys(inputText);
    }


}
