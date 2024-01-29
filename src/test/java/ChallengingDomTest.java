import application.pages.ChallengingDomPage;
import application.pages.HomePage;
import org.testng.annotations.Test;

public class ChallengingDomTest extends BaseTest {

    ChallengingDomPage challengingDomPage = new ChallengingDomPage();

    @Test
    public void changeAnswerByClickOnButton() {
        homePage.clickLink(HomePage.CHALLENGING_DOM_LINK);
        challengingDomPage.clickButton(challengingDomPage.button);
    }
}
