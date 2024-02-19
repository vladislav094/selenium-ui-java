package application.pages.heroku;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ContextMenuPage extends HomePage {

    SelenideElement contextArea = $x("//div[@id='hot-spot']");
    public static final String CONTEXT_MENU_HEADER_ON_PAGE = "Context Menu";
    public static final String CONTEXT_MENU_PAGE_URL = "https://the-internet.herokuapp.com/context_menu";

    public void rightClickHotSpot() {
        contextArea.contextClick();
    }

    public void acceptAlert() {
        Selenide.switchTo().alert().accept();
    }
}
