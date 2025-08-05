import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest {
    protected static WebDriver driver;

    public BaseTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.btl.gov.il/");
    }

    @BeforeEach
    public void InitTestReporter() {
        ReportManager.initReport();
    }

    @AfterEach
    public void CloseTestReporter() {
        ReportManager.endReport();
    }

    @AfterAll
    public static void CloseDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
