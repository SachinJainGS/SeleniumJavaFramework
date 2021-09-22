package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import POM_Pages.GoogleSearch;

import java.util.List;

public class TestWebDriverManager_Googlesearch {

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

//        driver.findElement(By.xpath("//*[@id='L2AGLb']/div")).isDisplayed();
//        driver.findElement(By.xpath("//*[@id='L2AGLb']/div")).click();
       GoogleSearch.AgreeConsent(driver);

//        WebElement textbox = driver.findElement(By.xpath("//div/input[@name='q']"));
        GoogleSearch.Search_text_box(driver).sendKeys("Selenium");
        GoogleSearch.Search_text_box(driver).sendKeys(Keys.RETURN);
        
//        List<WebElement> listofobjects = driver.findElements(By.xpath("//div/input"));
//        int count = listofobjects.size();
//        System.out.println("count size is : "+count);

        System.out.println("Test Successful");

        driver.close();
        //driver.quit();
    }
}
