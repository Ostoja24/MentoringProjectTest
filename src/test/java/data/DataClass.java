package data;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;

public class DataClass {
    private final String AccountName;
    private final String AccountType;
    private final String AccountIndustry;
    private final String AccountCustomerPriority;
    private final String AccountSLA;
    private final String BillingStreet;
    private final String BillingCity;
    private final String BillingZip;
    private final String ShippingCity;
    private final String ShippingStreet;
    private final String ShippingZip;
    private final String DescriptionValue;
    private final String UsernameValue;
    private final String PasswordValue;
    private final String AccountPhone;
    private final String OrgUrl;


    private final String AccountRating;
    private final String lastNameContact;
    private final static String mobileContact = accountPhone();
    private final static String emailContact = "contact-" + randomNumbers(4) + "@yopmail.com";
    private final String mailingStreetContact = fakerObject().address().streetName();
    private final String mailingCityContact = fakerObject().address().cityName();
    private final String mailingZipContact = fakerObject().address().zipCode();
    private final String otherStreetContact = fakerObject().address().streetName();
    private final String otherCityContact = fakerObject().address().city();
    private final String otherZipContact = fakerObject().address().zipCode();
    private final Double RandomNumber;
    private final String description;
    public final static String randomNumbersValue = randomNumbers(5);
    private final static String phoneContact = accountPhone();
    private final static String firstNameContact = "Selenium-" + randomNumbers(5);
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
        description = "This Account has been created by Selenium, ";

        lastNameContact = "Contact";

    }

    public String getDescriptionValue() {
        return DescriptionValue;
    }

    public String getFirstNameContact() {
        return firstNameContact;
    }

    public String getLastNameContact() {
        return lastNameContact;
    }

    public String getMobileContact() {
        return mobileContact;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public String getMailingStreetContact() {
        return mailingStreetContact;
    }

    public String getMailingCityContact() {
        return mailingCityContact;
    }

    public String getMailingZipContact() {
        return mailingZipContact;
    }

    public String getOtherStreetContact() {
        return otherStreetContact;
    }

    public String getOtherCityContact() {
        return otherCityContact;
    }

    public String getOtherZipContact() {
        return otherZipContact;
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

    public static String accountPhone() {
        return new Random().ints(9, 0, 10).mapToObj(Integer::toString).collect(Collectors.joining());

    }

    public static String randomNumbers(Integer numberofNumbers) {
        return new Random().ints(numberofNumbers, 0, 10).mapToObj(Integer::toString).collect(Collectors.joining());
    }

    public static Faker fakerObject() {
        return new Faker(new Locale("pl"));
    }
}

