import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.SnifimPage;

import java.util.List;

public class SnifimTest extends BaseTest {
    private HomePage homePage;

    public SnifimTest() {
        this.homePage = new HomePage(driver);
    }

    @Test
    public void IsTheSnifContainsTheExpectedData() {
        SnifimPage snifimPage = homePage.ReturnInstanceOfSnifimPage();
        snifimPage.ClickOnSingleSnif("אשקלון");
        List<WebElement> dataList = snifimPage.GetSnifDataList();
        List<String> labelsText = snifimPage.GetLabelsText(dataList);
        Assertions.assertArrayEquals(labelsText.subList(0, 3).toArray(), new String[]{"כתובת", "קבלת קהל", "מענה טלפוני"}, "The expected labels didnt found.");
    }
}
