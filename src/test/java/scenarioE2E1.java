import PageObjects.AccountFormPage;
import PageObjects.AccountListPage;
import PageObjects.LoginPage;
import PageObjects.SalesforcePageHeader;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;

import java.time.LocalDate;


@Epic("Accounts")
@Feature("1. Creating New Account")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class scenarioE2E1 extends BaseTest {
    private static final String accountName = "TestAccount";
    private static final String accountType = "Other";
    private static final String accountRating = "Cold";
    private static final String accountIndustry = "Banking";
    private static final String accountCustomerPriority = "Low";
    private static final String accountSLA = "Platinum";
    private static final String billingStreet = "Toruńska";
    private static final String billingCity = "Toruń";
    private static final String billingZip = "87-100";
    private static final String shippingCity = "Warsaw";
    private static final String shippingStreet = "Nadwiślańska 1";
    private static final String shippingZip = "00-001";
    private static final String description = "This Account has been created by Selenium, ";
    private final String usernamevalue_login = getUsernameAdmin();
    private final String passwordvalue_login = getPasswordAdmin();
    private final static String accountPhoneValue = accountPhone();
    private final static String randomNumbersValue = randomNumbers();


    @Test()
    @Order(1)
    public void logintoOrg() {
        LoginPage loginPage = new LoginPage(driver);
        SalesforcePageHeader sfPage = new SalesforcePageHeader(driver);
        loginPage.navigateToLoginUrl(driver, getOrgURL());
        loginPage.putkeysUsername(usernamevalue_login)
                .putkeysPassword(passwordvalue_login)
                .submitLoginButton();
        Assertions.assertEquals("Setup", sfPage.getSetupPageTitle());
    }

    @Test()
    @Order(2)
    public void clickintoSalesApp() throws InterruptedException {
        SalesforcePageHeader sfPage = new SalesforcePageHeader(driver);
        sfPage.searchInput("Sales");
        Assertions.assertEquals("Sales", sfPage.getPageTitle());
    }

    @Test()
    @Order(3)
    public void clickintoAccountTab() {
        SalesforcePageHeader sfPage = new SalesforcePageHeader(driver);
        sfPage.clickTab("Accounts");
    }

    @Test()
    @Order(4)
    public void newAccountRecord() {
        AccountListPage accountlistPage = new AccountListPage(driver);
        AccountFormPage accountPage = new AccountFormPage(driver);
        accountlistPage
                .clicknewAccountButton()
                .putkeysAccountName(accountName + randomNumbersValue)
                .putkeysAccountIndustry(accountIndustry)
                .putkeysAccountRatingValue(accountRating)
                .putkeysPhoneNumber(accountPhoneValue)
                .putkeysAccountType(accountType)
                .putkeysBillingStreet(billingStreet)
                .putkeysBillingCity(billingCity)
                .putkeysBillingZipValue(billingZip)
                .putkeysShippingCity(shippingCity)
                .putkeysShippingStreet(shippingStreet)
                .putkeysShippingZip(shippingZip)
                .putDescription(description + LocalDate.now())
                .putkeysSLAValue(accountSLA)
                .putkeysAccountCustomerPriority(accountCustomerPriority)
                .clickSaveButton();
        Assertions.assertEquals("Account " + '"' + accountName + randomNumbersValue + '"' + " was created.", accountPage.accountToastText());
    }
}
