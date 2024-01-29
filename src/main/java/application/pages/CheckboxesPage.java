package application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckboxesPage extends HomePage {

    public By checkbox1 = By.xpath("//from[@id='checkboxes']/input[0]");
    public By checkbox2 = By.xpath("//from[@id='checkboxes']/input[1]");

    public void manageCheckbox(By checkbox) {
        driver.findElement(checkbox).click();
    }

    public boolean isChecked(By checkbox) {
        return driver.findElement(checkbox).isSelected();
    }
}
