package application.pages.heroku;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$x;

public class ChallengingDomPage extends BasePage {

    //constants
    public static final String CHALLENGING_DOM_PAGE_URL = "https://the-internet.herokuapp.com/challenging_dom";
    public static final String CHALLENGING_DOM_HEADER_ON_PAGE = "Challenging DOM";
    public static final String TEXT_ON_PAGE = "The hardest part in automated web testing is finding the best locators " +
            "(e.g., ones that well named, unique, and unlikely to change). It's more often than not that the application" +
            " you're testing was not built with this concept in mind. This example demonstrates that with unique IDs, " +
            "a table with no helpful locators, and a canvas element.";
    public static final ArrayList<String> COLUMNS_NAMING_ON_PAGE = new ArrayList<>(Arrays.asList("Lorem", "Ipsum", "Dolor",
            "Sit", "Amet", "Diceret", "Action"));

    //locators
    public final SelenideElement textOnPage = $x("//div[@class='example']/p");
    public final SelenideElement button = $x("//div/a[@class='button']");
    public final SelenideElement buttonAlert = $x("//div/a[@class='button alert']");
    public final SelenideElement buttonSuccess = $x("//div/a[@class='button success']");
    public final SelenideElement tableOnPage = $x("//div[contains(@class, 'large')]//th");

    public void clickButton(By locator) {
    }

    public String getChallengingDomHeaderOnPage() {
        return "q";
    }

    public String getTextOnPage() {
        return "q";
    }

    public ArrayList<String> getColumnsNamingInTable() {
        return new ArrayList<>();
    }
}
