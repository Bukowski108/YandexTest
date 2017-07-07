package qwe.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LetterPage {

    @FindBy(xpath="//*[@id=\"nb-1\"]/body/div[2]/div[3]/div/div[2]/div[3]/div[2]/div[5]/div/div[1]/div[2]/div[1]/div/div[1]/label/div[3]/div")
    public WebElement address;

    @FindBy(xpath="//*[@id=\"nb-1\"]/body/div[2]/div[3]/div/div[2]/div[3]/div[2]/div[5]/div/div[1]/div[2]/div[1]/div/label/div[3]/input")
    public WebElement theme;

    @FindBy(xpath = "//*[@id=\"cke_1_contents\"]/div")
    public WebElement message;

    @FindBy(xpath= "//*[@id=\"nb-1\"]/body/div[2]/div[3]/div/div[2]/div[2]/div[2]/div/div[1]/a[5]")
    public WebElement draftButton;

    @FindBy(xpath = "//*[@id=\"nb-21\"]/div/div[2]/button[1]")
    public WebElement saveChanges;

    public LetterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
