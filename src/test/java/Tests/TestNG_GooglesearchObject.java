package Tests;

import POM_Pages.GoogleSearch_ByClass_ThisConstructor;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_GooglesearchObject {

    WebDriver driver = null;
    
    @BeforeTest
    public void TestSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();

//        WebDriverManager.edgedriver().setup();
//        driver = new EdgeDriver();

        //Safari WebBrowser//
        //WebDriverManager.safaridriver().setup();
        //driver = new SafariDriver();
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
    }
}
