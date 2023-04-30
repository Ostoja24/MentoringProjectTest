package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountListPage extends BasePage {
    private final By accountNewButton = By.xpath("//div[@title='New']");

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    public AccountFormPage clicknewAccountButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountNewButton)).click();
        return new AccountFormPage(driver);
    }
}
