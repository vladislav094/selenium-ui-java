package application.pages.playground;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {

    public static final String DYNAMIC_TABLE_LINK = "Dynamic Table";

    public void clickLink(String link) {
        $(By.linkText(link)).click();
    }
}
