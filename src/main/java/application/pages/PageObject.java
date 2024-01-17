package application.pages;

import org.openqa.selenium.WebDriver;

public class PageObject {
    protected static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        PageObject.driver = driver;
    }
}
