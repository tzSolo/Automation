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

public class SnifimPage extends BtlBasePage {

    public SnifimPage(WebDriver driver) {
        super(driver);
    }

    public void ClickOnSingleSnif(String snifName) {
        driver.findElement(By.linkText(snifName)).click();
    }

    @FindBy(xpath = "//li[contains(@class, 'tbl-row')]//div[contains(@class, 'tbl-cell')]//label")
    List<WebElement> dataList;

    public List<WebElement> GetSnifDataList() {
        return dataList;
    }

    public List<String> GetLabelsText(List<WebElement> labels) {
        List<String> labelsText = new ArrayList<>();
        for (WebElement label : labels) {
            labelsText.add(label.getText());
        }
        return labelsText;
    }
}
