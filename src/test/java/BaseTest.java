import org.json.JSONObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONTokener;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Duration;

public class BaseTest {
    // Variables used in Test Project

    private final static String ORG_INFORMATION = "C:\\Users\\tomcz\\IdeaProjects\\MentoringProjectTest\\src\\test\\java\\data\\data_login.json";
    private String getInfoOrg;
    private String usernameAdmin;
    private String passwordAdmin;
    private String orgURL;
    private String screenMode;
    protected static ChromeOptions options = new ChromeOptions();
    protected static WebDriver driver = new ChromeDriver(options);
    private int implicitWaitValue;


    @BeforeAll
    public static void setup_before_test() {
        // Starting WebDriver
        WebDriverManager.chromedriver().setup();}
        @BeforeEach
        public void setup_test () throws FileNotFoundException {
            // Chrome Options
            ChromeOptions options = new ChromeOptions();
            if (getScreenMode().equals("1")) {
                options.addArguments("--headless", "--no-sandbox", "--disable-gpu", "--windows-size=1920,1040","allow-silent-push", "--disable-notifications");
            } else {
                options.addArguments("--windows-size=1920,1040", "--ignore-certificate-errors", "--start-maximized","allow-silent-push");
            }
            driver = new ChromeDriver(options);

        }



        @AfterEach
        public void afterEachTest () {
            new allureScreenshotTestClass();
        }


        @AfterAll
        public static void teardown () {
            if (driver != null) {
                driver.close();
                driver.quit();
            }
        }

        // METHODS
        public JSONTokener getJsonObject() throws FileNotFoundException {
            return new JSONTokener(new FileReader(ORG_INFORMATION));
        }

        public void getSettings () throws FileNotFoundException {
            JSONObject obj_credentials = new JSONObject(getJsonObject());
            screenMode = obj_credentials.getString("screenmode");
        }

        public String getUsernameAdmin () {
            return usernameAdmin;
        }
        public void setUsernameAdmin (String usernameAdmin){
            this.usernameAdmin = usernameAdmin;
        }
        public String getPasswordAdmin () {
            return passwordAdmin;
        }

        public void setPasswordAdmin (String passwordAdmin){
            this.passwordAdmin = passwordAdmin;
        }

        public String getOrgURL () {
            return orgURL;
        }

        public void setOrgURL (String orgURL){
            this.orgURL = orgURL;
        }

    public String getScreenMode() throws FileNotFoundException {
        getSettings();
        return screenMode;
    }
    public void getCredentials() throws FileNotFoundException {
        JSONObject obj_credentials = new JSONObject(getJsonObject());
        usernameAdmin = obj_credentials.getString("username");
        passwordAdmin = obj_credentials.getString("password");
        orgURL = obj_credentials.getString("orgURL");
    }
    public void setScreenMode(String screenMode) {
        this.screenMode = screenMode;

    }
    public String getGetInfoOrg() {
        return getInfoOrg;
    }

    public void setGetInfoOrg(String getInfoOrg) {
        this.getInfoOrg = getInfoOrg;
    }
    public void implicitwaittest(WebDriver driver){
        implicitWaitValue = 20;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitValue));
    }
    public Object explicitwaittest(WebDriver driver, WebElement element){
        return new WebDriverWait(driver,Duration.ofSeconds(implicitWaitValue)).until(ExpectedConditions.visibilityOf(element));
    }
}

