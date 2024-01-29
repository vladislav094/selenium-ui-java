package application.pages;

import org.openqa.selenium.By;

public class ABTestingPage extends BasePage {

    public static final String AB_TESTING_PAGE_URL = "https://the-internet.herokuapp.com/abtest";
    public static final String TEXT_ON_PAGE = "Also known as split testing. This is a way in which businesses are able " +
            "to simultaneously test and learn different versions of a page to see which text and/or functionality works" +
            " best towards a desired outcome (e.g. a user action such as a click-through).";

    //locators
    public static final By textOnPage = By.xpath("//div[2]/div/div//p");

    public String getTextOnPage() {
        return driver.findElement(textOnPage).getText();
    }
}
