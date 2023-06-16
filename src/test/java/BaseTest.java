import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONTokener;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;

public class BaseTest {
    // Variables used in Test Project

    private final static String ORG_INFORMATION = "C:\\Users\\tomcz\\IdeaProjects\\MentoringProjectTest\\src\\test\\java\\data\\data_login.json";
    private String usernameAdmin = "tomasz.ostojski@playful-bear-v3w7c0.com";
    private String passwordAdmin = "Koliber12!";
    private String orgURL = "https://playful-bear-v3w7c0-dev-ed.trailblaze.lightning.force.com";
    protected static WebDriver driver;


    @BeforeAll
    public static void setup_before_test()  {
        // Starting WebDriver
        WebDriverManager.chromedriver().setup();
        // Chrome Options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--remote-allow-origins=*", "disable-popup-blocking", "allow-silent-push", "disable-default-apps", "--disable-notifications");
        driver = new ChromeDriver(options);
    }


    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    // METHODS


    public String getUsernameAdmin() {
        return usernameAdmin;
    }


    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public String getOrgURL() {
        return orgURL;
    }


    public static String accountPhone()
    {
        return new Random().ints(9, 0, 10).mapToObj(Integer::toString).collect(Collectors.joining());

    }
    public static String randomNumbers(Integer numberofNumbers) {
        return new Random().ints(numberofNumbers, 0, 10).mapToObj(Integer::toString).collect(Collectors.joining());
    }
    public static Faker fakerObject(){
        return new Faker(Locale.of("pl"));
    }
}
