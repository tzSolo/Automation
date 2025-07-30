package pages;

import enums.MainMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BtlBasePage {

    public void ClickOnMenuItem(WebDriver driver, MainMenu item) {
        driver.findElement(By.id("ctl00_Topmneu_" + item)).click();
        driver.close();
    }
}
