import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseTest {
    protected WebDriver driver;

    public BaseTest() {
        this.driver = new ChromeDriver();
        driver.get("https://www.btl.gov.il/");
        PageFactory.initElements(driver, this);
    }
}
