import application.pages.BrokenImagesPage;
import application.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import static application.pages.BasicAuthPage.BASIC_AUTH_PAGE_URL;
import static application.pages.BrokenImagesPage.BROKEN_IMAGES_HEADER_ON_PAGE;
import static application.pages.BrokenImagesPage.BROKEN_IMAGES_PAGE_URL;

public class BrokenImagesTest extends BaseTest {

    BrokenImagesPage brokenImagesPage = new BrokenImagesPage();

    @Test
    public void checkAllBrokenImages() {

        ArrayList<String> brokenImagesList = brokenImagesPage.getAllBrokenImagesLinks();
        checkThatAllBrokenImagesLinkHave404StatusCode(brokenImagesList);
    }

    @Test void checkMainHeaderOnPage() {
        String currentHeaderWihNamePage = brokenImagesPage.getHeaderWithNamePageInContent();
        Assert.assertEquals(currentHeaderWihNamePage, BROKEN_IMAGES_HEADER_ON_PAGE);
    }

    @Test(description = "Проверяем URL текущей страницы")
    public void checkCurrentURL() {

        String currentUrl = brokenImagesPage.getPageURL();
        Assert.assertEquals(currentUrl, BROKEN_IMAGES_PAGE_URL);
    }

    @BeforeMethod(description = "Переходим по ссылке 'Broken Images' на главной странице")
    private void clickBrokenImageLinkOnHomePage() {
        homePage.clickLink(HomePage.BROKEN_IMAGES_LINK);
    }

    public void checkThatAllBrokenImagesLinkHave404StatusCode(ArrayList<String> brokenImagesList) {
        for (String link: brokenImagesList) {
            sendHeadRequestAndCheckStatusCode(link, 404);
        }
    }
}
