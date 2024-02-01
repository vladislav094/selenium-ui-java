import application.pages.BasicAuthPage;
import application.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static application.pages.BasicAuthPage.*;

public class BasicAuthPageTest extends BaseTest {

    BasicAuthPage basicAuthPage = new BasicAuthPage();

//    @BeforeMethod(description = "Переходим по ссылке 'Basic Auth' на главной странице")
//    private void clickBasicAuthLinkOnHomePage() {
//        homePage.clickLink(HomePage.BASIC_AUTH_LINK);
//    }

    @Test(description = "Проверка авторизации. Проверяем заголовок настранице и текст об успешной авторизации")
    public void checkLoginInBaseAuthentication() {

        String LOGIN_AND_PASS = "admin";
        homePage.clickLink(HomePage.BASIC_AUTH_LINK);
        basicAuthPage.loginOnBaseAuth(LOGIN_AND_PASS, LOGIN_AND_PASS);
        String currentHeaderWihNamePage = basicAuthPage.getHeaderWithNamePageInContent();
        String currentTextInPageAfterSuccessAuth = basicAuthPage.getTextAboutSuccessAuthInPageContent();

        Assert.assertEquals(currentHeaderWihNamePage, BASIC_AUTH_HEADER_ON_PAGE);
        Assert.assertEquals(currentTextInPageAfterSuccessAuth, SUCCESS_AUTH_TEXT);
    }

    @Test(description = "Проверяем URL текущей страницы")
    public void checkCurrentURL() {
        homePage.clickLink(HomePage.BASIC_AUTH_LINK);
        String currentUrl = basicAuthPage.getPageURL();
        Assert.assertEquals(currentUrl, BASIC_AUTH_PAGE_URL);
    }
}