package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CalculateDBPage extends BtlBasePage {

    public CalculateDBPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'container') and contains(@class, 'main')]//h1")
    WebElement titleOfPage;

    public String ReturnTitleOfPage() {
        return titleOfPage.getText();
    }

    @FindBy(id = "ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_rdb_employeType_2")
    WebElement inputCircleAvur;

    @FindBy(id = "ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_rdb_Gender_0")
    WebElement inputCircleMin;

    @FindBy(name = "ctl00$ctl43$g_642b1586_5c41_436a_a04c_e3b5ba94ba69$ctl00$InsuranceNotSachirWizard$DynDatePicker_BirthDate$Date")
    WebElement inputBornDate;

    public void SelectTheFirstStep() {
        inputCircleAvur.click();
        inputCircleMin.click();
        inputBornDate.sendKeys("1/11/2006");
    }

    @FindBy(id = "ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_StartNavigationTemplateContainerID_StartNextButton")
    WebElement continueButton1;

    public void ClickToContinueToStep2() {
        continueButton1.click();
    }

    public String ReturnStepTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ctl00$ctl43$g_642b1586_5c41_436a_a04c_e3b5ba94ba69$ctl00$InsuranceNotSachirWizard$StepNavigationTemplateContainerID$StepPreviousButton")));
        return driver.findElement(By.id("header")).getText();
    }

    public void SelectTheSecondStep() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement kitzvaNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ctl00$ctl43$g_642b1586_5c41_436a_a04c_e3b5ba94ba69$ctl00$InsuranceNotSachirWizard$rdb_GetNechut")));
        kitzvaNo.click();

        driver.findElement(By.name("ctl00$ctl43$g_642b1586_5c41_436a_a04c_e3b5ba94ba69$ctl00$InsuranceNotSachirWizard$rdb_GetNechut")).click();
    }


    public void ClickToContinueToStep3() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement continueButton2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ctl00$ctl43$g_642b1586_5c41_436a_a04c_e3b5ba94ba69$ctl00$InsuranceNotSachirWizard$StepNavigationTemplateContainerID$StepNextButton")));
        continueButton2.click();
    }

    @FindBy(xpath = "//ul[contains(@class, 'CalcResult')]//li")
    List<WebElement> resultData;

    public String SummaryOfCalc() {
        return resultData.get(2).getText();
    }
}
