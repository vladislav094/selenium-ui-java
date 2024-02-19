package application.pages.heroku;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.stream.IntStream;

import static com.codeborne.selenide.Selenide.*;

public class AddRemoveElementsPage extends BasePage {

    private static final SelenideElement addButton = $x("//div[@class='example']/button[@onclick='addElement()']");

    private static final SelenideElement addCSSButton = $("div.example>button[onclick='addElement()'");

    private static final ElementsCollection deleteButtonList = $$x("//div[@id='elements']/button");

    public SelenideElement getAddButton() {
        return addButton;
    }

    public ElementsCollection getDeleteButtonList() {
        return deleteButtonList;
    }

    @Step("Выполняем клик по кнопке [AddElement]")
    public void clickAddElementButton(int clickCount) {
        IntStream.range(0, clickCount)
                .forEach(i -> addButton.click());
    }

    @Step("Выполняем клик по кнопке [Delete]")
    public void clickDeleteButton(int clickCount) {
        IntStream.iterate(clickCount - 1, i -> i - 1)
                .limit(clickCount)
                .forEach(i -> deleteButtonList.get(i).click());
    }
}
