package heroku;

import application.pages.heroku.ContextMenuPage;
import application.pages.heroku.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static application.pages.heroku.CheckboxesPage.CHECKBOXES_HEADER_ON_PAGE;
import static application.pages.heroku.CheckboxesPage.CHECKBOXES_PAGE_URL;
import static application.pages.heroku.ContextMenuPage.CONTEXT_MENU_HEADER_ON_PAGE;
import static application.pages.heroku.ContextMenuPage.CONTEXT_MENU_PAGE_URL;
import static application.pages.heroku.HomePage.getHeaderWithNamePageInContent;

public class ContextMenuTest extends BaseTest{

    ContextMenuPage contextMenuPage = new ContextMenuPage();

    @BeforeMethod(description = "Переходим по ссылке 'Context Menu' на главной странице")
    private void clickContextMenuLinkOnHomePage() {
        contextMenuPage.clickLink(HomePage.CONTEXT_MENU_LINK);
    }

    @Test(description = "Кликаем правой кнопкой мыши по выделенной области на странице и подверждаем действие в контекстно меню")
    public void testContextMenu() {

        contextMenuPage.rightClickHotSpot();
        contextMenuPage.acceptAlert();
    }

    @Test(description = "Проверяем главный заголовок на странице")
    public void testMainHeaderOnPage() {

        String currentHeaderWihNamePage = getHeaderWithNamePageInContent();
        Assert.assertEquals(currentHeaderWihNamePage, CONTEXT_MENU_HEADER_ON_PAGE);
    }

    @Test(description = "Проверяем URL текущей страницы")
    public void testCurrentURL() {

        String currentUrl = contextMenuPage.getPageURL();
        Assert.assertEquals(currentUrl, CONTEXT_MENU_PAGE_URL);
    }
}
