import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class BaseTest {
    // Variables used in Test Project
    protected static WebDriver driver;


    @BeforeAll
    public static void setup_before_test()  {
        // Chrome Options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*", "disable-popup-blocking", "allow-silent-push", "disable-default-apps", "--disable-notifications","window-size=1920,1080");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
    }


    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

}
