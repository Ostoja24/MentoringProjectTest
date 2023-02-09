package PageObjects;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {


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

    private String pageTitle;
    private final static String ORG_INFORMATION = "src/test/java/data/data_login.json";


    public void LoginPageInit(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void submit() {
        loginButton.click();
    }

    public void putkeysUsername(String usernameValue) {
        usernameInput.sendKeys(usernameValue);
    }

    public void putkeysPassword(String passwordValue) {
        passwordInput.sendKeys(passwordValue);
    }

    public void navigateToLoginUrl(WebDriver driver, String orgURL) {
        driver.get(getUsernameAdmin());
    }
    public String returnPagetitle(){
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
