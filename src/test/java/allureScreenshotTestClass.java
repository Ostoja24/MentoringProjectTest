import io.qameta.allure.Allure;
import org.junit.platform.engine.TestExecutionResult.Status;
import java.util.Base64;

import org.junit.platform.engine.TestExecutionResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class allureScreenshotTestClass {

    private TestExecutionResult testExecutionResult;

    public byte[] getScreenshotAsByteArray(WebDriver driver) throws Exception {
        TakesScreenshot screenshoter = (TakesScreenshot) driver;
        return screenshoter.getScreenshotAs(OutputType.BYTES);
    }

    public void afterEach(WebDriver driver) throws Exception {
        if (testExecutionResult.getStatus() == Status.FAILED) {
            byte[] screenshot = getScreenshotAsByteArray(driver);
            String screenshotBase64 = Base64.getEncoder().encodeToString(screenshot);
            Allure.addAttachment("Screenshot", "text/plain", screenshotBase64);
        }
    }
}
