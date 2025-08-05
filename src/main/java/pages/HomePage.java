package pages;

import enums.MainMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BtlBasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[contains(@class, 'Insurance')]//ul/li/a")
    WebElement linkToDB;

    public void ClickOnDmeiBituachLink() {
        linkToDB.click();
    }
}
