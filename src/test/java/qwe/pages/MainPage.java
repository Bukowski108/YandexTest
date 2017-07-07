package qwe.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[3]/div/div[1]/div[3]/div/div/a")
    public WebElement writeMsg;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
