package application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static application.constants.JavaScriptExecutorPath.CHECK_BROKEN_IMAGE_IN_LIST_EXECUTOR;
import static application.utils.FileDataReader.readFile;


public class BrokenImagesPage extends HomePage {

    public static final String BROKEN_IMAGES_PAGE_URL = "https://the-internet.herokuapp.com/broken_images";

    //content
    public static final String BROKEN_IMAGES_HEADER_ON_PAGE = "Broken Images";

    //locators
    public static final By linksWithImages = By.xpath("//div[@class='example']/img");
    public static final By brokenImagesHeader = By.xpath("//div[@class='example']/h3");

    public List<WebElement> getListElementsWithImageLinks() {
        return new ArrayList<>(driver.findElements(linksWithImages));
    }

    public String getHeaderWithNamePageInContent() {
        return driver.findElement(brokenImagesHeader).getText();
    }

    /**
     * Метод выполняет итерацию по элементам коллекции с ссылками на изображения. Для каждого элемента выполняет
     * JavaScript-код, который проверяет, является ли изображение битым. В положительном случае выводит запись
     * в стандартный поток вывода, а также ссылка с битым изображением добавляется в коллекцию с результатом.
     *
     * @return коллекцию с ссылками на битые изображения
     */
    public ArrayList<String> getAllBrokenImagesLinks() {
        ArrayList<String> brokenImages = new ArrayList<>();
        for (WebElement element : getListElementsWithImageLinks()) {
            String imageUrl = element.getAttribute("src");
            Boolean isBrokenImage = (Boolean) ((JavascriptExecutor) driver)
                    .executeScript(readFile(CHECK_BROKEN_IMAGE_IN_LIST_EXECUTOR), imageUrl);
            if (!isBrokenImage) {
                System.out.println("Это битая картинка: " + imageUrl);
                brokenImages.add(imageUrl);
            }
        }
        return brokenImages;
    }
}

