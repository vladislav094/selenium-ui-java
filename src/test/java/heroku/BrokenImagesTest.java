package heroku;

import application.pages.heroku.BrokenImagesPage;
import application.pages.heroku.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static application.pages.heroku.BrokenImagesPage.*;

public class BrokenImagesTest extends BaseTest {

    BrokenImagesPage brokenImagesPage = new BrokenImagesPage();

    @BeforeMethod(description = "Переходим по ссылке 'Broken Images' на главной странице")
    private void clickBrokenImageLinkOnHomePage() {
        homePage.clickLink(HomePage.BROKEN_IMAGES_LINK);
    }

    @Test(description = "Проверяем, что все ссылки на битые картинки возвращают 404 статус код")
    public void testAllBrokenImages() {

        List<String> brokenImagesList =  brokenImagesPage.getLinksToBrokenImages();
        checkThatAllBrokenImagesHave404StatusCode(brokenImagesList);
    }

    @Test(description = "Проверяем количество битых изображений на странице")
    public void testCountOfBrokenImagesOnPage() {
        checkThatCountOfBrokenImagesEqualsTo(brokenImagesPage.getAllImages(), 2);
    }

    @Test(description = "Проверяем главный заголовок на странице")
    public void testMainHeaderOnPage() {

        String currentHeaderWihNamePage = getHeaderWithNamePageInContent();
        Assert.assertEquals(currentHeaderWihNamePage, BROKEN_IMAGES_HEADER_ON_PAGE);
    }

    @Test(description = "Проверяем URL текущей страницы")
    public void testCurrentURL() {

        String currentUrl = brokenImagesPage.getPageURL();
        Assert.assertEquals(currentUrl, BROKEN_IMAGES_PAGE_URL);
    }
}
