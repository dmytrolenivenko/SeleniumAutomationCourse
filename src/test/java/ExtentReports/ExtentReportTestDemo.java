package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportTestDemo {

    public static ExtentReports getExtentReports() {
        ExtentReports extent = new ExtentReports();
        //Extent Report, 
        //ExtentSparkReporter - Expects path where reporter should be created
        String path = System.getProperty("user.dir") + "\\report\\IndexColorModel.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("First Try in Reports");
        reporter.config().setDocumentTitle("Getting into this");

        extent.attachReporter(reporter);
        extent.setSystemInfo("Dmytro", "Automation Tester");
        extent.flush();
        return extent;
    }
}
