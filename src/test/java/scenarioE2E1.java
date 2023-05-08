import PageObjects.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import org.assertj.core.api.SoftAssertions;


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
    public void clickintoSalesApp()  {
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
                .putkeysAccountType(accountType)
                .putkeysAccountRatingValue(accountRating)
                .putkeysPhoneNumber(accountPhoneValue)
                .putkeysBillingStreet(billingStreet)
                .putkeysAccountIndustry(accountIndustry)
                .putkeysBillingCity(billingCity)
                .putkeysBillingZipValue(billingZip)
                .putkeysShippingCity(shippingCity)
                .putkeysShippingStreet(shippingStreet)
                .putkeysShippingZip(shippingZip)
                .putkeysSLAValue(accountSLA)
                .putkeysAccountCustomerPriority(accountCustomerPriority)
                .putDescription(description + LocalDate.now())
                .clickSaveButton();
        Assertions.assertEquals("Account " + '"' + accountName + randomNumbersValue + '"' + " was created.", accountPage.accountToastText());
    }
    @Test()
    @Order(5)
    public void checkingCreatedAccountDetails(){
        AccountRecordPage accountRecordPage = new AccountRecordPage(driver);
        accountRecordPage.clickDetailsRecordPageTab();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Account Name")).isEqualTo(accountName + randomNumbersValue);
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Industry")).isEqualTo(accountIndustry,accountRecordPage.getAccountFieldText("Industry"));
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Type")).isEqualTo(accountType,accountRecordPage.getAccountFieldText("Type"));
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Rating")).isEqualTo(accountRating,accountRecordPage.getAccountFieldText("Rating"));
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Customer Priority")).isEqualTo(accountCustomerPriority,accountRecordPage.getAccountFieldText("Customer Priority"));
        softAssertions.assertThat(accountRecordPage.getAccountPhoneRecordXpath()).isEqualTo(accountPhoneValue);
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("SLA")).isEqualTo(accountSLA,accountRecordPage.getAccountFieldText("SLA"));
        softAssertions.assertThat(accountRecordPage.getAccountAddressText("Billing Address")).isEqualTo("Toruńska\n" +
                  "Toruń\n" +
                  "87-100");
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Description")).isEqualTo(description);
    }

}
