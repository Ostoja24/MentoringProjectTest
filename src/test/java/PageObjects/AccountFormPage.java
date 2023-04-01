package PageObjects;

import data.DataClass;
import org.openqa.selenium.*;
import org.json.JSONObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.FileNotFoundException;


public class AccountFormPage extends BasePage {

    private final By accountIndustryField = By.xpath("//label[text()='Industry']/..//button[@role='combobox']");
    private final By accounttab = By.xpath("//span[normalize-space()='Accounts']");
    private final By accountnamelement = By.xpath("//input[@name='Name']");
    private final By accounttypefield = By.xpath("//label[text()='Type']/..//button[@role='combobox']");
    private final By accountNameTitle = By.xpath("//lightning-formatted-text[@class='custom-truncate']");
    private String accountTypefield = "//lightning-base-combobox-item[@data-value='<typeName>']";
    private String accountIndustryPicklistOption = "//lightning-base-combobox-item[@data-value='<industryName>']";
    private String accountPriorityPicklistOption = "//lightning-base-combobox-item[@data-value='<priorityName>']";
    private String accountRatingPicklistOption = "//lightning-base-combobox-item[@data-value='<ratingName>']";
    private String accountSLAPicklistOption = "//lightning-base-combobox-item[@data-value='<SLAName>']";
    private String AccountRecordURL;
    private final By accountCustomerField = By.xpath("//label[text()='Customer Priority']/..//button[@role='combobox']");
    private final By billingZipfield = By.xpath("//label[text()='Billing Zip/Postal Code']/..//input[@name='postalCode']");
    private final By SaveAccountRecord = By.xpath("//button[@name='SaveEdit']");
    private final By accountRatingField = By.xpath("//label[text()='Rating']/..//button[@role='combobox']");

    private final By accountNewButton = By.xpath("//div[@title='New']");
    private final By billingStreetField = By.xpath("//records-record-layout-item[@field-label='Billing Address']//textarea[@name='street']");
    private final By billingCityField = By.xpath("//label[text()='Billing City']/..//input[@name='city']");
    private final By accountSLAField = By.xpath("//label[text()='SLA']/..//button[@role='combobox']");
    private final By forceVisualMessageQueue = By.xpath("//div[@class='forceVisualMessageQueue']/..//span[@data-aura-class='forceActionsText']");
    private final By accountPhoneNumber = By.xpath("//label[text()='Phone']/..//input[@name='Phone']");
    private final By shippingStreetField = By.xpath("//label[text()='Shipping Street']/..//textarea[@name='street']");
    private final By shippingCityField = By.xpath("//label[text()='Shipping City']/..//input[@name='city']");
    private final By shippingZipfield = By.xpath("//label[text()='Shipping Zip/Postal Code']/..//input[@name='postalCode']");
    private final By descriptionfield = By.xpath("//label[text()='Description']/..//textarea[@class='slds-textarea']");
    public AccountFormPage(WebDriver driver) {
        super(driver);
    }
    private static double RandomNumber;


    public String AccountURLJSON(String ACCOUNT_INFORMATION) throws FileNotFoundException {
        DataClass dataclass = new DataClass();
        JSONObject jsonURLAccount = new JSONObject(dataclass.getAccountFormInfo(ACCOUNT_INFORMATION));
        AccountRecordURL = jsonURLAccount.getString("AccountRecordsURL");
        return AccountRecordURL;
    }


    public AccountFormPage newAccountForm() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountNewButton)).click();
        return this;
    }


    public AccountFormPage submitNewAccount() {
        driver.findElement(SaveAccountRecord).click();
        return this;
    }

    public AccountFormPage putkeysAccountName(String accountName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountnamelement)).sendKeys(accountName);
        return this;
    }

    public AccountFormPage putkeysAccountType(String AccountType) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accounttypefield)).click();
        String accountTypeOptionXpath = accountTypefield.replace("<typeName>", AccountType);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(accountTypeOptionXpath))).click();
        return this;
    }

    public AccountFormPage putkeysAccountIndustry(String AccountIndustry) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountIndustryField)).click();
        String accountIndustryOptionXpath = accountIndustryPicklistOption.replace("<industryName>", AccountIndustry);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(accountIndustryOptionXpath))).click();
        return this;
    }

    public AccountFormPage putkeysAccountCustomerPriority(String AccountCustomerPriority) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountCustomerField)).click();
        String accountPriorityOptionXpath = accountPriorityPicklistOption.replace("<priorityName>", AccountCustomerPriority);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(accountPriorityOptionXpath))).click();
        return this;
    }

    public AccountFormPage putkeysBillingStreet(String BillingStreet) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(billingStreetField)).sendKeys(BillingStreet);
        return this;
    }

    public AccountFormPage putkeysBillingCity(String BillingCity) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(billingCityField)).sendKeys(BillingCity);
        return this;
    }

    public AccountFormPage putkeysAccountRatingValue(String accountRatingValue) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountRatingField)).click();
        String accountRatingOptionXpath = accountRatingPicklistOption.replace("<ratingName>", accountRatingValue);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(accountRatingOptionXpath))).click();
        return this;
    }

    public AccountFormPage putkeysBillingZipValue(String billingZipValue) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(billingZipfield)).sendKeys(billingZipValue);
        return this;
    }

    public AccountFormPage putkeysSLAValue(String accountSLAValue) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountSLAField)).click();
        String accountRatingOptionXpath = accountSLAPicklistOption.replace("<SLAName>", accountSLAValue);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(accountRatingOptionXpath))).click();
        return this;
    }
    public AccountFormPage putkeysPhoneNumber(String accountPhoneNumberValue) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountPhoneNumber)).sendKeys(accountPhoneNumberValue);
        return this;
    }
    public String getAccountNameTitleField(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountNameTitle)).getText();
    }

    public String accountToastText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(forceVisualMessageQueue)).getText();
    }
    public AccountFormPage putkeysShippingStreet(String shippingStreet) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(shippingStreetField)).sendKeys(shippingStreet);
        return this;
    }

    public AccountFormPage putkeysShippingCity(String shippingCity) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(shippingCityField)).sendKeys(shippingCity);
        return this;
    }

    public AccountFormPage putkeysShippingZip(String ShippingZipValue) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(shippingZipfield)).sendKeys(ShippingZipValue);
        return this;
    }
    public AccountFormPage putDescription(String DescriptionValue){
        wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionfield)).sendKeys(DescriptionValue);
        return this;
    }

}


