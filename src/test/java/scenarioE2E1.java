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
    public void logIntoOrg() {
        LoginPage loginPage = new LoginPage(driver);
        SalesforcePageHeader sfPage = new SalesforcePageHeader(driver);
        loginPage.navigateToLoginUrl(driver, getOrgURL());
        loginPage.putKeysIntoFieldUsername(usernamevalue_login)
                .putKeysIntoFieldPassword(passwordvalue_login)
                .submitLoginButton();
        Assertions.assertEquals("Setup", sfPage.getPageTitle());
    }

    @Test()
    @Order(2)
    public void salesAppTitleViewingInPage() {
        SalesforcePageHeader sfPage = new SalesforcePageHeader(driver);
        sfPage.searchInputIntoAppLauncher("Sales");
        Assertions.assertEquals("Sales", sfPage.getPageTitle());
    }

    @Test()
    @Order(3)
    public void clickintoAccountTabOnSalesforcePageHeader() {
        SalesforcePageHeader sfPage = new SalesforcePageHeader(driver);
        sfPage.clickTabOnSalesforceHeader("Accounts");
    }

    @Test()
    @Order(4)
    public void accountCreationMessage() {
        AccountListPage accountlistPage = new AccountListPage(driver);
        AccountFormPage accountPage = new AccountFormPage(driver);
        accountlistPage
                .clicknewAccountButton()
                .putKeysIntoFieldAccountName(accountName + randomNumbersValue)
                .putKeysIntoFieldAccountType(accountType)
                .putKeysIntoFieldAccountRatingValue(accountRating)
                .putKeysIntoFieldPhoneNumber(accountPhoneValue)
                .putKeysIntoFieldBillingStreet(billingStreet)
                .putKeysIntoFieldAccountIndustry(accountIndustry)
                .putKeysIntoFieldBillingCity(billingCity)
                .putKeysIntoFieldBillingZipValue(billingZip)
                .putKeysIntoFieldShippingCity(shippingCity)
                .putKeysIntoFieldShippingStreet(shippingStreet)
                .putKeysIntoFieldShippingZip(shippingZip)
                .putKeysIntoFieldSLAValue(accountSLA)
                .putKeysIntoFieldAccountCustomerPriority(accountCustomerPriority)
                .putDescription(description + LocalDate.now())
                .clickSaveButton();
        Assertions.assertEquals("Account " + '"' + accountName + randomNumbersValue + '"' + " was created.", accountPage.accountToastText());
    }

    @Test()
    @Order(5)
    public void detailsAccountEqualsToData() {
        AccountRecordPage accountRecordPage = new AccountRecordPage(driver);
        accountRecordPage.clickDetailsRecordPageTab("detailTab");
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Account Name")).isEqualTo(accountName + randomNumbersValue);
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Industry")).isEqualTo(accountIndustry, accountRecordPage.getAccountFieldText("Industry"));
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Type")).isEqualTo(accountType, accountRecordPage.getAccountFieldText("Type"));
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Rating")).isEqualTo(accountRating, accountRecordPage.getAccountFieldText("Rating"));
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Customer Priority")).isEqualTo(accountCustomerPriority, accountRecordPage.getAccountFieldText("Customer Priority"));
        softAssertions.assertThat(accountRecordPage.getAccountPhoneOnRecord()).isEqualTo(accountPhoneValue);
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("SLA")).isEqualTo(accountSLA, accountRecordPage.getAccountFieldText("SLA"));
        softAssertions.assertThat(accountRecordPage.getAccountAddressText("Billing Address")).isEqualTo("Toruńska\n" +
                "Toruń\n" +
                "87-100");
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Description")).isEqualTo(description);
    }

    @Test()
    @Order(6)
    public void creationNewContactInAccountAndViewingOnRelatedList() {
        AccountRecordPage accountRecordPage = new AccountRecordPage(driver);
        ContactFormPage contactFormPage = new ContactFormPage(driver);
        SoftAssertions softAssertions = new SoftAssertions();
        accountRecordPage.clickDetailsRecordPageTab("relatedListsTab");
        accountRecordPage.clickNewButtonOnRelatedList("Contact.NewContact");
        contactFormPage.clickSalutationContact("Mr.")
                .putIntoFieldInContactForm("First Name","input", firstNameContact)
                .putIntoFieldInContactForm("Last Name","input", lastNameContact)
                .putIntoFieldInContactForm("Mobile","input", mobileContact)
                .putIntoFieldInContactForm("Other Phone","input", phoneContact)
                .putIntoFieldInContactForm("Email","input", emailContact)
                .scrollIntoFieldMailingStreet()
                .clearFieldOnContactForm("Mailing Street","textarea")
                .clearFieldOnContactForm("Mailing City","input")
                .clearFieldOnContactForm("Mailing Zip/Postal Code","input")
                .putIntoFieldInContactForm("Mailing Street","textarea",mailingStreetContact)
                .putIntoFieldInContactForm("Mailing City","input",mailingCityContact)
                .putIntoFieldInContactForm("Mailing Zip/Postal Code","input",mailingZipContact)
                .putIntoFieldInContactForm("Other Street","textarea",otherStreetContact)
                .putIntoFieldInContactForm("Other City","input",otherCityContact)
                .putIntoFieldInContactForm("Other Zip/Postal Code","input",otherZipContact);
        accountRecordPage.clickSaveContactButton();
        softAssertions.assertThat(accountRecordPage.returnContactNumberonRelatedList()).isEqualTo("(1)");
        softAssertions.assertThat(accountRecordPage.returnToastContactRecordCreation()).isEqualTo("Mr.  " + firstNameContact);

    }
    @Test()
    @Order(7)
    public void checkingFieldsValuesOnContactDetails(){
        ContactRecordPage contactRecordPage = new ContactRecordPage(driver);
        AccountRecordPage accountRecordPage = new AccountRecordPage(driver);
        SoftAssertions softAssertions = new SoftAssertions();
        accountRecordPage.clickRecordButtonOnRelatedList(firstNameContact + " " + lastNameContact);
        contactRecordPage.clickDetailsContact();
        softAssertions.assertThat(contactRecordPage.getFieldContactRecordText("Name")).isEqualTo("Mr. " + firstNameContact);
        softAssertions.assertThat(contactRecordPage.getFieldContactRecordText("Mobile")).isEqualTo(mobileContact);
        softAssertions.assertThat(contactRecordPage.getFieldContactRecordText("Other Phone")).isEqualTo(phoneContact);
        softAssertions.assertThat(contactRecordPage.getFieldContactRecordText("Email")).isEqualTo(emailContact);
        softAssertions.assertThat(contactRecordPage.getFieldContactRecordAdress("Mailing Address")).isEqualTo(mailingStreetContact + mailingCityContact + mailingZipContact);
        softAssertions.assertThat(contactRecordPage.getFieldContactRecordAdress("Other Address")).isEqualTo(otherStreetContact + otherCityContact + otherZipContact);
    }
    @Test()
    @Order(8)
    public void changingNameOnExistingContactRecord(){
        ContactRecordPage contactRecordPage = new ContactRecordPage(driver);
        SoftAssertions softAssertions = new SoftAssertions();
        contactRecordPage.clickEditName()
                .changeLastName("Automation-Test")
                .clickSaveButton();
        softAssertions.assertThat(contactRecordPage.getFieldContactRecordText("Name")).isNotEqualTo("Mr. " + firstNameContact);
        softAssertions.assertThat(contactRecordPage.getFieldContactRecordText("Name")).isEqualTo("Mr. " + "Automation-Test");
    }
}
