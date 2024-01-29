package application.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public String getPageURL() {
        return driver.getCurrentUrl();
    }
}
