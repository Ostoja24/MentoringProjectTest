package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactRecordPage extends BasePage {
    private final String getFieldContactRecordText = "//span[text()='<fieldName>']/ancestor::*//lightning-formatted-name";
    private final By clickDetailsContact = By.xpath("(//a[@data-tab-value='detailTab'])[2]");

    private final String getFieldContactRecordAdress = "//records-record-layout-item[@field-label='<adressField>']//a";
    private final By clickEditName = By.xpath("(//div/button[@title='Edit Name'])[1]");
    private final By lastNameField = By.xpath("//input[@placeholder='Last Name']");
    private final By saveButton = By.xpath("//button[@name='SaveEdit']");
    public ContactRecordPage(WebDriver driver) {super(driver);}

    public ContactRecordPage clickDetailsContact (){
        wait.until(ExpectedConditions.elementToBeClickable(clickDetailsContact)).click();
        return this;
    }

    public String getFieldContactRecordText (String fieldName){
        String replaceFieldContactRecordXpath = getFieldContactRecordText.replace("<fieldName>",fieldName);
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(replaceFieldContactRecordXpath))).getText();
    }
    public String getFieldContactRecordAdress (String adressName){
        String replaceFieldContactRecordXpath = getFieldContactRecordAdress.replace("<adressField>",adressName);
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(replaceFieldContactRecordXpath))).getText();
    }
    public ContactRecordPage clickEditName (){
        wait.until(ExpectedConditions.elementToBeClickable(clickEditName)).click();
        return this;
    }
    public ContactRecordPage changeLastName(String lastNameText){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(lastNameText);
        return this;
    }
    public ContactRecordPage clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
        return this;
    }
}
