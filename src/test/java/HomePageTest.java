import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;


import java.sql.SQLOutput;
import java.time.Duration;

public class HomePageTest {

    private WebDriver driver;
    private WebElement element;
    private WebElement username;

    public WebElement getElement() {
        return element;
    }

    @BeforeAll
    static void setup_driver_before_test(){
        try {
            BaseTest.setupwebdriver();
        }
        catch (Exception e){
                System.out.println("Cannot launch driver");
            }

    }
    @BeforeEach
    static void driver_to_test(){
        BaseTest.setup_newdriver_to_test();
    }
    BaseTest.setup_newdriver_to_test();


    @AfterEach
    BaseTest.teardown();
    @Test
    void login_and_check_page_title() extends BaseTest  {
        //Login to the environment
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Globalny Wait
        driver.get("https://playful-bear-v3w7c0-dev-ed.trailblaze.lightning.force.com/");
        WebElement username = driver.findElement(By.xpath("//*[@id='username']"));
        WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
        username.sendKeys("tomasz.ostojski@playful-bear-v3w7c0.com");
        password.sendKeys("7513328D516D673AE189B9ECE5C9E10A");
        driver.findElement(By.xpath("//*[@id='Login']")).click();
        //Find Page Title
        WebElement PageTitle = driver.findElement(By.xpath("//*[@class='slds-truncate']"));
        Assertions.assertThat(PageTitle.getText()).isEqualTo("Setup");

    }
}
