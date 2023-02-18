import PageObjects.LoginPage;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;

public class HomePageTest  extends BaseTest{


    private WebElement element;
    private WebElement PageTitle;

    public WebElement getElement() {
        return element;
    }


    @Test
    public void login_and_check_page_title() throws FileNotFoundException {
        //Login to the environment

        LoginPage loginPage = new LoginPage();
        getCredentials();
        loginPage.navigateToLoginUrl(driver,getOrgURL());
        loginPage.LoginPageInit(driver);
        String usernamevalue_login = getUsernameAdmin();
        String passwordvalue_login = getPasswordAdmin();
        loginPage.putkeysUsername(usernamevalue_login);
        loginPage.putkeysPassword(passwordvalue_login);
        loginPage.submit();
        //Assertion that loaded page is appriopriate
        Assertions.assertTrue(loginPage.returnPagetitle(driver).contains("lightning/setup/SetupOneHome/home"));

    }

}
