import org.json.JSONObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    // Variables used in Test Project


    private final static String ORG_INFORMATION = "src/test/java/data/data_login.json";
    private String getInfoOrg;
    private String usernameAdmin;
    private String passwordAdmin;
    private String orgURL;
    private String screenMode;
    protected WebDriver driver;
    @BeforeAll
    public void setup_before_test() {

        getInfoOrg = System.getProperty(ORG_INFORMATION); // Ścieżka dostępu do jsona z danymi dostępowymi
        // Starting WebDriver
        WebDriverManager.chromedriver().setup();
        // Chrome Options
        ChromeOptions options = new ChromeOptions();
        if ("headless".equals(screenMode)) {
            options.addArguments("--headless", "--no-sandbox", "--disable-gpu","--windows-size=1920,1040");
        }
        else {
            options.addArguments("--windows-size=1920,1040", "--ignore-certificate-errors", "--start-maximized");
        }
        driver = new ChromeDriver(options);
    @AfterAll
    public void teardown() {
            if (driver != null) {
                driver.close();
                driver.quit();
            }
        }

        // METHODS

    public void getCredentials () {
        JSONObject obj_credentials = new JSONObject(getCredentialsOrg);
        usernameAdmin = obj_credentials.getString("username");
        passwordAdmin = obj_credentials.getString("password");
        orgURL = obj_credentials.getString("org_url");
        }
    public void getSettings() {
        JSONObject obj_credentials = new JSONObject(getCredentialsOrg);
        screenMode = obj_credentials.getString("screenmode");
    }

        public void get_Enviroment_data () {

        }


    }

    private void teardown() {
    }
}

