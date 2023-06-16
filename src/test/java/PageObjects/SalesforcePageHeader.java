package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SalesforcePageHeader extends BasePage {
    public SalesforcePageHeader(WebDriver driver) {
        super(driver);
    }

    private String pageRecordOnListInAppLauncher = "//p[@class='slds-truncate' and not(descendant::text()!='<appName>')]/b[text()='<appName>']";
    private final By waffleAppLauncher = By.xpath("//div[@class='slds-icon-waffle']");
    private final By searchInputInAppLauncher = By.xpath("//input[@class='slds-input']");
    private final By appTitle = By.xpath("//span[@class='appName slds-context-bar__label-action slds-context-bar__app-name']");
    private String nameTabOnSalesforceHeader = "//a[@title='<nameTab>']/parent::*";


    public SalesforcePageHeader searchInputIntoAppLauncher(String searchInputValue) {
        wait.until(ExpectedConditions.visibilityOfElementLocated((waffleAppLauncher))).click();
        String searchInputRecordOnList = pageRecordOnListInAppLauncher.replace("<appName>", searchInputValue);
        wait.until(ExpectedConditions.visibilityOfElementLocated((searchInputInAppLauncher))).sendKeys("Sales");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchInputRecordOnList))).click();
        return this;
    }


    public void clickTabOnSalesforceHeader(String nameTab) {
        String replaceTabNameXpath = nameTabOnSalesforceHeader.replace("<nameTab>", nameTab);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(replaceTabNameXpath))).click();
    }

    public String getPageTitle() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(appTitle)).getText();
    }
}
