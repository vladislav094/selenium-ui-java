package application.pages.playground;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class DynamicTablePage extends HomePage {

    public static final String DYNAMIC_TABLE_PAGE_URL = "https://uitestingplayground.com/dynamictable";

    private SelenideElement valueToeCheck = $x("//p[@class='bg-warning']");
    private ElementsCollection headers = $$x("//span[@role='columnheader']");
    private SelenideElement row = $x("//span[@role='cell' and text()='Chrome']/..");

    public String getSearchValue() {
        String initial = valueToeCheck.getText();
        return initial.split(" ")[2];
    }


    public int getHeaderIndex() {

        List<WebElement> elementList = WebDriverRunner.getWebDriver().findElements(By.xpath("//span[@role='columnheader']"));
        int index = 0;
        for (int i = 0; i < elementList.size(); i++) {
            String text = elementList.get(i).getText();
            System.out.println(text);
            if (text.equals("CPU")) {
                index = i;
                System.out.println(i);
            }
        }
        System.out.println(index+1);
        return index;
    }

    public String getCPUValue(int index) {
        return row.$x(String.format("./span[%s]", index + 1)).getText();
    }
}
