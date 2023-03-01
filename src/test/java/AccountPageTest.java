import PageObjects.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

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
        HomePage homepage = new HomePage(driver);
        getCredentials();
        loginPage.navigateToLoginUrl(driver,getOrgURL());
        implicitwaittest(driver);
        loginPage.LoginPageInit(driver);
        String usernamevalue_login = getUsernameAdmin();
        String passwordvalue_login = getPasswordAdmin();
        loginPage.putkeysUsername(usernamevalue_login)
        .putkeysPassword(passwordvalue_login)
        .submit();
        accountPage.getAccountFormInfo();
        accountPage.AccountInfoJSON();
        setupPage.HomePageClick();
        homepage.HomePageInit();
//        explicitwaittest(driver,"//span[normalize-space()='Accounts']");
//        homepage.AccountTabClick(driver);
        accountPage.AccountPageInit(driver);
        accountPage.newAccountForm(driver);
        String AccountIndustryValue = accountPage.getAccountIndustry();
        String AccountNameValue = accountPage.getAccountName();
        String AccountRatingValue = accountPage.getAccountRating();
        String AccountSLAValue = accountPage.getAccountSLA();
        String AccountCustomerPriorityValue = accountPage.getAccountCustomerPriority();
        String BillingCityValue = accountPage.getBillingCity();
        accountPage.putkeysAccountName(AccountNameValue);
        accountPage.putkeysAccountIndustry(driver,AccountIndustryValue);
        accountPage.putkeysBillingCity(BillingCityValue);
        accountPage.submitNewAccount(driver);
        WebElement AccountTitleValue = accountPage.getAccountNameTitleField();
        Assertions.assertEquals("TestAccount" + AccountFormPage.getRandomNumber(), AccountTitleValue.getText());
    }
    @Test()
    public void EditAddedAccount(){
        AccountFormPage accountPage = new AccountFormPage(driver);
        implicitwaittest(driver);



    }
}
