package heroku;

import application.pages.heroku.AddRemoveElementsPage;
import application.pages.heroku.HomePage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static com.codeborne.selenide.Condition.*;

public class AddRemoveElementsPageTest extends BaseTest {

    AddRemoveElementsPage addRemoveElementsPage = new AddRemoveElementsPage();

    @BeforeMethod(description = "Переходим по ссылке 'Add/Remove Elements' на главной странице")
    private void clickAddRemoveLinkOnHomePage() {
        homePage.clickLink(HomePage.ADD_REMOVE_ELEMENTS_LINK);
    }

    @Test(description = "Проверка кликабельности кнопки Add Element и наличие новых элементов клике")
    public void checkThatAddButtonClickableAndAddsNewElements() {

        int countOfClick = 5;
        addRemoveElementsPage.clickAddElementButton(countOfClick);
        int countDeleteButtons = addRemoveElementsPage.getDeleteButtonList().size();
        Assert.assertEquals(countDeleteButtons, countOfClick);
    }


    @Test(description = "Проверка кликабельности кнопки Delete и удаление элементов при клике")
    public void checkClickabilityDeleteButtonAndDeletingElements() {

        int countOfClick = 5;
        addRemoveElementsPage.clickAddElementButton(countOfClick);
        addRemoveElementsPage.clickDeleteButton(countOfClick);

        ElementsCollection elements = addRemoveElementsPage.getDeleteButtonList();

        for (SelenideElement element: elements) {
            element.shouldNotBe(visible);
        }

    }
}
