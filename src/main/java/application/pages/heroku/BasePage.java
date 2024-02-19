package application.pages.heroku;

import com.codeborne.selenide.WebDriverRunner;

public class BasePage {

    public String getPageURL() {
        return WebDriverRunner.url();
    }
}
