import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ReportManager {
    private static ExtentReports extent;

    public static void initReport() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("target/ExtentReport/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static ExtentReports getExtent() {
        if (extent == null) {
            initReport();
        }
        return extent;
    }

    public static void endReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
