package application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {

//    Actions actions = new Actions(driver);

    protected final String HOME_URL = "https://the-internet.herokuapp.com/";
    public static final By abTestingLink = By.xpath("//ul/li/a[text()='A/B Testing']");
    public static final By basicAuthLink = By.xpath("//div/div/ul/li[3]/a");

    //Названия ссылок (страницы) на главной страницы
    public static final String AB_TESTING_LINK = "A/B Testing";
    public static final String ADD_REMOVE_ELEMENTS_LINK = "Add/Remove Elements";
    public static final String BASIC_AUTH_LINK = "Basic Auth";
    public static final String BROKEN_IMAGES_LINK = "Broken Images";
    public static final String CHALLENGING_DOM_LINK = "Challenging DOM";
    public static final String CHECKBOX_LINK = "Checkboxes";
    public static final String CONTEXT_MENU_LINK = "Context Menu";

    public void clickLink(String link) {
        driver.get(HOME_URL);
        driver.findElement(By.linkText(link)).click();
    }
}
