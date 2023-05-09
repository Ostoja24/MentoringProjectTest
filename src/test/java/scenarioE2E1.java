import PageObjects.*;
import com.github.javafaker.Faker;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.Locale;

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
    private final static String randomNumbersValue = randomNumbers(5);

    private static final String firstNameContact = "Selenium-" + randomNumbers(5);

    private static final String lastNameContact = "Contact";

    private static final String mobileContact = accountPhone();

    private static final String phoneContact = randomNumbers(9);

    private static final String emailContact = "contact-" + randomNumbers(4) + "@yopmail.com";

    private static final String mailingStreetContact = fakerObject().address().streetName();

    private static final String mailingCityContact = fakerObject().address().cityName();

    private static final String mailingZipContact = fakerObject().address().zipCode();

    private static final String otherStreetContact = fakerObject().address().streetName();

    private static final String otherCityContact = fakerObject().address().city();

    private static final String otherZipContact = fakerObject().address().zipCode();

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
    public void clickintoSalesApp() {
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
    public void checkingCreatedAccountDetails() {
        AccountRecordPage accountRecordPage = new AccountRecordPage(driver);
        accountRecordPage.clickDetailsRecordPageTab("detailTab");
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Account Name")).isEqualTo(accountName + randomNumbersValue);
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Industry")).isEqualTo(accountIndustry, accountRecordPage.getAccountFieldText("Industry"));
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Type")).isEqualTo(accountType, accountRecordPage.getAccountFieldText("Type"));
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Rating")).isEqualTo(accountRating, accountRecordPage.getAccountFieldText("Rating"));
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Customer Priority")).isEqualTo(accountCustomerPriority, accountRecordPage.getAccountFieldText("Customer Priority"));
        softAssertions.assertThat(accountRecordPage.getAccountPhoneRecordXpath()).isEqualTo(accountPhoneValue);
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("SLA")).isEqualTo(accountSLA, accountRecordPage.getAccountFieldText("SLA"));
        softAssertions.assertThat(accountRecordPage.getAccountAddressText("Billing Address")).isEqualTo("Toruńska\n" +
                "Toruń\n" +
                "87-100");
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Description")).isEqualTo(description);
    }

    @Test()
    @Order(6)
    public void creatingNewContactFromRelatedList() {
        AccountRecordPage accountRecordPage = new AccountRecordPage(driver);
        ContactFormPage contactFormPage = new ContactFormPage(driver);
        accountRecordPage.clickDetailsRecordPageTab("relatedListsTab");
        accountRecordPage.clickNewButtonOnRelatedList("Contact.NewContact");
        contactFormPage.clicksalutationContact("Mr.")
                .putintoFieldContact("First Name","input", firstNameContact)
                .putintoFieldContact("Last Name","input", lastNameContact)
                .putintoFieldContact("Mobile","input", mobileContact)
                .putintoFieldContact("Other Phone","input", phoneContact)
                .putintoFieldContact("Email","input", emailContact)
                .scrollIntoFieldMailingStreet()
                .clearFieldContact("Mailing Street","textarea")
                .clearFieldContact("Mailing City","input")
                .clearFieldContact("Mailing Zip/Postal Code","input")
                .putintoFieldContact("Mailing Street","textarea",mailingStreetContact)
                .putintoFieldContact("Mailing City","input",mailingCityContact)
                .putintoFieldContact("Mailing Zip/Postal Code","input",mailingZipContact)
                .putintoFieldContact("Other Street","textarea",otherStreetContact)
                .putintoFieldContact("Other City","input",otherCityContact)
                .putintoFieldContact("Other Zip/Postal Code","input",otherZipContact);

    }

}
