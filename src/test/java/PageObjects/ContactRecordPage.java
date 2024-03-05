package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactRecordPage extends BasePage {
    private final String getFieldContactRecordText = "//span[text()='<fieldName>']/ancestor::*//lightning-formatted-name";
    private final By clickDetailsContact = By.xpath("(//a[@data-tab-value='detailTab'])[2]");

    private final String getFieldContactRecordAddress = "//records-record-layout-item[@field-label='<addressField>']//a";
    private final By clickEditName = By.xpath("//div/button[@title='Edit Name'][1]");
    private final By lastNameField = By.xpath("//input[@placeholder='Last Name']");
    private final By saveButton = By.xpath("//button[@name='SaveEdit']");
    private final String getFieldContactRecordPhoneMailText  = "//span[text()='<fieldName>']/ancestor::dl/..//a";
    private final By detailsComponent = By.xpath("//div[@class=\"windowViewMode-normal oneContent active lafPageHost\"]//records-record-layout-block");
    public ContactRecordPage(WebDriver driver) {super(driver);}

    public ContactRecordPage clickDetailsContact (){
        wait.until(ExpectedConditions.elementToBeClickable(clickDetailsContact)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(detailsComponent));
        return this;
    }

    public String getFieldContactRecordText (String fieldName){
        String replaceFieldContactRecordXpath = getFieldContactRecordText.replace("<fieldName>",fieldName);
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(replaceFieldContactRecordXpath))).getText();
    }
    public String getFieldContactRecordPhoneAndEmail(String fieldName) {
        String replaceFieldContactRecordPhoneMailXpath = getFieldContactRecordPhoneMailText.replace("<fieldName>", fieldName);
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(replaceFieldContactRecordPhoneMailXpath))).getText();
    }
    public ContactRecordPage clickEditName (){
        wait.until(ExpectedConditions.elementToBeClickable(clickEditName)).click();
        return this;
    }
    public ContactRecordPage changeLastName(String lastNameText){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(lastNameText);
        return this;
    }
    public ContactRecordPage clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
        return this;
    }
}
