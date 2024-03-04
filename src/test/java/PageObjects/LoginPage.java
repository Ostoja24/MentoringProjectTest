package PageObjects;
import data.DataClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){

        super(driver);
    }

    private final By usernameInput = By.xpath("//*[@id='username']");
    private final By passwordInput = By.xpath("//*[@id='password']");
    private final By loginButton = By.xpath("//*[@id='Login']");


    public SalesforcePageHeader submitLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
        return new SalesforcePageHeader(driver);
    }

    public LoginPage putKeysIntoFieldUsername(String usernameValue) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput)).sendKeys(usernameValue);
        return this;
    }

    public LoginPage putKeysIntoFieldPassword(String passwordValue) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(passwordValue);
        return this;
    }

    public void navigateToLoginUrl(WebDriver driver, String orgURL) {
        driver.get(orgURL);
    }
    public String returnPageTitle(WebDriver driver){
        return driver.getCurrentUrl();
    }

}
