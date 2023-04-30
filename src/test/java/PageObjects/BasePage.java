package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    protected JavascriptExecutor js;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(implicitWaitfield));
        this.wait30 = new WebDriverWait(driver, Duration.ofSeconds(30));
        Actions actions = new Actions(driver);
        js = ((JavascriptExecutor) driver);

    }
    protected void scrollToElement(WebElement element){
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'})", element);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) { }
    }
    protected void clickElementJavaScript(WebElement element) {
        js.executeScript("arguments[0].click();", element);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) { }
    }

}

