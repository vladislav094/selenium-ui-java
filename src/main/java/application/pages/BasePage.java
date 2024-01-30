package application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public String getPageURL() {
        return driver.getCurrentUrl();
    }

    protected static WebElement findElement(By locator) {
        return driver.findElement(locator);
    }
}
