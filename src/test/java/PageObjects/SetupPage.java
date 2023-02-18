package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetupPage {
    @FindBy(xpath = "//a[@class='tabHeader slds-context-bar__label-action ']//span[@class='title slds-truncate'][normalize-space()='Home']")
    private WebElement HomePage;
    @FindBy (xpath = "//div[@class='slds-icon-waffle']")
    private WebElement Waffle;
    @FindBy (xpath = "//input[@class='slds-input']")
    private WebElement SearchInput;
    @FindBy (xpath = "//a[@id='Home']//b[contains(text(),'Home')]")
    private WebElement HomePageRecord;

    public void HomePageClick(WebDriver driver){
        Waffle.click();
        SearchInput.sendKeys("Home");
        HomePageRecord.click();
    }
    public void SetupPageInit(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
