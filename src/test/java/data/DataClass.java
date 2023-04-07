package data;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class DataClass {
    private String AccountName;
    private String AccountType;
    private String AccountIndustry;
    private String AccountCustomerPriority;
    private String AccountSLA;
    private String BillingStreet;
    private String BillingCity;
    private String BillingZip;
    private String ShippingCity;
    private String ShippingStreet;
    private String ShippingZip;
    private String DescriptionValue;
    private double RandomNumber;

    private String AccountRating;
    private final static String ACCOUNT_INFORMATION = "C:\\Users\\tomcz\\IdeaProjects\\MentoringProjectTest\\src\\test\\java\\data\\AccountsInfo.json";

    public void AccountInfoJSON(String ACCOUNT_INFORMATION) throws FileNotFoundException {
        RandomNumber = Math.random();
        JSONObject jsonAccount = new JSONObject(getAccountFormInfo(ACCOUNT_INFORMATION));
        AccountName = jsonAccount.getString("AccountName");
        AccountType = jsonAccount.getString("AccountType");
        AccountIndustry = jsonAccount.getString("AccountIndustry");
        AccountCustomerPriority = jsonAccount.getString("AccountCustomerPriority");
        AccountSLA = jsonAccount.getString("AccountSLA");
        AccountRating = jsonAccount.getString("AccountRating");
        BillingStreet = jsonAccount.getString("BillingStreet");
        BillingCity = jsonAccount.getString("BillingCity");
        BillingZip = jsonAccount.getString("BillingZip");
        ShippingCity = jsonAccount.getString("ShippingCity");
        ShippingStreet = jsonAccount.getString("ShippingStreet");
        ShippingZip = jsonAccount.getString("ShippingZip");
        DescriptionValue = jsonAccount.getString("Description");
    }
    public String getAccountName() {
        return AccountName;
    }

    public String getAccountType() {
        return AccountType;
    }

    public double getRandomNumber() {
        return RandomNumber;
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

    public JSONTokener getAccountFormInfo(String ACCOUNT_INFORMATION) throws FileNotFoundException {
        return new JSONTokener(new FileReader(ACCOUNT_INFORMATION));
    }

    public String getShippingCity() { return ShippingCity;
    }

    public String getShippingStreet() { return ShippingStreet;
    }
    public String getShippingZip(){
        return ShippingZip;
    }

    public String getDescription() {
        return DescriptionValue;
    }
}