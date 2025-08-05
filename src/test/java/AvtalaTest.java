import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.AvtalaPage;
import pages.HomePage;

public class AvtalaTest extends BaseTest {
    AvtalaPage avtalaPage;
    HomePage homePage;

    public AvtalaTest() {
        this.avtalaPage = new AvtalaPage(driver);
        this.homePage = new HomePage(driver);
    }

    @Test
    public void ClacDmeiAvtala() {
        homePage.ClickOnAvtalaLink();
        avtalaPage.ClickOnCalculatorLink();
        avtalaPage.ClickOnDmaiAvtalaLink();
        avtalaPage.EnterPiturimDate("1/05/2025");
        avtalaPage.ClickOnAgeOver28();
        avtalaPage.ClickOnContinueButton();
        avtalaPage.EnterSalaryInputs();
        avtalaPage.ClickOnContinueButton();
        String h3OfResults = avtalaPage.ResultsOfCalc();
        String expectedH3 = "תוצאות חישוב";
        Assertions.assertEquals(expectedH3, h3OfResults, "An error occurred.");
    }

    @Test
    public void TestTheResultsText() {
        homePage.ClickOnAvtalaLink();
        avtalaPage.ClickOnCalculatorLink();
        avtalaPage.ClickOnDmaiAvtalaLink();
        avtalaPage.EnterPiturimDate("1/05/2025");
        avtalaPage.ClickOnAgeOver28();
        avtalaPage.ClickOnContinueButton();
        avtalaPage.EnterSalaryInputs();
        avtalaPage.ClickOnContinueButton();
        Assertions.assertArrayEquals(new String[]{"דמי אבטלה לחודש (לפי 25 ימים)", "דמי אבטלה ליום", "שכר יומי ממוצע לצורך חישוב דמי אבטלה"}, avtalaPage.ResultsText().toArray(), "An error occurred.");
    }
}
