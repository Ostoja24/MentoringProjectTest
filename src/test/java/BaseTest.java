import org.json.JSONObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

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
            options.addArguments("--headless", "--no-sandbox", "--disable-gpu", "--windows-size=1920,1040");
        } else {
            options.addArguments("--windows-size=1920,1040", "--ignore-certificate-errors", "--start-maximized");
        }
        driver = new ChromeDriver(options);
        // Junit listener launching
        JUnitCore junit = new JUnitCore();
        junit.addListener(new ScreenshotListener((TakesScreenShots) webDriver));
        @AfterEach


        @AfterAll
        public void teardown () {
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
        public void getSettings () {
            JSONObject obj_credentials = new JSONObject(getCredentialsOrg);
            screenMode = obj_credentials.getString("screenmode");
        }
        public String ScreenshotReportAllure () {
            Path directory = Paths.get("report/allure-report-selenium-SF");
        }

    }

public static class ScreenshotListener extends RunListener {

       private TakesScreenshot screenshotTaker;

            @Override
            public void testFailure(Failure failure) throws Exception {
                File file = screenshotTaker.getScreenshotAs(OutputType.File);


            }
        }}

