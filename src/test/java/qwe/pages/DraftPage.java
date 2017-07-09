package qwe.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraftPage {

    @FindBy(xpath = "//*[@class='mail-MessageSnippet js-message-snippet toggles-svgicon-on-important toggles-svgicon-on-unread']")
    public WebElement messageButton;

    @FindBy(xpath = "//*[@class='nb-button _nb-large-action-button _init js-editor-tabfocus-next js-send nb-group-start ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']")
    public WebElement sendMessage;

    @FindBy(xpath = "//*[@class='b-messages__placeholder-item__link']")
    public WebElement backToMain;


    public DraftPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
