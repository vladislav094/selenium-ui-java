package playground;

import application.pages.playground.DynamicTablePage;
import application.pages.playground.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static application.pages.playground.DynamicTablePage.DYNAMIC_TABLE_PAGE_URL;


public class DynamicTableTest extends BaseTest {

    DynamicTablePage dynamicTablePage = new DynamicTablePage();

    @BeforeMethod(description = "Переходим по ссылке 'A/B Testing' на главной странице")
    private void clickABTestingLinkOnHomePage() {
        homePage.clickLink(HomePage.DYNAMIC_TABLE_LINK);
    }

    @Test
    public void checkIndexCpu() {

        String expected = dynamicTablePage.getSearchValue();
        String actual = dynamicTablePage.getCPUValue(dynamicTablePage.getHeaderIndex());
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Проверяем URL текущей страницы")
    public void checkCurrentURL() {

        String currentUrl = dynamicTablePage.getPageURL();
        Assert.assertEquals(currentUrl, DYNAMIC_TABLE_PAGE_URL);
    }
}
