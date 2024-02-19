package heroku;

import application.pages.heroku.CheckboxesPage;
import application.pages.heroku.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static application.pages.heroku.CheckboxesPage.CHECKBOXES_HEADER_ON_PAGE;
import static application.pages.heroku.CheckboxesPage.CHECKBOXES_PAGE_URL;
import static application.pages.heroku.HomePage.getHeaderWithNamePageInContent;

public class CheckboxesPageTest extends BaseTest{

    CheckboxesPage checkboxesPage = new CheckboxesPage();

    @BeforeMethod(description = "Переходим по ссылке 'Checkboxes' на главной странице")
    private void clickCheckboxesLinkOnHomePage() {
        checkboxesPage.clickLink(HomePage.CHECKBOX_LINK);
    }

    @Test(description = "Убрать флажки со всех чек-боксов и проверить, что чек-боксы не выбраны")
    public void checkThatAllCheckboxesIsNotSelectedAfterUncheck() {

        checkboxesPage.uncheckAll();
        checkboxesPage.assertThatCheckboxesAreSelected(false);
    }

    @Test(description = "Установить флажкит во все чек-боксы и проверить, что чек-боксы выбраны")
    public void checkThatAllCheckboxesIsSelectedAfterCheck() {

        checkboxesPage.selectAll();
        checkboxesPage.assertThatCheckboxesAreSelected(true);
    }

    @Test(description = "Проверяем главный заголовок на странице")
    public void testMainHeaderOnPage() {

        String currentHeaderWihNamePage = getHeaderWithNamePageInContent();
        Assert.assertEquals(currentHeaderWihNamePage, CHECKBOXES_HEADER_ON_PAGE);
    }

    @Test(description = "Проверяем URL текущей страницы")
    public void testCurrentURL() {

        String currentUrl = checkboxesPage.getPageURL();
        Assert.assertEquals(currentUrl, CHECKBOXES_PAGE_URL);
    }
}
