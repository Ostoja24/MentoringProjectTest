import PageObjects.*;
import data.DataClass;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;

public class AccountPageTest extends BaseTest {
    public AccountPageTest () {
        super();
    }
    @Epic("Accounts")
    @Feature("1. Creating New Account")
    @Test()
    public void newAccount () throws FileNotFoundException {
        LoginPage loginPage = new LoginPage(driver);
        AccountFormPage accountPage = new AccountFormPage(driver);
        SetupPage setupPage = new SetupPage(driver);
        DataClass dataclass = new DataClass();
        getCredentials();
        String usernamevalue_login = getUsernameAdmin();
        String passwordvalue_login = getPasswordAdmin();
        loginPage.navigateToLoginUrl(driver,getOrgURL());
        loginPage.putkeysUsername(usernamevalue_login)
                .putkeysPassword(passwordvalue_login)
                .submitLoginButton();
        dataclass.getAccountFormInfo();
        dataclass.AccountInfoJSON();
        setupPage.homePageClicktoAccounts();
        String accountIndustryValue = dataclass.getAccountIndustry();
        String accountNameValue = dataclass.getAccountName();
        String accountRatingValue = dataclass.getAccountRating();
        String accountSLAValue = dataclass.getAccountSLA();
        String accountCustomerPriorityValue = dataclass.getAccountCustomerPriority();
        String accountTypeValue = dataclass.getAccountType();
        String billingCityValue = dataclass.getBillingCity();
        String billingZipValue = dataclass.getBillingZip();
        String billingStreetValue = dataclass.getBillingStreet();
        accountPage.newAccountForm(driver);
        accountPage.putkeysAccountName(accountNameValue)
                .putkeysAccountType(accountTypeValue)
                .putkeysAccountIndustry(accountIndustryValue)
                .putkeysAccountRatingValue(accountRatingValue)
                .putkeysBillingCity(billingCityValue)
                .putkeysBillingZipValue(billingZipValue)
                .putkeysBillingStreet(billingStreetValue)
                .putkeysSLAValue(accountSLAValue)
                .putkeysAccountCustomerPriority(accountCustomerPriorityValue)
                .submitNewAccount(driver);
        String AccountTitleValue = accountPage.getAccountNameTitleField();
        // Assertions that created record is saved
        Assertions.assertEquals(accountNameValue, AccountTitleValue);
    }
}
