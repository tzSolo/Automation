package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DmeiBituachPage extends BtlBasePage {

    public DmeiBituachPage(WebDriver driver) {
        super(driver);
    }

    public String ReturnTheTitleOfPage() {
        return driver.findElement(By.id("lbl_title")).getText();
    }

    public void ClickOnTheCalculatorLink() {
        driver.findElement(By.linkText("מחשבון לחישוב דמי הביטוח")).click();
    }
}
