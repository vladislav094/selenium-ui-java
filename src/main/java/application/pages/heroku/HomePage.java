package application.pages.heroku;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage {


    protected final String HOME_URL = "https://the-internet.herokuapp.com/";
    public static final SelenideElement abTestingLink = $x("//ul/li/a[text()='A/B Testing']");
    public static final SelenideElement basicAuthLink = $x("//div/div/ul/li[3]/a");
    private static final SelenideElement headerOnPage = $x("//div[@class='example']/h3");

    //Названия ссылок (страницы) на главной страницы
    public static final String AB_TESTING_LINK = "A/B Testing";
    public static final String ADD_REMOVE_ELEMENTS_LINK = "Add/Remove Elements";
    public static final String BASIC_AUTH_LINK = "Basic Auth";
    public static final String BROKEN_IMAGES_LINK = "Broken Images";
    public static final String CHALLENGING_DOM_LINK = "Challenging DOM";
    public static final String CHECKBOX_LINK = "Checkboxes";
    public static final String CONTEXT_MENU_LINK = "Context Menu";

    public void clickLink(String link) {
        $(By.linkText(link)).click();
    }

    public static String getHeaderWithNamePageInContent() {
        return headerOnPage.getText();
    }
}
