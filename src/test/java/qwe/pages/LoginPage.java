package qwe.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "login-username")
    public WebElement loginField;

    @FindBy(css = "form#auth-data input[name='j_password']")
    public WebElement passwordField;

    @FindBy(xpath = "//input[@type='button']")
    public WebElement loginButton;

    @FindBy(id = "add-person")
    public WebElement addPerson;

    @FindBy(id = "person-last-name")
    public WebElement lastName;

    @FindBy(id = "person-first-name")
    public WebElement firstName;

    @FindBy(xpath = "//span[@class=\"ui-button-icon-primary ui-icon yes\"]")
    public WebElement ready;

    @FindBy(id = "logout")
    public WebElement logoutButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
