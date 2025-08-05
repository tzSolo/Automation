import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DmeiBituachPage;
import pages.HomePage;

import java.time.Duration;

public class DmeiBituachTest extends BaseTest {
    DmeiBituachPage dmeiBituachPage;
    HomePage homePage;

    public DmeiBituachTest() {
        this.dmeiBituachPage = new DmeiBituachPage(driver);
        this.homePage = new HomePage(driver);
    }

    @Test
    public void TestTitleOfPage() {
        homePage.ClickOnDmeiBituachLink();
        String titleOfPage = dmeiBituachPage.ReturnTheTitleOfPage();
        Assertions.assertEquals("דמי ביטוח לאומי", titleOfPage, "The title of page is incorrect.");
    }

    @Test
    public void TestClickOnTheCalculatorLink() {
        homePage.ClickOnDmeiBituachLink();
        dmeiBituachPage.ClickOnTheCalculatorLink();
    }
}
