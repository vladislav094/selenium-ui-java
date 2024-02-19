package application.pages.playground;

import com.codeborne.selenide.WebDriverRunner;

public class BasePage {
    public String getPageURL() {
        return WebDriverRunner.url();
    }
}
//Dynamic Table