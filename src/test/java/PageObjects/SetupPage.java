package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;

public class SetupPage extends BasePage {
    public SetupPage(WebDriver driver){
        super(driver);
    }
    private static final String xpathhomepage = "//a[@class='tabHeader slds-context-bar__label-action ']//span[@class='title slds-truncate'][normalize-space()='Home']";
    @FindBy(xpath = xpathhomepage)
    private WebElement HomePage;
    private static final String xpathwaffle = "//div[@class='slds-icon-waffle']";
    @FindBy (xpath = xpathwaffle)
    private WebElement Waffle;
    private static final String xpathsearchinput = "//input[@class='slds-input']";
    @FindBy (xpath = xpathsearchinput)
    private WebElement SearchInput;
    private static final String xpathaccountpagerecord = "//b[normalize-space()='Accounts']";
    @FindBy (xpath = xpathaccountpagerecord)
    private WebElement AccountPageRecord;

    public void HomePageClick(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathwaffle))).click();
        SearchInput.sendKeys("Accounts");
        AccountPageRecord.click();
    }}