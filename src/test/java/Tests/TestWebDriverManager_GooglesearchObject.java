package Tests;

import POM_Pages.GoogleSearch_ByClass_ThisConstructor;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWebDriverManager_GooglesearchObject {

    public static void main(String[] args) throws Exception {
        search();
    }

    public static void search() throws Exception{

        WebDriver driver = null;

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();

//        WebDriverManager.edgedriver().setup();
//        driver = new EdgeDriver();

        //Safari WebBrowser//
        //WebDriverManager.safaridriver().setup();
        //driver = new SafariDriver();
        //Maximizing the Window//
        driver.manage().window().maximize();
        driver.get("https://google.com");

        GoogleSearch_ByClass_ThisConstructor googleSearchByClassThisConstructor = new GoogleSearch_ByClass_ThisConstructor(driver);

        googleSearchByClassThisConstructor.consentbutton();

        googleSearchByClassThisConstructor.Textbox_input("Selenium tests");

        System.out.println("Test Successful");

        driver.close();
        //driver.quit();
    }
}
