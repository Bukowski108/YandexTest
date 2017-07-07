package qwe.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "nb-1")
    public WebElement loginField;

    @FindBy(id = "nb-6")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@class=' nb-button _nb-action-button nb-group-start']")
    public WebElement loginButton;


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
