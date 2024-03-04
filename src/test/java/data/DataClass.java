package data;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.stream.Collectors;

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
    private String UsernameValue;
    private String PasswordValue;
    private String AccountPhone;
    private String OrgUrl;

    private double RandomNumber;

    private String AccountRating;
    private final static File loginData = new File("src/test/java/data/data_login.json");
    private final static File accountInformation = new File("src/test/java/data/AccountsInfo.json");

    public DataClass() throws FileNotFoundException {
        RandomNumber = Math.random();
        JSONObject jsonAccount = new JSONObject(getAccountFormInfo(accountInformation.getAbsolutePath()));
        JSONObject jsonUser = new JSONObject(getAccountFormInfo(loginData.getAbsolutePath()));
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
        UsernameValue = jsonUser.getString("username");
        PasswordValue = jsonUser.getString("password");
        OrgUrl = jsonUser.getString("orgURL");
        AccountPhone = jsonAccount.getString("Phone");
    }

    public String getOrgUrl() {
        return OrgUrl;
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

    public String getShippingCity() {
        return ShippingCity;
    }

    public String getShippingStreet() {
        return ShippingStreet;
    }

    public String getShippingZip() {
        return ShippingZip;
    }

    public String getDescription() {
        return DescriptionValue;
    }

    public String getUsernameValue() {
        return UsernameValue;
    }


    public String getPasswordValue() {
        return PasswordValue;
    }


    public String getAccountPhone() {
        return AccountPhone;
    }
    public static String accountPhone()
    {
        return new Random().ints(9, 0, 10).mapToObj(Integer::toString).collect(Collectors.joining());

    }

}
