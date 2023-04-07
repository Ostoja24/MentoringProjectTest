package PageObjects;
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
    private final By homeButton = By.xpath("//a[@class='tabHeader slds-context-bar__label-action ']//span[@class='title slds-truncate'][normalize-space()='Home']");


    public SalesforcePageHeader submitLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
        return new SalesforcePageHeader(driver);
    }

    public LoginPage putkeysUsername(String usernameValue) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput)).sendKeys(usernameValue);
        return this;
    }

    public LoginPage putkeysPassword(String passwordValue) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(passwordValue);
        return this;
    }

    public void navigateToLoginUrl(WebDriver driver, String orgURL) {
        driver.get(orgURL);
    }
    public String returnPagetitle(WebDriver driver){
        return driver.getCurrentUrl();
    }

}
