import application.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static application.pages.HomePage.abTestingLink;

public class TheInternetTest extends BaseTest {
    private static final String EXPECTED_URL = "https://the-internet.herokuapp.com/abtest";
    HomePage homePage = new HomePage();

    @Test
    public void locatorTest() {
        homePage.openURL();
        homePage.clickLink(abTestingLink);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, EXPECTED_URL);
    }
}
