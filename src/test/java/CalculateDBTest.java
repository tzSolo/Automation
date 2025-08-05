import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CalculateDBPage;
import pages.DmeiBituachPage;
import pages.HomePage;

public class CalculateDBTest extends BaseTest {
    HomePage homePage;
    DmeiBituachPage dmeiBituachPage;
    CalculateDBPage calculateDBPage;

    public CalculateDBTest() {
        this.homePage = new HomePage(driver);
        this.dmeiBituachPage = new DmeiBituachPage(driver);
        this.calculateDBPage = new CalculateDBPage(driver);
        homePage.ClickOnDmeiBituachLink();
        dmeiBituachPage.ClickOnTheCalculatorLink();
    }

    @Test
    public void TestReturnTitleOfPage() {
        String calculateTitle = calculateDBPage.ReturnTitleOfPage();
        Assertions.assertEquals("חישוב דמי ביטוח עבור עצמאי, תלמיד, שוהה בחוץ לארץ ומי שלא עובד", calculateTitle, "The title is not the expected.");
    }

    @Test
    public void SelectFirstStepInput() {
        calculateDBPage.SelectTheFirstStep();
        calculateDBPage.ClickToContinueToStep2();
        String expectedTitle = "צעד שני\n" +
                "אתה נמצא בשלב 2 מתוך 3";
        Assertions.assertEquals(expectedTitle, calculateDBPage.ReturnStepTitle(), "Something went wrong its not the second step");
    }

    @Test
    public void SelectSecondStepInput() {
        calculateDBPage.SelectTheFirstStep();
        calculateDBPage.ClickToContinueToStep2();
        calculateDBPage.SelectTheSecondStep();
        calculateDBPage.ClickToContinueToStep3();
        String expectedTitle = "סיום";
        Assertions.assertEquals(expectedTitle, calculateDBPage.ReturnStepTitle(), "Something went wrong its not the last step");
    }

    @Test
    public void TestTheSummaryOfCalc() {
        String expectedData = "סך הכל דמי ביטוח לחודש: 163 ש\\\"ח.";
        Assertions.assertEquals(expectedData, calculateDBPage.SummaryOfCalc(), "The summary is not matched.");
    }
}
