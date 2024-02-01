import application.pages.ChallengingDomPage;
import application.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static application.pages.ChallengingDomPage.COLUMNS_NAMING_ON_PAGE;

public class ChallengingDomTest extends BaseTest {

    ChallengingDomPage challengingDomPage = new ChallengingDomPage();

//    @BeforeMethod
    public void clickChallengingDomLinkOnHomePage() {
        homePage.clickLink(HomePage.CHALLENGING_DOM_LINK);
    }

//    @Test
    public void testOrderAndNameOfColumns() {
        ArrayList<String> currentColumnsNamingInTable = challengingDomPage.getColumnsNamingInTable();
        Assert.assertEquals(currentColumnsNamingInTable, COLUMNS_NAMING_ON_PAGE);
    }
}
