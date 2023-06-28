import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestWatcherAllure implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable throwable) {
        if (BaseTest.driver != null) {
            // Screenshot Creation
            TakesScreenshot screenshot = (TakesScreenshot) BaseTest.driver;
            File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);

            // Attach Screenshot to Allure Report
            try {
                Allure.addAttachment("Failure Screenshot", new FileInputStream(screenshotFile));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
