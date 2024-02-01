import application.pages.CheckboxesPage;
import application.pages.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckboxesPageTest extends BaseTest{

    CheckboxesPage checkboxesPage = new CheckboxesPage();

//    @Test
    public void  testCheckboxes() {
        homePage.clickLink(HomePage.CHECKBOX_LINK);
        boolean initialStateOfCheckbox1 = checkboxesPage.isChecked(checkboxesPage.checkbox1);
        boolean initialStateOfCheckbox2 = checkboxesPage.isChecked(checkboxesPage.checkbox2);

        checkboxesPage.manageCheckbox(checkboxesPage.checkbox1);

        boolean actualStateOfCheckbox1 = checkboxesPage.isChecked(checkboxesPage.checkbox1);
        boolean actualStateOfCheckbox2 = checkboxesPage.isChecked(checkboxesPage.checkbox2);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(initialStateOfCheckbox1);
        softAssert.assertTrue(initialStateOfCheckbox2);
        softAssert.assertTrue(actualStateOfCheckbox1);
        softAssert.assertTrue(actualStateOfCheckbox2);
        softAssert.assertAll();

    }
}
