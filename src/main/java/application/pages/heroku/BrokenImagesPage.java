package application.pages.heroku;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static application.constants.HtmlAttribute.SRC;
import static application.httphelpers.HttpRequests.sendRequestWithHeadMethodAndCheckStatusCode;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;


public class BrokenImagesPage extends HomePage {

    //constants
    public static final String BROKEN_IMAGES_PAGE_URL = "https://the-internet.herokuapp.com/broken_images";
    public static final String BROKEN_IMAGES_HEADER_ON_PAGE = "Broken Images";

    //locators
    private static final ElementsCollection allImages = $$x("//div[@class='example']/img");

    public ElementsCollection getAllImages() {
        return allImages;
    }

    public List<String> getLinksToImages() {
        List<String> result = new ArrayList<>();
        for (SelenideElement element: allImages) {
            result.add(element.getAttribute(SRC));
        }
        return result;
    }

    public  List<String> getLinksToBrokenImages() {
        List<String> result = new ArrayList<>();
        for (SelenideElement element: allImages) {
            if (!element.isImage()) {
                result.add(element.getAttribute(SRC));
            }
        }
        return result;
    }

    @Step("Проверяем 404 статус код при переходе по ссылке битого изображения")
    public static void checkThatAllBrokenImagesHave404StatusCode(List<String> brokenImagesList) {
        brokenImagesList.forEach(link -> sendRequestWithHeadMethodAndCheckStatusCode(link, 404));
    }

    @Step("Провряем количество битых изображений")
    public static void checkThatCountOfBrokenImagesEqualsTo(ElementsCollection allImages, int expectedCountOfBrokenImages) {
        int actualCount = 0;
        for (SelenideElement elt: allImages) {
            if (!elt.isImage()) actualCount++;
        }
        assertThat(actualCount).as("Актуальное количество битых изображений не соответствует ожидаемому")
                .isEqualTo(expectedCountOfBrokenImages);
    }
}

