package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.constant.Constable;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver){
        super(driver);
    }
    private static final String xpathaccounttab = "//span[normalize-space()='Accounts']"
    @FindBy(xpath = xpathaccounttab)
    private static WebElement AccountTab;

    public void AccountTabClick(){
        AccountTab.click();
    };

    public void HomePageInit(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static WebElement getAccountTab() {
        return AccountTab;
    }

    public static String  getAccountTabPath(){
        return AccountTab.getAttribute("xpath");
    }

    public static void setAccountTab(WebElement accountTab) {
        AccountTab = accountTab;
    }
}
