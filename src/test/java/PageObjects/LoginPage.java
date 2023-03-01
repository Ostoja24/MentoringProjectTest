package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){

        super(driver);
    }


    private WebDriver driver;
    private String usernameValue;
    private String passwordValue;
    private String usernameAdmin;
    private String passwordAdmin;
    private String orgURL;

    private String getInfoOrg;
    @FindBy(xpath = "//*[@id='username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id='Login']")
    private WebElement loginButton;
    @FindBy(xpath = "//a[@class='tabHeader slds-context-bar__label-action ']//span[@class='title slds-truncate'][normalize-space()='Home']")
    private WebElement HomeButton;

    private String pageTitle;
    private final static String ORG_INFORMATION = "src/test/java/data/data_login.json";


    public void LoginPageInit(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void submit() {
        loginButton.click();
    }

    public LoginPage putkeysUsername(String usernameValue) {
        usernameInput.sendKeys(usernameValue);
        return this;
    }

    public LoginPage putkeysPassword(String passwordValue) {
        passwordInput.sendKeys(passwordValue);
        return this;
    }

    public void navigateToLoginUrl(WebDriver driver, String orgURL) {
        driver.get(orgURL);
    }
    public String returnPagetitle(WebDriver driver){
        return driver.getCurrentUrl();
    }

    public String getUsernameAdmin() {
        return usernameAdmin;
    }

    public void setUsernameAdmin(String usernameAdmin) {
        this.usernameAdmin = usernameAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    public String getOrgURL() {
        orgURL = System.getProperty(ORG_INFORMATION);
        return orgURL;
    }

    public void setOrgURL(String orgURL) {
        this.orgURL = orgURL;
    }


}
