package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AvtalaPage extends BtlBasePage {

    public AvtalaPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'btl-rteElement-regularText')]//a")
    WebElement linkToCalculator;

    public void ClickOnCalculatorLink() {
        linkToCalculator.click();
    }

    @FindBy(linkText = "חישוב דמי אבטלה")
    WebElement linkToDA;

    public void ClickOnDmaiAvtalaLink() {
        linkToDA.click();
    }

    @FindBy(id = "ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_DynDatePicker_PiturimDate_Date")
    WebElement inputPiturimDate;

    public void EnterPiturimDate(String piturimDate) {
        inputPiturimDate.sendKeys(piturimDate);
    }

    @FindBy(id = "ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_rdb_age_1")
    WebElement inputYourAge;

    public void ClickOnAgeOver28() {
        inputYourAge.click();
    }

    public void EnterSalaryInputs() {
        List<WebElement> salaryInputs = driver.findElements(By.className("txtbox_sallary"));
        for (WebElement input : salaryInputs) {
            input.sendKeys("10000");
        }
    }

    public void ClickOnContinueButton() {
        WebElement continueButton2 = driver.findElement(By.className("btnNext"));
        continueButton2.click();
    }

    public String ResultsOfCalc() {
        return driver.findElement(By.className("bld")).getText();
    }

    public List<String> ResultsText() {
        List<WebElement> labelsTexts = driver.findElements(By.xpath("//div[contains(@class,'CalcResult')]//li/label"));
        List<String> texts = new ArrayList();
        for (WebElement label : labelsTexts) {
            texts.add(label.getText());
        }
        return texts;
    }
}
