package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected final WebDriverWait wait;
    protected final WebDriverWait wait30;
    protected WebDriver driver;
    protected Actions actions;
    public Integer implicitWaitfield = 20;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(implicitWaitfield));
        this.wait30 = new WebDriverWait(driver, Duration.ofSeconds(30));
        Actions actions = new Actions(driver);
//        PageFactory.initElements(driver, this);
    }}

