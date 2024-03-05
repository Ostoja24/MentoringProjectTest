package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountRecordPage extends BasePage {
    public AccountRecordPage(WebDriver driver) {
        super(driver);
    }
    private final String accountRecordItem = "//records-record-layout-item[@field-label='<Field>']//lightning-formatted-text";
    private final By accountPhoneRecord = By.xpath("//records-record-layout-item[@field-label='Phone']//lightning-formatted-phone//a");
    private final String nameTab = "//a[@data-tab-value='<nameTab>']";
    private final String accountAddress = "//span[text()='<Field>']/ancestor::div[@class='slds-form-element slds-hint-parent test-id__output-root slds-form-element_edit slds-form-element_readonly is-stacked is-stacked-not-editing']//lightning-formatted-address";
    private final String buttonNewOnRelatedList = "//li[@data-target-selection-name='sfdc:StandardButton.<newButton>']";
    private final String contactRecordRelatedList = "//span[@title='Contacts']/ancestor::*//span[text()='<contactName>']";
    private final By saveButtonContact = By.xpath("//button[@name='SaveEdit']");
    private final By toastContactCreationText = By.xpath("//div[@class='toastContent slds-notify__content']/..//a/div");
    private final By contactNumberOnRelatedList = By.xpath("//span[@title='Contacts']/..//span[@class='lds-shrink-none slds-m-right--xx-small']");


    public String getAccountFieldText(String fieldName) {
        String replaceAccountFieldName = accountRecordItem.replace("<Field>", fieldName);
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(replaceAccountFieldName))).getText();
    }

    public String getAccountPhoneOnRecord() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountPhoneRecord)).getText();
    }

    public void clickDetailsRecordPageTab(String nameTabValue) {
        String replaceNameTab = nameTab.replace("<nameTab>",nameTabValue);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(replaceNameTab))).click();
    }
    public String getAccountAddressText(String fieldName){
        String replaceAccountAddress = accountAddress.replace("<Field>", fieldName);
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(replaceAccountAddress))).getText();
    }
    public void clickNewButtonOnRelatedList(String buttonNewName){
        String replaceButtonNewOnRelatedList = buttonNewOnRelatedList.replace("<newButton>",buttonNewName);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(replaceButtonNewOnRelatedList))).click();
    }
    public AccountRecordPage clickRecordButtonOnRelatedList(String contactName){
        String replaceRecordButton = contactRecordRelatedList.replace("<contactName>",contactName);
        scrollToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(replaceRecordButton))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(replaceRecordButton))).click();
        return this;
    }
    public String returnContactNumberonRelatedList(){
        wait.until(ExpectedConditions.elementToBeClickable(contactNumberOnRelatedList));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactNumberOnRelatedList)).getText();
    }
    public String returnToastContactRecordCreation(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(toastContactCreationText)).getText();
    }
    public AccountRecordPage clickSaveContactButton(){
        wait.until(ExpectedConditions.elementToBeClickable(saveButtonContact)).click();
        return this;
    }
}

