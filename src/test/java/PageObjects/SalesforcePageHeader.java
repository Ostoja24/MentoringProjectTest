package PageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SalesforcePageHeader extends BasePage {
    public SalesforcePageHeader(WebDriver driver) {
        super(driver);
    }

    private String pageRecordxpath = "//p[@class='slds-truncate' and not(descendant::text()!='<appName>')]/b[text()='<appName>']";
    private final By waffle = By.xpath("//div[@class='slds-icon-waffle']");
    private final By searchinput = By.xpath("//input[@class='slds-input']");
    private final By pagerecord = By.xpath("//b[normalize-space()='<pageName>']");
    private final By appTitle = By.xpath("//span[@class='appName slds-context-bar__label-action slds-context-bar__app-name']");
    private final By appSetupTitle = By.xpath("//div[@class='appName slds-context-bar__label-action slds-context-bar__app-name']");
    private String nameTabXpath = "//a[@title='<nameTab>']/parent::*";
    private final String searchInputValueAccount = "Accounts";


    public void homePageClickToAccounts() {
        wait.until(ExpectedConditions.visibilityOfElementLocated((waffle))).click();
        String salesSearchInput = pageRecordxpath.replace("<appName>", searchInputValueAccount);
        wait.until(ExpectedConditions.visibilityOfElementLocated((searchinput))).sendKeys("Accounts");
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(salesSearchInput)))).click();
    }

    public SalesforcePageHeader searchInput(String searchInput) {
        wait.until(ExpectedConditions.visibilityOfElementLocated((waffle))).click();
        String SearchInput = pageRecordxpath.replace("<appName>", searchInput);
        wait.until(ExpectedConditions.visibilityOfElementLocated((searchinput))).sendKeys("Sales");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SearchInput))).click();
        return this;
    }


    public void clickTab(String nameTab) {
        String replaceTabNameXpath = nameTabXpath.replace("<nameTab>", nameTab);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(replaceTabNameXpath))).click();
    }

    public String getPageTitle() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(appTitle)).getText();
    }
    public String getSetupPageTitle(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(appSetupTitle)).getText();
    }
}
