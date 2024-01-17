package application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject {

    protected final String HOME_URL = "https://the-internet.herokuapp.com/";
    public static final By abTestingLink = By.xpath("//ul/li/a[text()='A/B Testing']");

    public void clickLink(By link) {
        driver.findElement(link).click();
    }

    public void openURL() {
        driver.get(HOME_URL);
    }
}
