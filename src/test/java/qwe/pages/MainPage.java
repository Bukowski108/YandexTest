package qwe.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//*[@class='mail-ComposeButton js-left-col-toolbar-compose']")
    public WebElement writeMsg;

    @FindBy(xpath = "//*[@class='mail-User-Picture js-user-picture']")
    public WebElement avatar;

    @FindBy(xpath = "//*[text()='Выход']")
    public WebElement logout;

    @FindBy(xpath = "//*[text()='Карты']")
    public WebElement maps;



    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
