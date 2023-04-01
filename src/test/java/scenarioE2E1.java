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

public class scenarioE2E1 extends BaseTest {
    public scenarioE2E1() {
        super();
    }
    @Epic("Accounts")
    @Feature("1. Creating New Account")
    @Test()
    public void scenarioAccountsCreation() throws FileNotFoundException {
        LoginPage loginPage = new LoginPage(driver);
        AccountFormPage accountPage = new AccountFormPage(driver);
        SalesforcePageHeader sfPage = new SalesforcePageHeader(driver);
        DataClass dataclass = new DataClass();
        getCredentials();
        String usernamevalue_login = getUsernameAdmin();
        String passwordvalue_login = getPasswordAdmin();
        loginPage.navigateToLoginUrl(driver,getOrgURL());
        loginPage.putkeysUsername(usernamevalue_login)
                .putkeysPassword(passwordvalue_login)
                .submitLoginButton();
        sfPage.searchInput("Sales")
                .assertPageTitle("Sales")
                .clickTab("Accounts");
        accountPage.newAccountForm();
        dataclass.AccountInfoJSON("C:\\Users\\tomcz\\IdeaProjects\\MentoringProjectTest\\src\\test\\java\\data\\AccountScenarionInfo.json");
        String randomNumbers = new Random().ints(5, 0, 10).mapToObj(Integer::toString).collect(Collectors.joining());
        String accountPhone = new Random().ints(9, 0, 10).mapToObj(Integer::toString).collect(Collectors.joining());
        String accountNameValue = dataclass.getAccountName() + randomNumbers;
        String accountTypeValue = dataclass.getAccountType();
        String accountBillingStreetValue = dataclass.getBillingStreet();
        String accountBillingCityValue = dataclass.getBillingCity();
        String accountBillingZipValue = dataclass.getBillingZip();
        String accountShippingCityValue = dataclass.getShippingCity();
        String accountShippingStreetValue = dataclass.getShippingStreet();
        String accountShippingZipValue = dataclass.getShippingZip();
        String accountSLAValue = dataclass.getAccountSLA();
        String accountDescriptionValue = dataclass.getDescription() + LocalDate.now();
        accountPage.putkeysAccountName(accountNameValue)
                .putkeysPhoneNumber(accountPhone)
                .putkeysAccountType(accountTypeValue)
                .putkeysBillingStreet(accountBillingStreetValue)
                .putkeysBillingCity(accountBillingCityValue)
                .putkeysBillingZipValue(accountBillingZipValue)
                .putkeysShippingCity(accountShippingCityValue)
                .putkeysShippingStreet(accountShippingStreetValue)
                .putkeysShippingZip(accountShippingZipValue)
                .putkeysSLAValue(accountSLAValue)
                .putDescription(accountDescriptionValue)
                .submitNewAccount();
        Assertions.assertEquals("Account " + '"' + accountNameValue + '"' + " was created.",accountPage.accountToastText());





    }
}
