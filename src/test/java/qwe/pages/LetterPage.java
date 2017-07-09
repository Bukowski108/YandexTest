package qwe.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LetterPage {

    @FindBy(xpath="//*[@class='js-compose-field mail-Bubbles mail-Bubbles-Sms_hidden'][1]")
    public WebElement address;

    @FindBy(xpath="//*[@class='mail-Compose-Field-Input-Controller js-compose-field js-editor-tabfocus-prev']")
    public WebElement theme;

    @FindBy(xpath = "//*[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
    public WebElement message;

    @FindBy(xpath= "//*[text()='Черновики']")
    public WebElement draftButton;

    @FindBy(xpath= "//*[text()='Отправленные']")
    public WebElement sentButton;

    @FindBy(xpath = "//*[@class=' nb-button _nb-small-action-button _init nb-with-s-right-gap js-resolve']")
    public WebElement saveChanges;

    public LetterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
