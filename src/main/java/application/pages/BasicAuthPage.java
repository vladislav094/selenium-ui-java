package application.pages;

import org.openqa.selenium.By;

public class BasicAuthPage extends BasePage {

    public static final String BASIC_AUTH_PAGE_URL = "https://the-internet.herokuapp.com/basic_auth";
    private static final String BASIC_AUTH_PATTERN = "https://%s:%s@the-internet.herokuapp.com/basic_auth";

    //content
    public static final String BASIC_AUTH_HEADER_ON_PAGE = "Basic Auth";
    public static final String SUCCESS_AUTH_TEXT = "Congratulations! You must have the proper credentials.";

    //locators
    public static final By basicAuthHeader = By.xpath("//div[@class='example']/h3");
    public static final By successfulAuthenticationContent = By.xpath("//div[@class='example']/p");

    //methods for interacting with web elements
    public void loginOnBaseAuth(String login, String password) {
        driver.get(String.format(BASIC_AUTH_PATTERN, login, password));
    }

    public String getHeaderWithNamePageInContent() {
        return findElement(basicAuthHeader).getText().trim();
    }

    public String getTextAboutSuccessAuthInPageContent() {
        return findElement(successfulAuthenticationContent).getText().trim();
    }
}
