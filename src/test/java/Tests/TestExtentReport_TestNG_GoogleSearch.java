package Tests;

import POM_Pages.GoogleSearch_ByClass_ThisConstructor;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.ScreenCapture;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import org.testng.internal.InvokeMethodRunnable;

public class TestExtentReport_TestNG_GoogleSearch {
    WebDriver driver = null;
    ExtentSparkReporter htmlreport;
    ExtentReports extent;

    @BeforeSuite
    public void setup() {
        htmlreport = new ExtentSparkReporter("ExtentReport_TestNG.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlreport);
    }

    @BeforeTest
    public void setuptest(){
        WebDriverManager.chromedriver().setup();
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("start-maximized", true);
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setCapability("start-maximized",true);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
    }

    @Test
    public void test(){
        ExtentTest test = extent.createTest("FirstTest");
        test.log(Status.INFO,"Start of the test");

        GoogleSearch_ByClass_ThisConstructor googleSearchByClassThisConstructor = new GoogleSearch_ByClass_ThisConstructor(driver);

        googleSearchByClassThisConstructor.consentbutton();
        test.log(Status.PASS,"Consent Accepted");

        googleSearchByClassThisConstructor.Textbox_input("Selenium tests");
        test.log(Status.PASS,"Search text Box value entered");
    }

    @AfterTest
    public void teardowntest(){
        driver.close();
    }

    @AfterSuite
    public void teardown(){
        extent.flush();
    }
}
