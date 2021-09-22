package Tests;

import POM_Pages.GoogleSearch_ByClass_ThisConstructor;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import config.ReadWriteToConfigProperties;

public class Browsersetinpropfile_Googlesearch {

    WebDriver driver = null;
    public static String browsername = null;
    
    @BeforeTest
    public void TestSetup() {

        ReadWriteToConfigProperties.readfrompropertiesfile();

        if (browsername.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        else if(browsername.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        else if (browsername.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        else if (browsername.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
    }


    @Test
    public void search() throws Exception{

        //Maximizing the Window//
        driver.manage().window().maximize();
        driver.get("https://google.com");

        GoogleSearch_ByClass_ThisConstructor googleSearchByClassThisConstructor = new GoogleSearch_ByClass_ThisConstructor(driver);

        googleSearchByClassThisConstructor.consentbutton();

        googleSearchByClassThisConstructor.Textbox_input("Selenium tests");

    }

    @AfterTest
    public void teardown(){
        System.out.println("Test Successful");

        driver.close();
        //driver.quit();
        ReadWriteToConfigProperties.writetopropertiesfile();
    }
}
