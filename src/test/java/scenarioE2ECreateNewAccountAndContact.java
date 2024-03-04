import PageObjects.*;
import data.DataClass;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.time.LocalDate;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.extension.ExtendWith;


@Epic("Accounts")
@Feature("1. Creating New Account")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class scenarioE2ECreateNewAccountAndContact extends BaseTest {
    private static final String description = "This Account has been created by Selenium, ";
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
    DataClass dataClass = new DataClass();

    public scenarioE2ECreateNewAccountAndContact() throws FileNotFoundException {
    }

    @Test()
    @Order(1)
    @ExtendWith(TestWatcherAllure.class)
    public void logIntoOrg() {
        LoginPage loginPage = new LoginPage(driver);
        SalesforcePageHeader sfPage = new SalesforcePageHeader(driver);
        loginPage.navigateToLoginUrl(driver, dataClass.getOrgUrl());
        loginPage.putKeysIntoFieldUsername(dataClass.getUsernameValue())
                .putKeysIntoFieldPassword(dataClass.getPasswordValue())
                .submitLoginButton();
        Assertions.assertEquals("Setup", sfPage.getPageTitleOnSetup());
    }

    @Test()
    @Order(2)
    @ExtendWith(TestWatcherAllure.class)
    public void salesAppTitleViewingInPage() {
        SalesforcePageHeader sfPage = new SalesforcePageHeader(driver);
        sfPage.searchInputIntoAppLauncher("Sales");
        Assertions.assertEquals("Sales", sfPage.getPageTitle());
    }

    @Test()
    @Order(3)
    @ExtendWith(TestWatcherAllure.class)
    public void clickIntoAccountTabOnSalesforcePageHeader() {
        SalesforcePageHeader sfPage = new SalesforcePageHeader(driver);
        sfPage.clickTabOnSalesforceHeader("Accounts");
    }

    @Test()
    @Order(4)
    @ExtendWith(TestWatcherAllure.class)
    public void accountCreationMessage() {
        AccountListPage accountlistPage = new AccountListPage(driver);
        AccountFormPage accountPage = new AccountFormPage(driver);
        accountlistPage
                .clicknewAccountButton()
                .putKeysIntoFieldAccountName(dataClass.getAccountName() + randomNumbersValue)
                .putKeysIntoFieldAccountType(dataClass.getAccountType())
                .putKeysIntoFieldAccountRatingValue(dataClass.getAccountRating())
                .putKeysIntoFieldPhoneNumber(dataClass.getAccountPhone())
                .putKeysIntoFieldBillingStreet(dataClass.getBillingStreet())
                .putKeysIntoFieldAccountIndustry(dataClass.getAccountIndustry())
                .putKeysIntoFieldBillingCity(dataClass.getBillingCity())
                .putKeysIntoFieldBillingZipValue(dataClass.getBillingZip())
                .putKeysIntoFieldShippingCity(dataClass.getShippingCity())
                .putKeysIntoFieldShippingStreet(dataClass.getShippingStreet())
                .putKeysIntoFieldShippingZip(dataClass.getShippingZip())
                .putKeysIntoFieldSLAValue(dataClass.getAccountSLA())
                .putKeysIntoFieldAccountCustomerPriority(dataClass.getAccountCustomerPriority())
                .putDescription((dataClass.getDescription()) + LocalDate.now())
                .clickSaveButton();
        Assertions.assertEquals("Account " + '"' + dataClass.getAccountName() + randomNumbersValue + '"' + " was created.", accountPage.accountToastText());
    }

    @Test()
    @Order(5)
    @ExtendWith(TestWatcherAllure.class)
    public void detailsAccountEqualsToData() {
        AccountRecordPage accountRecordPage = new AccountRecordPage(driver);
        accountRecordPage.clickDetailsRecordPageTab("detailTab");
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Account Name")).isEqualTo(dataClass.getAccountName() + randomNumbersValue);
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Industry")).isEqualTo(dataClass.getAccountIndustry(), accountRecordPage.getAccountFieldText("Industry"));
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Type")).isEqualTo(dataClass.getAccountType(), accountRecordPage.getAccountFieldText("Type"));
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Rating")).isEqualTo(dataClass.getAccountRating(), accountRecordPage.getAccountFieldText("Rating"));
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Customer Priority")).isEqualTo(dataClass.getAccountCustomerPriority(), accountRecordPage.getAccountFieldText("Customer Priority"));
        softAssertions.assertThat(accountRecordPage.getAccountPhoneOnRecord()).isEqualTo(dataClass.getAccountPhone());
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("SLA")).isEqualTo(dataClass.getAccountSLA(), accountRecordPage.getAccountFieldText("SLA"));
        softAssertions.assertThat(accountRecordPage.getAccountAddressText("Billing Address")).isEqualTo("Toruńska\n" +
                "Toruń\n" +
                "87-100");
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Description")).isEqualTo(description);
    }

    @Test()
    @Order(6)
    @ExtendWith(TestWatcherAllure.class)
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
    @ExtendWith(TestWatcherAllure.class)
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
        softAssertions.assertThat(contactRecordPage.getFieldContactRecordAddress("Mailing Address")).isEqualTo(mailingStreetContact + mailingCityContact + mailingZipContact);
        softAssertions.assertThat(contactRecordPage.getFieldContactRecordAddress("Other Address")).isEqualTo(otherStreetContact + otherCityContact + otherZipContact);
    }
    @Test()
    @Order(8)
    @ExtendWith(TestWatcherAllure.class)
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
