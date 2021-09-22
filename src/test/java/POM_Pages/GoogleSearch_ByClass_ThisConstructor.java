package POM_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearch_ByClass_ThisConstructor {

    WebDriver driver = null;

    By AgreementConsent = By.xpath("//*[@id='L2AGLb']/div");
    By SearchTextBox = By.xpath("//div/input[@name='q']");

    public GoogleSearch_ByClass_ThisConstructor(WebDriver driver){
        this.driver = driver;
    }

    public void consentbutton(){
        driver.findElement(AgreementConsent).click();
    }

    public void Textbox_input(String Text_Value){
        driver.findElement(SearchTextBox).sendKeys(Text_Value);
        driver.findElement(SearchTextBox).sendKeys(Keys.RETURN);
    }
}
