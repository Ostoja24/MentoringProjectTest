import PageObjects.*;
import org.json.JSONTokener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;

public class AccountPageTest extends BaseTest {
    @Test()
    public void newAccount () throws FileNotFoundException {
        LoginPage loginPage = new LoginPage();
        AccountFormPage accountPage = new AccountFormPage();
        SetupPage setupPage = new SetupPage();
        HomePage homepage = new HomePage();
        getCredentials();
        loginPage.navigateToLoginUrl(driver,getOrgURL());
        implicitwaittest(driver);
        loginPage.LoginPageInit(driver);
        String usernamevalue_login = getUsernameAdmin();
        String passwordvalue_login = getPasswordAdmin();
        loginPage.putkeysUsername(usernamevalue_login);
        loginPage.putkeysPassword(passwordvalue_login);
        loginPage.submit();
        setupPage.SetupPageInit(driver);
        accountPage.getAccountFormInfo();
        accountPage.AccountInfoJSON();
        setupPage.HomePageClick(driver);
        homepage.HomePageInit(driver);
        explicitwaittest(driver,HomePage.getAccountTab());
        homepage.AccountTabClick(driver);
        accountPage.AccountPageInit(driver);
        accountPage.newAccountForm(driver);
        String AccountIndustryValue = accountPage.getAccountIndustry();
        String AccountNameValue = accountPage.getAccountName();
        String AccountRatingValue = accountPage.getAccountRating();
        String AccountSLAValue = accountPage.getAccountSLA();
        String AccountCustomerPriorityValue = accountPage.getAccountCustomerPriority();
        String BillingCityValue = accountPage.getBillingCity();
        accountPage.putkeysAccountName(AccountNameValue);
        accountPage.putkeysAccountIndustry(AccountIndustryValue);
        accountPage.putkeysBillingCity(BillingCityValue);
        accountPage.submitNewAccount(driver);
        WebElement AccountTitleValue = accountPage.getAccountNameTitleField();
        Assertions.assertEquals("TestAccount", AccountTitleValue.getText());


    }
}
