package PageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SalesforcePageHeader extends BasePage {
    public SalesforcePageHeader(WebDriver driver){
        super(driver);
    }
    private String pageRecordxpath = "//p[@class='slds-truncate' and not(descendant::text()!='<pageName>')]/b[text()='<pageName>']";
    private final By waffle = By.xpath("//div[@class='slds-icon-waffle']");
    private final By searchinput = By.xpath("//input[@class='slds-input']");
    private final By pagerecord = By.xpath("//b[normalize-space()='<pageName>']");
    private final By pageTitle = By.xpath("//div[@class='slds-context-bar__primary navLeft']/..//span[@class='appName slds-context-bar__label-action slds-context-bar__app-name']");

    private String nameTabXpath = "//a[@title='<nameTab>']/parent::*";
    private final String searchInputValueAccount = "Accounts";


    public void homePageClicktoAccounts(){
        wait.until(ExpectedConditions.visibilityOfElementLocated((waffle))).click();
        String salesSearchInput = pageRecordxpath.replace("<pageName>", searchInputValueAccount);
        wait.until(ExpectedConditions.visibilityOfElementLocated((searchinput))).sendKeys("Accounts");
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(salesSearchInput)))).click();
    }
    public SalesforcePageHeader searchInput(String searchInput){
        wait.until(ExpectedConditions.visibilityOfElementLocated((waffle))).click();
        String SearchInput = pageRecordxpath.replace("<pageName>", searchInput);
        wait.until(ExpectedConditions.visibilityOfElementLocated((searchinput))).sendKeys("Sales");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SearchInput))).click();
        return this;
    }


    public SalesforcePageHeader clickTab(String nameTab){
        String replaceTabNameXpath = nameTabXpath.replace("<nameTab>",nameTab);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(replaceTabNameXpath))).click();
        return this;
    }

    public SalesforcePageHeader assertPageTitle(String ExpectedPageTitle){
        String pageTitletext = wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText();
        Assertions.assertEquals(pageTitletext,ExpectedPageTitle);
        return this;
    }}

