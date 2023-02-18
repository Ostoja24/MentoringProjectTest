package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(xpath = "//span[@class='slds-truncate'][normalize-space()='Accounts']")
    private static WebElement AccountTab;

    public void AccountTabClick(WebDriver driver){
        AccountTab.click();
    };

    public void HomePageInit(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static WebElement getAccountTab() {
        return AccountTab;
    }

    public static void setAccountTab(WebElement accountTab) {
        AccountTab = accountTab;
    }
}
