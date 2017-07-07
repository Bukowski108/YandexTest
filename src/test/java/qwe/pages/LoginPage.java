package qwe.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(css = "#nb-1")
    public WebElement loginField;

    @FindBy(css = "#nb-6")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"js\"]/body/div[1]/div[1]/div[1]/form/div[4]/span/button")
    public WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
