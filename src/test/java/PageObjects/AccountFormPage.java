package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.json.JSONObject;

public class AccountFormPage {
    private String AccountName;
    private String AccountType;
    private String AccountRating;
    private String AccountIndustry;
    private String AccountCustomerPriority;
    private String AccountSLA;
    private String BillingStreet;
    private String BillingCity;
    private String BillingZip;

    public String getAccountFormInfo(){
        String getAccountInfo = System.getProperty("src/test/java/data/AccountsInfo.json");
        return getAccountInfo;
    }

    public void AccountPageInit(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void AccountInfoJSON(){
        JSONObject jsonAccount = new JSONObject(getAccountFormInfo());
        String AccountName = jsonAccount.getString("AccountName");
        String AccountType = jsonAccount.getString("AccountType");
        String AccountIndustry = jsonAccount.getString("AccountIndustry");
        String AccountCustomerPriority = jsonAccount.getString("AccountCustomerPriority");
        String AccountSLA = jsonAccount.getString("AccountSLA");
        String BillingStreet = jsonAccount.getString("BillingStreet");
        String BillingCity = jsonAccount.getString("BillingCity");
        String BillingZip = jsonAccount.getString("BillingZip");
    }
//    public void PutAccountInfo(){
//
//    }
}
