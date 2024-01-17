import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static application.pages.HomePage.setDriver;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeClass
    public static void initDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src/main/java/application/resources/drivers/chromedriver");
            driver = new ChromeDriver(getOptions());
        }
        setDriver(driver);
        System.out.println("Init Driver was successful");
    }

    private static ChromeOptions getOptions() {
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

    @AfterMethod(alwaysRun = true)
    public static void tearDown() {
        driver.quit();
    }
}
