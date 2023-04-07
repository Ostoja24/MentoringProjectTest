import PageObjects.AccountFormPage;
import PageObjects.LoginPage;
import PageObjects.SalesforcePageHeader;
import data.DataClass;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.stream.Collectors;
@Epic("Accounts")
@Feature("1. Creating New Account")
public class scenarioE2E1 extends BaseTest {
    private static final String accountName =  "TestAccount";
    private static final String accountType =  "Other";
    private static final String accountRating =  "Cold";
    private static final String accountIndustry =  "Banking";
    private static final String accountCustomerPriority = "Low";
    private static final String accountSLA = "Platinum";
    private static final String billingStreet = "Toruńska";
    private static final String billingCity = "Toruń";
    private static final String billingZip = "87-100";
    private static final String shippingCity = "Warsaw";
    private static final String shippingStreet = "Nadwiślańska 1";
    private static final String shippingZip =  "00-001";
    private static final String description = "This Account has been created by Selenium, ";

    private static final String accountPhone = new Random().ints(9, 0, 10).mapToObj(Integer::toString).collect(Collectors.joining());
    private static final String randomNumbers = new Random().ints(5, 0, 10).mapToObj(Integer::toString).collect(Collectors.joining());
    private final String usernamevalue_login = getUsernameAdmin();
    private final String passwordvalue_login = getPasswordAdmin();


    @Test()
    public void logintoOrg(){
        LoginPage loginPage = new LoginPage(driver);
        SalesforcePageHeader sfPage = new SalesforcePageHeader(driver);
        loginPage.navigateToLoginUrl(driver,getOrgURL());
        loginPage.putkeysUsername(usernamevalue_login)
                .putkeysPassword(passwordvalue_login)
                .submitLoginButton();
        Assertions.assertEquals("Setup",sfPage.getPageTitle());
    }
    @Test()
    public void scenarioAccountsCreation() {
        AccountFormPage accountPage = new AccountFormPage(driver);
        SalesforcePageHeader sfPage = new SalesforcePageHeader(driver);
        sfPage.searchInput("Sales")
                .getPageTitle();
//        Assertions.assertEquals();
        sfPage.clickTab("Accounts");
        accountPage.newAccountForm();
        accountPage.putkeysAccountName(accountName + randomNumbers)
                .putkeysPhoneNumber(accountPhone)
                .putkeysAccountType(accountType)
                .putkeysBillingStreet(billingStreet)
                .putkeysBillingCity(billingCity)
                .putkeysBillingZipValue(billingZip)
                .putkeysShippingCity(shippingCity)
                .putkeysShippingStreet(shippingStreet)
                .putkeysShippingZip(shippingZip)
                .putDescription(description + LocalDate.now())
                .submitNewAccount();
        Assertions.assertEquals("Account " + '"' + accountName + randomNumbers + '"' + " was created.",accountPage.accountToastText());





    }
}
