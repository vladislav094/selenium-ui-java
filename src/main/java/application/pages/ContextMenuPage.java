package application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage extends HomePage {

    By contextArea = By.xpath("//div[@id='hot-spot']");

    public static final String EXPECTED_TEXT = "You selected a context menu";

    private WebElement contextAreaElement() {
        return driver.findElement(contextArea);
    }

//    public void manageContextArea() {
//        actions.contextClick(contextAreaElement()).build().perform();
//    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void confirmAlert() {
        driver.switchTo().alert().accept();
    }
}
