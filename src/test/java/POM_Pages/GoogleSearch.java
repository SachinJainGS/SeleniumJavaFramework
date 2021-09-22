package POM_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearch {

    private static WebElement element = null;

    public static void AgreeConsent(WebDriver driver){

        driver.findElement(By.xpath("//*[@id='L2AGLb']/div")).isDisplayed();
        driver.findElement(By.xpath("//*[@id='L2AGLb']/div")).click();
    }

    public static WebElement Search_text_box(WebDriver driver){

        element = driver.findElement(By.xpath("//div/input[@name='q']"));
        return element;
    }
}

