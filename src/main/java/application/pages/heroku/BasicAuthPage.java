package application.pages.heroku;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class BasicAuthPage extends BasePage {

    public static final String BASIC_AUTH_PAGE_URL = "https://the-internet.herokuapp.com/basic_auth";
    private static final String BASIC_AUTH_PATTERN = "https://%s:%s@the-internet.herokuapp.com/basic_auth";

    //content
    public static final String BASIC_AUTH_HEADER_ON_PAGE = "Basic Auth";
    public static final String SUCCESS_AUTH_TEXT = "Congratulations! You must have the proper credentials.";

    //locators
    public static final SelenideElement successfulAuthenticationContent = $x("//div[@class='example']/p");

    //methods for interacting with web elements
    public void loginOnBaseAuth(String login, String password) {
        open(String.format(BASIC_AUTH_PATTERN, login, password));
    }

    public String getTextAboutSuccessAuthInPageContent() {
      return  successfulAuthenticationContent.getText();
    }
}
