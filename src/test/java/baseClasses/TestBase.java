package baseClasses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.Date;

public class TestBase {

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    static Date d = new Date();
    static String fileName = "Execution_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
    public static Logger log = LogManager.getLogger("devpinoyLogger");

    //public WebDriver driver;
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    protected static ThreadLocal<ExtentReports> reports = new ThreadLocal<>();

    @BeforeSuite
    public void setUpTestBed() {

        System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sunil\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Sunil\\Downloads\\edgedriver_win64\\msedgedriver.exe");

        htmlReporter = new ExtentHtmlReporter("E:\\JAVA_Selenium\\NewSelenium\\target\\surefire-reports\\" + fileName);
//        reports.get().createTest("Starting");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        /*extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
        extent.setSystemInfo("Environment", "Automation Testing");
        extent.setSystemInfo("User Name", "Rajkumar SM");

        htmlReporter.config().setDocumentTitle("Title of the Report Comes here");
        htmlReporter.config().setReportName("Name of the Report Comes here");
        htmlReporter.config().setTheme(Theme.DARK);*/
        htmlReporter.loadXMLConfig("src/resources/extentConfig.xml");
    }

    @BeforeTest
    public void startReporter() {
       /* htmlReporter = new ExtentHtmlReporter("E:\\JAVA_Selenium\\NewSelenium\\target\\surefire-reports\\" + fileName);
//        reports.get().createTest("Starting");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        *//*extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
        extent.setSystemInfo("Environment", "Automation Testing");
        extent.setSystemInfo("User Name", "Rajkumar SM");

        htmlReporter.config().setDocumentTitle("Title of the Report Comes here");
        htmlReporter.config().setReportName("Name of the Report Comes here");
        htmlReporter.config().setTheme(Theme.DARK);*//*
        htmlReporter.loadXMLConfig("src/resources/extentConfig.xml");*/

    }

    @Parameters("browserNameXML")
    @BeforeMethod(alwaysRun = true)
    public void startBrowser(String browserNameXML) throws Exception {

        log.info("Log4j files");

        logger = extent.createTest("Test started");
        logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));

        if (browserNameXML.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
            if (driver.get() != null) {
                logger.log(Status.INFO, "chrome driver");
            }

            System.out.println(Thread.currentThread().getId());
        } else if (browserNameXML.equalsIgnoreCase("firefox")) {
            driver.set(new FirefoxDriver());

            System.out.println(Thread.currentThread().getId());
        } else if (browserNameXML.equalsIgnoreCase("edge")) {
            driver.set(new EdgeDriver());

            System.out.println(Thread.currentThread().getId());
        } else {
            throw new Exception("Unsupported browser exception");
        }

        //driver.get().get("https://www.seleniumeasy.com/test/table-records-filter-demo.html#");

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.get().quit();
        }
        // reports.get().flush();

    }

    @AfterTest
    public void endReporter() {
        extent.flush();
    }
}
