import application.pages.ContextMenuPage;
import application.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static application.pages.ContextMenuPage.EXPECTED_TEXT;

public class ContextMenuTest extends BaseTest{

    ContextMenuPage contextMenuPage = new ContextMenuPage();

//    @Test
//    public void contextText() {
//
//        homePage.clickLink(HomePage.CONTEXT_MENU_LINK);
//        contextMenuPage.manageContextArea();
//
//        String alertText = contextMenuPage.getAlertText();
//
//        contextMenuPage.confirmAlert();
//
//        Assert.assertEquals(alertText, EXPECTED_TEXT);
//    }
}
