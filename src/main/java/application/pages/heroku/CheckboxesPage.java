package application.pages.heroku;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckboxesPage extends HomePage {

    public static final String CHECKBOXES_HEADER_ON_PAGE = "Checkboxes1";
    public static final String CHECKBOXES_PAGE_URL = "https://the-internet.herokuapp.com/checkboxes";

    private static final SelenideElement checkbox1 = $x("//form[@id='checkboxes']/input[0]");
    private static final SelenideElement checkbox2 = $x("//form[@id='checkboxes']/input[1]");
    private static final ElementsCollection allCheckboxes = $$x("//form[@id='checkboxes']/input");

    public void manageCheckbox(SelenideElement checkbox) {
        checkbox.click();
    }

    public boolean isChecked(SelenideElement checkbox) {
        return checkbox.isSelected();
    }

    public void selectAll() {
        allCheckboxes.iterator().forEachRemaining(element -> {
            if (!element.isSelected()) {
                element.click();
            }
        });
    }

    public void uncheckAll() {
        allCheckboxes.iterator().forEachRemaining(element -> {
            if (element.isSelected()) {
                element.click();
            }
        });
    }

    public void assertThatCheckboxesAreSelected(boolean expectedState) {
        assertThat(allCheckboxes)
                .allSatisfy(checkbox -> assertThat(checkbox.isSelected())
                        .as("Checkbox is not in the expected state: " + checkbox)
                        .isEqualTo(expectedState));
    }
}
