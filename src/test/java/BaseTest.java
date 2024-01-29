import application.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static application.pages.BasePage.setDriver;
import static org.assertj.core.api.Assertions.assertThat;

abstract public class BaseTest {

    protected static WebDriver driver;

    HomePage homePage = new HomePage();

    @BeforeClass
    public void initDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(getOptions());
        }
        setDriver(driver);
        System.out.println("Init Driver was successful.");
    }

    private ChromeOptions getOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        return options;
    }

    @AfterMethod
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    public void sendHeadRequestAndCheckStatusCode(String link, int expectedStatusCode) {

        HttpURLConnection urlConnection = null;
        int actualStatusCode = 0;
        try {
            urlConnection = (HttpURLConnection) (new URL(link)).openConnection();
            urlConnection.setRequestMethod("HEAD");
            actualStatusCode = urlConnection.getResponseCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertThat(actualStatusCode)
                .as("Код ответа не соответствует ожидаемому")
                .isEqualTo(expectedStatusCode);
    }
}
