import org.json.JSONObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONTokener;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class BaseTest {
    // Variables used in Test Project

    private final static String ORG_INFORMATION = "C:\\Users\\tomcz\\IdeaProjects\\MentoringProjectTest\\src\\test\\java\\data\\data_login.json";
    private String usernameAdmin = "tomasz.ostojski@playful-bear-v3w7c0.com";
    private String passwordAdmin = "7513328D516D673AE189B9ECE5C9E10A";
    private String orgURL = "https://playful-bear-v3w7c0-dev-ed.trailblaze.lightning.force.com";
    private String screenMode;
    private final int implicitWaitValue = 20;
    protected static WebDriver driver;


    @BeforeAll
    public static void setup_before_test() {
        // Starting WebDriver
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setup_test() throws FileNotFoundException {
        // Chrome Options
        ChromeOptions options = new ChromeOptions();
        if (getScreenMode().equals("1")) {
            options.addArguments("--headless", "--no-sandbox", "--disable-gpu", "--windows-size=1920,1040", "allow-silent-push", "--disable-notifications", "--remote-allow-origins=*");
        } else {
            options.addArguments("--windows-size=1920,1040", "--ignore-certificate-errors", "--start-maximized", "allow-silent-push", "--disable-notifications", "--remote-allow-origins=*");
        }
        driver = new ChromeDriver(options);

    }


    @AfterEach
    public void afterEachTest() {
        new allureScreenshotTestClass();
    }


    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    // METHODS
    public JSONTokener getJsonObject() throws FileNotFoundException {
        return new JSONTokener(new FileReader(ORG_INFORMATION));
    }

    public void getSettings() throws FileNotFoundException {
        JSONObject obj_credentials = new JSONObject(getJsonObject());
        screenMode = obj_credentials.getString("screenmode");
    }

    public String getUsernameAdmin() {
        return usernameAdmin;
    }


    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public String getOrgURL() {
        return orgURL;
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

}

