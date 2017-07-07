package qwe.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraftPage {

    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[3]/div/div[2]/div[3]/div[2]/div[5]/div[1]/div/div/div[2]/div/div/div/div/div/a")
    public WebElement messageButton;

    @FindBy(xpath = "//*[text()='Отправить']")
    public WebElement sendMessage;

    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[3]/div/div[2]/div[3]/div[2]/div[5]/div[1]/div/div/div[3]/div/div/div/div[2]/a")
    public WebElement backToMain;


    public DraftPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
