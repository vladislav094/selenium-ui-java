package application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ChallengingDomPage extends BasePage {

    By answerPayload = By.xpath("//canvas[@id='canvas']");

    public final By button = By.xpath("//div/a[@class='button']");
    public final By buttonAlert = By.xpath("//div/a[@class='button alert']");
    public final By buttonSuccess = By.xpath("//div/a[@class='button success']");

    //получаем canvas изображение со страницы
    public String getAnswer() {
        return driver.findElement(answerPayload).getText();
    }

    public void clickButton(By locator) {
        driver.findElement(locator).click();
    }
}
