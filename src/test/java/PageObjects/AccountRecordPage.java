package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRecordPage extends BasePage {
    private final String accountRecordItemXpath = "//records-record-layout-item[@field-label='<Field>']/..//lightning-formatted-text";
    private final By accountPhoneRecordXpath = By.xpath("//div[@records-recordlayoutitem_recordlayoutitem]/..//a[@lightning-formattedphone_formattedphone]");
    private final String nameTabXpath = "//a[@data-tab-value='<nameTab>']";
    private final String accountAddressXpath = "//span[text()='<Field>']/ancestor::div[@class='slds-form-element slds-hint-parent test-id__output-root slds-form-element_edit slds-form-element_readonly slds-form-element_stacked']//lightning-formatted-address";
    private final String buttonNewOnRelatedListXpath = "//li[@data-target-selection-name='sfdc:StandardButton.<newButton>']";
    public AccountRecordPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountFieldText(String fieldName) {
        String replaceAccountFieldNameXpath = accountRecordItemXpath.replace("<Field>", fieldName);
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(replaceAccountFieldNameXpath))).getText();
    }

    public String getAccountPhoneRecordXpath() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountPhoneRecordXpath)).getText();
    }

    public void clickDetailsRecordPageTab(String nameTabValue) {
        String replacenameTabXpath = nameTabXpath.replace("<nameTab>",nameTabValue);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(replacenameTabXpath))).click();
    }
    public String getAccountAddressText(String fieldName){
        String replaceAccountAddressXpath = accountAddressXpath.replace("<Field>", fieldName);
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(replaceAccountAddressXpath))).getText();
    }
    public void clickNewButtonOnRelatedList(String buttonNewName){
        String replaceButtonNewOnRelatedList = buttonNewOnRelatedListXpath.replace("<newButton>",buttonNewName);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(replaceButtonNewOnRelatedList))).click();
    }
}

