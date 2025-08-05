import enums.MainMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import pages.HomePage;
import pages.SnifimPage;

public class HomeTest extends BaseTest {
    private HomePage homePage;

    public HomeTest() {
        this.homePage = new HomePage(this.driver);
    }

    @Test
    public void IsTheCorrectPageLoaded() {
        homePage.SearchingSomething("חישוב סכום דמי לידה ליום");
        String expectedTitle = "תוצאות חיפוש עבור חישוב סכום דמי לידה ליום";
        Assertions.assertEquals(driver.getTitle(), expectedTitle, "The page title did not match the expected title.");
    }

    @Test
    public void IsSnifimPageLoaded() {
        homePage.ReturnInstanceOfSnifimPage();
        Assertions.assertEquals("https://www.btl.gov.il/snifim/Pages/default.aspx", driver.getCurrentUrl(), "The current url did not match the expected url.");
    }

    @Test
    public void TestClickOnDmeiBituachLink() {
        homePage.ClickOnDmeiBituachLink();
    }

    @Test
    public void ClickOnYeledNecheLink() {
        homePage.ClickOnYeledNecheLink();
    }

    @ParameterizedTest
    @ValueSource(strings={"","","",""})
    public void ClickOnMainMenuItems(String link){
        homePage.ClickOnMainMenuItem(MainMenu.HyperLink3);
        driver.findElement(By.linkText(link)).click();
    }
}
