package playground;

import application.pages.playground.HomePage;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static application.propertiesManagement.PropertiesConstants.PLAYGROUND_URL;
import static application.propertiesManagement.PropertiesReader.getFromProjectProperties;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    HomePage homePage = new HomePage();

    @BeforeMethod
    public void initDriver() {
        open(getFromProjectProperties(PLAYGROUND_URL));
    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }
}
