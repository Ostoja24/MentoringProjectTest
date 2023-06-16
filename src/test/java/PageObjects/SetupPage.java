package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SetupPage extends BasePage {
    public SetupPage(WebDriver driver){
        super(driver);
    }
    private final By waffle = By.xpath("//div[@class='slds-icon-waffle']");
    private final By searchInput = By.xpath("//input[@class='slds-input']");
    private final By accountPageRecord = By.xpath("//b[normalize-space()='Accounts']");

    private final By accountTab = By.xpath("//one-app-nav-bar-item-root[@text='Accounts");



    public void clickAccountTab(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountTab)).click();
    }}