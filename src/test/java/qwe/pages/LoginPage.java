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

    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[3]/div/div[1]/div[3]/div/div/a")
    public WebElement writeMsg;

    @FindBy(xpath="//*[@id=\"nb-1\"]/body/div[2]/div[3]/div/div[2]/div[3]/div[2]/div[5]/div/div[1]/div[2]/div[1]/div/div[1]/label/div[3]/div")
    public WebElement address;

    @FindBy(xpath="//*[@id=\"ui-id-55\"]/li[1]")
    public WebElement tap;

    @FindBy(xpath="//*[@id=\"nb-1\"]/body/div[2]/div[3]/div/div[2]/div[3]/div[2]/div[5]/div/div[1]/div[2]/div[1]/div/label/div[3]/input")
    public WebElement theme;

    @FindBy(xpath = "//*[@id=\"cke_1_contents\"]/div")
    public WebElement message;

    @FindBy(xpath= "//*[@id=\"nb-1\"]/body/div[2]/div[3]/div/div[2]/div[2]/div[2]/div/div[1]/a[5]")
    public WebElement draftButton;

    @FindBy(xpath = "//*[@id=\"nb-21\"]/div/div[2]/button[1]")
    public WebElement saveChanges;

    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[3]/div/div[2]/div[3]/div[2]/div[5]/div[1]/div/div/div[2]/div/div/div/div/div/a")
    public WebElement messageButton;

    @FindBy(xpath = "//*[@id=\"nb-32\"]")
    public WebElement sendMessage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
