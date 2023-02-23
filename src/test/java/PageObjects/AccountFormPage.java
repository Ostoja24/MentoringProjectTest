package PageObjects;

import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class AccountFormPage extends BasePage {
    public AccountFormPage(WebDriver driver){
        super(driver);
    }
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

    private static final String xpathaccounttab = "//span[normalize-space()='Accounts']";
    @FindBy(xpath = xpathaccounttab)
    private static WebElement AccountTab;

    private static final String xpathhomepage = "//a[@class='tabHeader slds-context-bar__label-action ']//span[@class='title slds-truncate'][normalize-space()='Home']";
    @FindBy(xpath = xpathhomepage)
    private WebElement HomePage;

    private static final String xpathwaffle = "//div[@class='slds-icon-waffle']";
    @FindBy(xpath = xpathwaffle)
    private WebElement Waffle;

    private static final String xpathsearchinput = "//input[@class='slds-input']";
    @FindBy(xpath = xpathsearchinput)
    private WebElement SearchInput;

    private static final String xpathhomepagerecord = "//a[@id='Home']//b[contains(text(),'Home')]";
    @FindBy(xpath = xpathhomepagerecord)
    private WebElement HomePageRecord;

    private static final String xpathaccountnewbutton = "//a[@id='Home']//b[contains(text(),'Home')]";
    @FindBy(xpath = xpathaccountnewbutton)
    private WebElement AccountNewButton;

    private static final String xpathaccountnamelement = "//input[@name='Name']";
    @FindBy(xpath = xpathaccountnamelement)
    private WebElement AccountNameElement;

    private static final String xpathaccounttypefield = "//*[@id='combobox-button-216']";
    @FindBy(xpath = xpathaccounttypefield)
    private WebElement AccountTypeField;

    private static final String xpathaccountratingfield = "//*[@id='combobox-button-183']";
    @FindBy(xpath = xpathaccountratingfield)
    private WebElement AccountRatingField;

    private static final String xpathaccountindustryfield = "//button[starts-with(@aria-label,'Industry')]";
    @FindBy(xpath = xpathaccountindustryfield)
    private WebElement AccountIndustryField;

    @FindBy(id = "combobox-button-270")
    private WebElement AccountCustomerField;

    @FindBy(id = "combobox-button-278")
    private WebElement AccountSLAField;
    private static final String xpathbillingstreetfield = "//records-record-layout-item[@field-label='Billing Address']//textarea[@name='street']";
    @FindBy(xpath = xpathbillingstreetfield)
    private WebElement BillingStreetField;
    private static final String xpathbillingcityfield = "//records-record-layout-item[@field-label='Billing Address']//input[@name='city']";
    @FindBy(xpath = xpathbillingcityfield)
    private WebElement BillingCityField;

    private static final String xpathbillingzipfield = "//records-record-layout-item[@field-label='Billing Address']//input[@name='postalCode']";
    @FindBy(xpath = xpathbillingzipfield)
    private WebElement BillingZipField;
    private static final String xpathsaveaccountrecordbutton = "//button[@name='SaveEdit']";

    @FindBy(xpath = xpathsaveaccountrecordbutton)
    private WebElement SaveAccountRecordButton;

    private static final String xpathaccountnametitlefield = "//lightning-formatted-text[@class='custom-truncate']";
    @FindBy(xpath = xpathaccountnametitlefield)
    private WebElement AccountNameTitleField;

    private static final String xpathindustryagriculture = "//button[contains(text(),'-1-')]";
    @FindBy(xpath = xpathindustryagriculture)
    private WebElement AccountIndustryField;


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

    public void putkeysAccountIndustry(WebDriver driver, String AccountIndustry) {
        AccountIndustryField.click();
        List<WebElement> list = driver.findElements(By.xpath("//button[contains(@aria-activedescdentant,'combobox')]"));
        for (WebElement webElement : list) {
            if (webElement.getText().contains(AccountIndustry)) {
                webElement.click();
            }

        }}
        public void putkeysAccountCustomerPriority (String AccountCustomerPriority){
            AccountCustomerField.sendKeys(AccountCustomerPriority);
        }

        public void putkeysBillingStreet (String BillingStreet){
            BillingStreetField.sendKeys(BillingStreet);
        }

        public void putkeysBillingCity (String BillingCity){
            BillingCityField.sendKeys(BillingCity);
        }

        public void putkeysBillingZip (String BillingZip){
            BillingZipField.sendKeys(BillingZip);
        }

        public void setAccountName (String accountName){
            AccountName = accountName;
        }

        public void setAccountType (String accountType){
            AccountType = accountType;
        }

        public void setAccountRating (String accountRating){
            AccountRating = accountRating;
        }

        public void setAccountIndustry (String accountIndustry){
            AccountIndustry = accountIndustry;
        }

        public void setAccountCustomerPriority (String accountCustomerPriority){
            AccountCustomerPriority = accountCustomerPriority;
        }

        public void setAccountSLA (String accountSLA){
            AccountSLA = accountSLA;
        }

        public void setBillingStreet (String billingStreet){
            BillingStreet = billingStreet;
        }

        public void setBillingCity (String billingCity){
            BillingCity = billingCity;
        }

        public void setBillingZip (String billingZip){
            BillingZip = billingZip;
        }


        public static WebElement getAccountTab () {
            return AccountTab;
        }

        public WebElement getAccountNameTitleField () {
            return AccountNameTitleField;
        }
        public void HomePageClick (WebDriver driver){
            Waffle.click();
            SearchInput.sendKeys("Home");
            HomePageRecord.click();
        }

        public void setAccountTab (WebElement accountTab){
            AccountTab = accountTab;
        }
        public WebElement getAccountTab (WebElement accountTab){
            return AccountTab;
        }
    }

