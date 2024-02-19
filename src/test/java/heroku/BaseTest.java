package heroku;

import application.pages.heroku.HomePage;
import application.utils.AllureListener;
import application.utils.AllureServeExecutionListener;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static application.propertiesManagement.PropertiesConstants.HEROKU_URL;
import static application.propertiesManagement.PropertiesReader.getFromProjectProperties;
import static com.codeborne.selenide.Selenide.open;

@Listeners({AllureListener.class, AllureServeExecutionListener.class})
public class BaseTest {

    HomePage homePage = new HomePage();

    @BeforeMethod
    public void setupConfigurations() {
        Configuration.browser = "chrome";
//        Configuration.headless = true;
    }

    @BeforeMethod
    public void initDriver() {
        open(getFromProjectProperties(HEROKU_URL));
    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }
}
