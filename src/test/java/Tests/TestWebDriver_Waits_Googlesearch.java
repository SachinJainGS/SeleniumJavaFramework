package Tests;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class TestWebDriver_Waits_Googlesearch {

    public static void main(String[] args) throws Exception {

        WebDriver driver = null;
        String Location_path = System.getProperty("user.dir");

        System.setProperty("webdriver.chrome.driver",Location_path + "/.idea/WebDrivers/chromedriver");
        driver = new ChromeDriver();

        //Implicit Wait for current Session
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);


//        System.setProperty("webdriver.edge.driver",Location_path + "/.idea/WebDrivers/msedgedriver");
//        driver = new EdgeDriver();

//        System.setProperty("webdriver.gecko.driver",Location_path + "/.idea/WebDrivers/geckodriver");
//        driver = new FirefoxDriver();

        //Safari WebBrowser//
        //driver = new SafariDriver();
        //Maximizing the Window//
        driver.manage().window().maximize();
        driver.get("https://selenium.dev/");

        //Explicit Wait for a particular element of the Session
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[span='abcd']")));

        //Fluent Wait for specific element of the Session to set own max wait, pooling frequency and ignore exceptions
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30,TimeUnit.SECONDS)
                .pollingEvery(5,TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                WebElement link = driver.findElement(By.xpath("//a[span='abcd']"));

                if (link.isEnabled()){
                    link.click();
                }
                return link;
            }
        });

        //driver.findElement(By.xpath("//a[span='downloads']")).click();

        driver.close();
        //driver.quit();
    }

}
