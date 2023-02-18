package PageObjects;

import org.json.JSONTokener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class AccountFormPage {
    private final static String ACCOUNT_INFORMATION = "C:\\Users\\tomcz\\IdeaProjects\\MentoringProjectTest\\src\\test\\java\\data\\AccountsInfo.json";
    private String AccountName;
    private String AccountType;
    private String AccountRating;
    private String AccountIndustry;
    private String AccountCustomerPriority;
    private String AccountSLA;
    private String BillingStreet;
    private String BillingCity;
    private String BillingZip;

    @FindBy(xpath = "//span[@class='slds-truncate'][normalize-space()='Accounts']")
    private static WebElement AccountTab;

    @FindBy(xpath = "//a[@class='tabHeader slds-context-bar__label-action ']//span[@class='title slds-truncate'][normalize-space()='Home']")
    private WebElement HomePage;
    @FindBy (xpath = "//div[@class='slds-icon-waffle']")
    private WebElement Waffle;
    @FindBy (xpath = "//input[@class='slds-input']")
    private WebElement SearchInput;
    @FindBy (xpath = "//a[@id='Home']//b[contains(text(),'Home')]")
    private WebElement HomePageRecord;

    @FindBy(xpath = "//a[@title='New']")
    private WebElement AccountNewButton;
    @FindBy(name = "Name")
    private WebElement AccountNameElement;

    @FindBy(xpath = "//*[@id='combobox-button-216']")
    private WebElement AccountTypeField;

    @FindBy(xpath = "//*[@id='combobox-button-183']")
    private WebElement AccountRatingField;

    @FindBy(xpath = "//*[@id='combobox-button-233]")
    private WebElement AccountIndustryField;

    @FindBy(id = "combobox-button-270")
    private WebElement AccountCustomerField;

    @FindBy(id = "combobox-button-278")
    private WebElement AccountSLAField;
    @FindBy(name = "street")
    private WebElement BillingStreetField;
    @FindBy(name = "city")
    private WebElement BillingCityField;
    @FindBy(name = "postalCode")
    private WebElement BillingZipField;

    @FindBy(name = "SaveEdit")
    private WebElement SaveAccountRecordButton;

    @FindBy(xpath = "//lightning-formatted-text[@class='custom-truncate']")
    private WebElement AccountNameTitleField;

    public JSONTokener getAccountFormInfo() throws FileNotFoundException {
        return new JSONTokener(new FileReader(ACCOUNT_INFORMATION));
    }

    public void AccountPageInit(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void AccountInfoJSON() throws FileNotFoundException {
        JSONObject jsonAccount = new JSONObject(getAccountFormInfo());
        AccountName = jsonAccount.getString("AccountName");
        AccountType = jsonAccount.getString("AccountType");
        AccountIndustry = jsonAccount.getString("AccountIndustry");
        AccountCustomerPriority = jsonAccount.getString("AccountCustomerPriority");
        AccountSLA = jsonAccount.getString("AccountSLA");
        BillingStreet = jsonAccount.getString("BillingStreet");
        BillingCity = jsonAccount.getString("BillingCity");
        BillingZip = jsonAccount.getString("BillingZip");
    }


    public void newAccountForm(WebDriver driver) {
        AccountNewButton.click();
    }

    public void editSavedAccount(WebDriver driver) {
    }

    public void submitNewAccount(WebDriver driver) {


    }

    public String getAccountName() {
        return AccountName;
    }

    public String getAccountType() {
        return AccountType;
    }

    public String getAccountRating() {
        return AccountRating;
    }

    public String getAccountIndustry() {
        return AccountIndustry;
    }

    public String getAccountCustomerPriority() {
        return AccountCustomerPriority;
    }

    public String getAccountSLA() {
        return AccountSLA;
    }

    public String getBillingStreet() {
        return BillingStreet;
    }

    public String getBillingCity() {
        return BillingCity;
    }

    public String getBillingZip() {
        return BillingZip;
    }

    public void putkeysAccountName(String AccountName) {
        AccountNameElement.sendKeys(AccountName);
    }

    public void putkeysAccountType(String AccountType) {
        AccountTypeField.sendKeys(AccountType);
    }

    public void putkeysAccountIndustry(String AccountIndustry) {
        AccountIndustryField.sendKeys(AccountIndustry);
    }

    public void putkeysAccountCustomerPriority(String AccountCustomerPriority) {
        AccountCustomerField.sendKeys(AccountCustomerPriority);
    }

    public void putkeysBillingStreet(String BillingStreet) {
        BillingStreetField.sendKeys(BillingStreet);
    }

    public void putkeysBillingCity(String BillingCity) {
        BillingCityField.sendKeys(BillingCity);
    }

    public void putkeysBillingZip(String BillingZip) {
        BillingZipField.sendKeys(BillingZip);
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public void setAccountType(String accountType) {
        AccountType = accountType;
    }

    public void setAccountRating(String accountRating) {
        AccountRating = accountRating;
    }

    public void setAccountIndustry(String accountIndustry) {
        AccountIndustry = accountIndustry;
    }

    public void setAccountCustomerPriority(String accountCustomerPriority) {
        AccountCustomerPriority = accountCustomerPriority;
    }

    public void setAccountSLA(String accountSLA) {
        AccountSLA = accountSLA;
    }

    public void setBillingStreet(String billingStreet) {
        BillingStreet = billingStreet;
    }

    public void setBillingCity(String billingCity) {
        BillingCity = billingCity;
    }

    public void setBillingZip(String billingZip) {
        BillingZip = billingZip;
    }


    public static WebElement getAccountTab() {
        return AccountTab;
    }

    public WebElement getAccountNameTitleField() {
        return AccountNameTitleField;
    }
    public void HomePageClick(WebDriver driver){
        Waffle.click();
        SearchInput.sendKeys("Home");
        HomePageRecord.click();
    }

    public void setAccountTab(WebElement accountTab) {
        AccountTab = accountTab;
    }
    public WebElement getAccountTab(WebElement accountTab){
        return AccountTab;
    }
}

