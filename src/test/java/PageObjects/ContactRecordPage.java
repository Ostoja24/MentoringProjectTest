package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactRecordPage extends BasePage {
    private final String getFieldContactRecordText = "//span[text()='<fieldName>']/ancestor::*//lightning-formatted-name";
    private final By clickDetailsContact = By.xpath("//div[@class='windowViewMode-normal oneContent active lafPageHost']/..//a[@data-tab-value='detailTab']");
    public ContactRecordPage(WebDriver driver) {super(driver);}

    public ContactRecordPage clickDetailsContact (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickDetailsContact)).click();
        return this;
    }

    public String getFieldContactRecordText (String fieldName){
        String replaceFieldContactRecordXpath = getFieldContactRecordText.replace("<fieldName>",fieldName);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(replaceFieldContactRecordXpath))).getText();
    }
}
