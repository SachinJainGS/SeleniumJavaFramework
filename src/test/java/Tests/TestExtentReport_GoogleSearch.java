package Tests;


import POM_Pages.GoogleSearch_ByClass_ThisConstructor;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestExtentReport_GoogleSearch {

    public static void main(String[] args) {
        WebDriver driver = null;

        ExtentSparkReporter htmlreport = new ExtentSparkReporter("ExtentReport.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlreport);

        ExtentTest test = extent.createTest("FirstTest");
        test.log(Status.INFO,"Start of the test");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        test.log(Status.INFO,"Browser Initiated");

        //Maximizing the Window//
        driver.manage().window().maximize();
        driver.get("https://google.com");
        test.log(Status.PASS,"Google Page openned");

        GoogleSearch_ByClass_ThisConstructor googleSearchByClassThisConstructor = new GoogleSearch_ByClass_ThisConstructor(driver);

        googleSearchByClassThisConstructor.consentbutton();
        test.log(Status.PASS,"Consent Accepted");

        googleSearchByClassThisConstructor.Textbox_input("Selenium tests");
        test.log(Status.PASS,"Search text Box value entered");

        driver.close();
        test.log(Status.PASS,"Browser Closed");

        extent.flush();

    }
}
