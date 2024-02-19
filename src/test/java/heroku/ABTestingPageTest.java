package heroku;

import application.pages.heroku.ABTestingPage;
import application.pages.heroku.HomePage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static application.pages.heroku.ABTestingPage.AB_TESTING_PAGE_URL;
import static application.pages.heroku.ABTestingPage.TEXT_ON_PAGE;

public class ABTestingPageTest extends BaseTest {

    ABTestingPage abTestingPage = new ABTestingPage();

    @BeforeMethod(description = "Переходим по ссылке 'A/B Testing' на главной странице")
    private void clickABTestingLinkOnHomePage() {
        homePage.clickLink(HomePage.AB_TESTING_LINK);
    }

    @Test(description = "Проверяем содержание текста на странице")
    @Epic("The internet")
    @Feature("Контент на страницах")
    @Story("Текст на странице")
    @Severity(SeverityLevel.TRIVIAL)
    public void checkTextOnThePage() {

        String textOnCurrentPage = abTestingPage.getTextOnPage();
        Assert.assertEquals(textOnCurrentPage, TEXT_ON_PAGE);
    }

    @Test(description = "Проверяем URL текущей страницы")
    public void checkCurrentURL() {

        String currentUrl = abTestingPage.getPageURL();
        Assert.assertEquals(currentUrl, AB_TESTING_PAGE_URL);
    }
}
