package application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChallengingDomPage extends BasePage {

    //constants
    public static final String CHALLENGING_DOM_PAGE_URL = "https://the-internet.herokuapp.com/challenging_dom";
    public static final String CHALLENGING_DOM_HEADER_ON_PAGE = "Challenging DOM";
    public static final String TEXT_ON_PAGE = "The hardest part in automated web testing is finding the best locators " +
            "(e.g., ones that well named, unique, and unlikely to change). It's more often than not that the application" +
            " you're testing was not built with this concept in mind. This example demonstrates that with unique IDs, " +
            "a table with no helpful locators, and a canvas element.";
    public static final ArrayList<String> COLUMNS_NAMING_ON_PAGE = new ArrayList<>(Arrays.asList("Lorem", "Ipsum", "Dolor",
            "Sit", "Amet", "Action", "Diceret"));

    //locators
    public final By challengingDomHeader = By.xpath("//div[@class='example']/h3");
    public final By textOnPage = By.xpath("//div[@class='example']/p");
    public final By button = By.xpath("//div/a[@class='button']");
    public final By buttonAlert = By.xpath("//div/a[@class='button alert']");
    public final By buttonSuccess = By.xpath("//div/a[@class='button success']");
    public final By tableOnPage = By.xpath("//div[contains(@class, 'large')]//th");

    public void clickButton(By locator) {
        findElement(locator).click();
    }

    public String getChallengingDomHeaderOnPage() {
        return findElement(challengingDomHeader).getText().trim();
    }

    public String getTextOnPage() {
        return findElement(textOnPage).getText().trim();
    }

    public ArrayList<String> getColumnsNamingInTable() {
        List<String> columnsName = driver.findElements(tableOnPage)
                .stream()
                .map(WebElement::getText)
                .toList();
        return new ArrayList<>(columnsName);
    }
}
