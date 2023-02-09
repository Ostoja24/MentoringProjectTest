package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Accounts {

    @FindBy(xpath = "//div[@title='New']")
    private WebElement NewButton;


    public void AccountDetailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnNewAccountButton(){
        NewButton.click();
    }
}

