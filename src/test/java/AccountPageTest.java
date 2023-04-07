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
    String usernamevalue_login = getUsernameAdmin();
    String passwordvalue_login = getPasswordAdmin();
    @Epic("Accounts")
    @Feature("1. Creating New Account")
    @Test()
    public void logintoOrg(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginUrl(driver,getOrgURL());
        loginPage.putkeysUsername(usernamevalue_login)
            .putkeysPassword(passwordvalue_login)
                .submitLoginButton();
    }

    @Test()
    public void newAccount () throws FileNotFoundException {
        LoginPage loginPage = new LoginPage(driver);
        AccountFormPage accountPage = new AccountFormPage(driver);
        SalesforcePageHeader sfPage = new SalesforcePageHeader(driver);
        DataClass dataclass = new DataClass();
        getCredentials();
        sfPage.homePageClickToAccounts();
        dataclass.AccountInfoJSON("C:\\Users\\tomcz\\IdeaProjects\\MentoringProjectTest\\src\\test\\java\\data\\AccountsInfo.json");
        String accountIndustryValue = dataclass.getAccountIndustry();
        String accountNameValue = dataclass.getAccountName();
        String accountRatingValue = dataclass.getAccountRating();
        String accountSLAValue = dataclass.getAccountSLA();
        String accountCustomerPriorityValue = dataclass.getAccountCustomerPriority();
        String accountTypeValue = dataclass.getAccountType();
        String billingCityValue = dataclass.getBillingCity();
        String billingZipValue = dataclass.getBillingZip();
        String billingStreetValue = dataclass.getBillingStreet();
        accountPage.newAccountForm();
        accountPage.putkeysAccountName(accountNameValue)
                .putkeysAccountType(accountTypeValue)
                .putkeysAccountIndustry(accountIndustryValue)
                .putkeysAccountRatingValue(accountRatingValue)
                .putkeysBillingCity(billingCityValue)
                .putkeysBillingZipValue(billingZipValue)
                .putkeysBillingStreet(billingStreetValue)
                .putkeysSLAValue(accountSLAValue)
                .putkeysAccountCustomerPriority(accountCustomerPriorityValue)
                .submitNewAccount();
        String AccountTitleValue = accountPage.getAccountNameTitleField();
        // Assertions that created record is saved
        Assertions.assertEquals(accountPage.accountToastText(),AccountTitleValue);
        Assertions.assertEquals(accountNameValue, AccountTitleValue);
    }
}
