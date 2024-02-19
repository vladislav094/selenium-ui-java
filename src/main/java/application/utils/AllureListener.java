package application.utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.testng.*;

public class AllureListener implements ITestListener, IInvokedMethodListener {
    @Override
    public void onTestFailure(ITestResult testResult) {
        if (WebDriverRunner.hasWebDriverStarted()) {
            takeScreenshot();
        }
    }

    @Override
    public void onTestSkipped(ITestResult testResult) {
        if (WebDriverRunner.hasWebDriverStarted()) {
            takeScreenshot();
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }
}
