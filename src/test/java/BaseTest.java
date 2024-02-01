import application.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import static application.pages.BasePage.setDriver;
import static org.assertj.core.api.Assertions.assertThat;

abstract public class BaseTest {

    protected static WebDriver driver;

    HomePage homePage = new HomePage();

    @BeforeMethod
    public void initDriver() {
        String browserName = System.getProperty("driver", "chrome");
        if (driver == null) {
            switch (browserName) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(getOptions());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new ChromeDriver(getOptions());
                    break;
                default:
                    System.out.println("Неверное имя браузера");
            }
        }
        setDriver(driver);
        System.out.println("Init Driver was successful.");
    }

    private ChromeOptions getOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
//        options.addArguments("--headless"); // без графического отображения браузерного окна
        return options;
    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.close();
//        driver.quit();
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

    public String getFromProperties(String key) {
        String value = null;
        try(InputStream inputStream = new FileInputStream("~/project")){
            Properties prop = new Properties();
            prop.load(inputStream);
            value = prop.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
