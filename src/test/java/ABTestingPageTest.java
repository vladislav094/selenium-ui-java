import application.pages.ABTestingPage;
import application.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static application.pages.ABTestingPage.AB_TESTING_PAGE_URL;
import static application.pages.ABTestingPage.TEXT_ON_PAGE;

public class ABTestingPageTest extends BaseTest {

    ABTestingPage abTestingPage = new ABTestingPage();

    @Test(description = "Проверяем содержание текста на странице")
    public void checkTextOnThePage() {

        String textOnCurrentPage = abTestingPage.getTextOnPage();
        Assert.assertEquals(textOnCurrentPage, TEXT_ON_PAGE);
    }

    @Test(description = "Проверяем URL текущей страницы")
    public void checkCurrentURL() {

        String currentUrl = abTestingPage.getPageURL();
        Assert.assertEquals(currentUrl, AB_TESTING_PAGE_URL);
    }

    @BeforeMethod(description = "Переходим по ссылке 'A/B Testing' на главной странице")
    private void clickABTestingLinkOnHomePage() {
        homePage.clickLink(HomePage.AB_TESTING_LINK);
    }
}
