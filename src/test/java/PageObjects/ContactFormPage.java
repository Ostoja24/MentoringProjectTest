package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactFormPage extends BasePage {
    public ContactFormPage(WebDriver driver){super(driver);}

    private final By salutationContact = By.xpath("//label[text()='Salutation']/..//button");
    private final String salutationContactOptionXpath = "//lightning-base-combobox-item[@data-value='<salutationName>']";
    private final String fieldContact = "//label[text()='<labelField>']/..//<fieldTypeName>";
    private final By mailingStreetField = By.xpath("//label[text()='Mailing Street']/..//textarea");


    public ContactFormPage clickSalutationContact(String contactSalutationValue) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(salutationContact)).click();
        String salutationContactOptionXpathReplace = salutationContactOptionXpath.replace("<salutationName>", contactSalutationValue);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(salutationContactOptionXpathReplace))).click();
        return this;
    }
    public ContactFormPage putIntoFieldInContactForm(String fieldLabelName,String fieldTypeName, String inputContactText){
        String fieldContactXpath = fieldContact.replace("<labelField>", fieldLabelName);
        fieldContactXpath = fieldContactXpath.replace("<fieldTypeName>",fieldTypeName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fieldContactXpath))).sendKeys(inputContactText);
        return this;
    }
    public ContactFormPage scrollIntoFieldMailingStreet() {
        WebElement mailingStreetElement = driver.findElement(mailingStreetField);
        scrollToElement(mailingStreetElement);
        return this;
    }
    public ContactFormPage clearFieldOnContactForm(String fieldLabelName,String fieldTypeName){
        String fieldContactXpath = fieldContact.replace("<labelField>", fieldLabelName);
        fieldContactXpath = fieldContactXpath.replace("<fieldTypeName>",fieldTypeName);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fieldContactXpath))).clear();
        return this;
    }

}
