import PageObjects.*;
import data.DataClass;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.time.LocalDate;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.extension.ExtendWith;

import static data.DataClass.randomNumbersValue;


@Epic("Accounts")
@Feature("1. Creating New Account")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class scenarioE2ECreateNewAccountAndContact extends BaseTest {


    @Test()
    @Order(1)
    @ExtendWith(TestWatcherAllure.class)
    public void logIntoOrg() throws FileNotFoundException {
        DataClass dataClass = new DataClass();
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
    public void accountCreationMessage() throws FileNotFoundException {
        DataClass dataClass = new DataClass();
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
    public void detailsAccountEqualsToData() throws FileNotFoundException {
        DataClass dataClass = new DataClass();
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
        softAssertions.assertThat(accountRecordPage.getAccountAddressText("Billing Address")).isEqualTo(
                """
Toruńska
87-100 Toruń""");
        softAssertions.assertThat(accountRecordPage.getAccountFieldText("Description")).isEqualTo(dataClass.getDescription() + LocalDate.now());
        softAssertions.assertAll();
    }

    @Test()
    @Order(6)
    @ExtendWith(TestWatcherAllure.class)
    public void creationNewContactInAccountAndViewingOnRelatedList() throws FileNotFoundException {
        DataClass dc = new DataClass();
        AccountRecordPage accountRecordPage = new AccountRecordPage(driver);
        ContactFormPage contactFormPage = new ContactFormPage(driver);
        SoftAssertions softAssertions = new SoftAssertions();
        accountRecordPage.clickDetailsRecordPageTab("relatedListsTab");
        accountRecordPage.clickNewButtonOnRelatedList("Contact.NewContact");
        contactFormPage.clickSalutationContact("Mr.")
                .putIntoFieldInContactForm("First Name","input", dc.getFirstNameContact())
                .putIntoFieldInContactForm("Last Name","input", dc.getLastNameContact())
                .putIntoFieldInContactForm("Mobile","input", dc.getMobileContact())
                .putIntoFieldInContactForm("Other Phone","input", dc.getAccountPhone())
                .putIntoFieldInContactForm("Email","input", dc.getEmailContact())
                .scrollIntoFieldMailingStreet()
                .clearFieldOnContactForm("Mailing Street","textarea")
                .clearFieldOnContactForm("Mailing City","input")
                .clearFieldOnContactForm("Mailing Zip/Postal Code","input")
                .putIntoFieldInContactForm("Mailing Street","textarea",dc.getMailingStreetContact())
                .putIntoFieldInContactForm("Mailing City","input",dc.getMailingCityContact())
                .putIntoFieldInContactForm("Mailing Zip/Postal Code","input",dc.getMailingZipContact())
                .putIntoFieldInContactForm("Other Street","textarea",dc.getOtherStreetContact())
                .putIntoFieldInContactForm("Other City","input",dc.getOtherCityContact())
                .putIntoFieldInContactForm("Other Zip/Postal Code","input",dc.getOtherZipContact());
        accountRecordPage.clickSaveContactButton();
        softAssertions.assertThat(accountRecordPage.returnToastContactRecordCreation()).isEqualTo("Mr. " + dc.getFirstNameContact() + " Contact");
        softAssertions.assertThat(accountRecordPage.returnContactNumberonRelatedList()).isEqualTo("(1)");
        ;
        softAssertions.assertAll();

    }
    @Test()
    @Order(7)
    @ExtendWith(TestWatcherAllure.class)
    public void checkingFieldsValuesOnContactDetails() throws FileNotFoundException {
        DataClass dataClass = new DataClass();
        ContactRecordPage contactRecordPage = new ContactRecordPage(driver);
        AccountRecordPage accountRecordPage = new AccountRecordPage(driver);
        SoftAssertions softAssertions = new SoftAssertions();
        accountRecordPage.clickRecordButtonOnRelatedList(dataClass.getFirstNameContact() + " " + dataClass.getLastNameContact());
        contactRecordPage.clickDetailsContact();
        softAssertions.assertThat(contactRecordPage.getFieldContactRecordText("Name")).isEqualTo("Mr. " + dataClass.getFirstNameContact() + " Contact");
        softAssertions.assertThat(contactRecordPage.getFieldContactRecordPhoneAndEmail("Mobile")).isEqualTo(dataClass.getMobileContact());
        softAssertions.assertThat(contactRecordPage.getFieldContactRecordPhoneAndEmail("Other Phone")).isEqualTo(dataClass.getAccountPhone());
        softAssertions.assertThat(contactRecordPage.getFieldContactRecordPhoneAndEmail("Email")).isEqualTo(dataClass.getEmailContact());
        softAssertions.assertAll();
    }
    @Test()
    @Order(8)
    @ExtendWith(TestWatcherAllure.class)
    public void changingNameOnExistingContactRecord() throws FileNotFoundException {
        DataClass dc = new DataClass();
        ContactRecordPage contactRecordPage = new ContactRecordPage(driver);
        SoftAssertions softAssertions = new SoftAssertions();
        contactRecordPage.clickEditName()
                .changeLastName("Automation-Test")
                .clickSaveButton();
        softAssertions.assertThat(contactRecordPage.getFieldContactRecordText("Name")).isNotEqualTo("Mr. " + dc.getFirstNameContact());
        softAssertions.assertThat(contactRecordPage.getFieldContactRecordText("Name")).isEqualTo("Mr. " + dc.getFirstNameContact()+ " Automation-Test");
        softAssertions.assertAll();
    }
}
