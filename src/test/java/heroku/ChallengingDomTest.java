package heroku;

import application.pages.heroku.ChallengingDomPage;
import application.pages.heroku.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;

import static application.pages.heroku.ChallengingDomPage.COLUMNS_NAMING_ON_PAGE;

public class ChallengingDomTest extends BaseTest {

    ChallengingDomPage challengingDomPage = new ChallengingDomPage();

    @BeforeMethod
    public void clickChallengingDomLinkOnHomePage() {
        homePage.clickLink(HomePage.CHALLENGING_DOM_LINK);
    }

//    @Test
    public void testOrderAndNameOfColumns() {
        ArrayList<String> currentColumnsNamingInTable = challengingDomPage.getColumnsNamingInTable();
        Assert.assertEquals(currentColumnsNamingInTable, COLUMNS_NAMING_ON_PAGE);
    }
}
