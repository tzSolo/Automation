package pages;

import enums.MainMenu;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public abstract class BtlBasePage {
    protected WebDriver driver;

    public BtlBasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ClickOnMainMenuItem(MainMenu item) {
        driver.findElement(By.id("ctl00_Topmneu_" + item)).click();
    }

    public void ClickOnSubMenuItem(String item) {
        driver.findElement(By.xpath(item)).click();
    }

    @FindBy(id = "TopQuestions")
    WebElement searchInput;

    @FindBy(name = "ctl00$SiteHeader$reserve$btnSearch")
    WebElement searchIcon;

    public void SearchingSomething(String something) {
        searchInput.sendKeys(something);
        searchIcon.click();
    }

    public SnifimPage ReturnInstanceOfSnifimPage() {
        driver.findElement(By.className("snifim")).click();
        return new SnifimPage(driver);
    }

    @FindBy(linkText = "אבטלה")
    WebElement avtalaLink;

    public void ClickOnAvtalaLink() {
        this.ClickOnMainMenuItem(MainMenu.HyperLink3);
        avtalaLink.click();
    }

    @FindBy(linkText = "ילד נכה")
    WebElement necheLink;

    public void ClickOnYeledNecheLink() {
        this.ClickOnMainMenuItem(MainMenu.HyperLink3);
        necheLink.click();
    }
}
