import org.json.JSONObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONTokener;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.stream.Collectors;

public class BaseTest {
    // Variables used in Test Project

    private final static String ORG_INFORMATION = "C:\\Users\\tomcz\\IdeaProjects\\MentoringProjectTest\\src\\test\\java\\data\\data_login.json";
    private String usernameAdmin = "tomasz.ostojski@playful-bear-v3w7c0.com";
    private String passwordAdmin = "Koliber12!";
    private String orgURL = "https://playful-bear-v3w7c0-dev-ed.trailblaze.lightning.force.com";
    private static String screenMode;
    private final int implicitWaitValue = 20;
    protected static WebDriver driver;


    @BeforeAll
    public static void setup_before_test() throws FileNotFoundException {
        // Starting WebDriver
        WebDriverManager.chromedriver().setup();
        // Chrome Options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--remote-allow-origins=*", "disable-popup-blocking", "allow-silent-push", "disable-default-apps", "--disable-notifications");
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
    public static JSONTokener getJsonObject() throws FileNotFoundException {
        return new JSONTokener(new FileReader(ORG_INFORMATION));
    }

    public static void getSettings() throws FileNotFoundException {
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


    public static String getScreenMode() throws FileNotFoundException {
        getSettings();
        return screenMode;
    }

    public void getCredentials() throws FileNotFoundException {
        JSONObject obj_credentials = new JSONObject(getJsonObject());
        usernameAdmin = obj_credentials.getString("username");
        passwordAdmin = obj_credentials.getString("password");
        orgURL = obj_credentials.getString("orgURL");
    }

    public static String accountPhone()
    {
        return new Random().ints(9, 0, 10).mapToObj(Integer::toString).collect(Collectors.joining());

    }
    public static String randomNumbers() {
        return new Random().ints(5, 0, 10).mapToObj(Integer::toString).collect(Collectors.joining());
    }
}
