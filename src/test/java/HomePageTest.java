import PageObjects.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;


public class HomePageTest  extends BaseTest{


    @Test
    @Epic("Login Page")
    @Feature("1. Login to Org")
    public void login_and_check_page_title() throws FileNotFoundException {
        //Login to the environment
        LoginPage loginPage = new LoginPage(driver);
        getCredentials();
        loginPage.navigateToLoginUrl(driver,getOrgURL());
        String usernameValueLogin = getUsernameAdmin();
        String passwordValueLogin = getPasswordAdmin();
        loginPage.putkeysUsername(usernameValueLogin);
        loginPage.putkeysPassword(passwordValueLogin);
        loginPage.submitLoginButton();
        //Assertion that loaded page is appriopriate
        Assertions.assertTrue(loginPage.returnPagetitle(driver).contains("lightning/setup/SetupOneHome/home"));

    }

}
