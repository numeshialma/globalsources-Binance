package globalsources.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyFileReader;
import utils.TestApp;

import java.time.Duration;

public class SecuritySettingsPage {
    WebDriver driver;
    PropertyFileReader property=new PropertyFileReader();
    String activatedElement= property.getProperty("SecuritySettingsPage","activated.element");
    String countryCodeElement= property.getProperty("SecuritySettingsPage","country.code.element");
    String phoneNumberElement= property.getProperty("SecuritySettingsPage","phone.number.element");
    String sendButtonElement= property.getProperty("SecuritySettingsPage","send.button.element");

    public SecuritySettingsPage(WebDriver driver){
        this.driver=driver;
    }

    public SecuritySettingsPage activated(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath(activatedElement),
                Duration.ofSeconds(1000));
        driver.findElement(By.xpath(activatedElement)).click();
        return this;
    }
    public SecuritySettingsPage setCountryCode(String countryCode){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath(countryCodeElement),
                Duration.ofSeconds(1000));
        driver.findElement(By.xpath(countryCodeElement)).sendKeys(countryCode);
        return this;
    }

    public SecuritySettingsPage setPhoneNumber(String phoneNumber){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath(phoneNumberElement),
                Duration.ofSeconds(1000));
        driver.findElement(By.xpath(phoneNumberElement)).sendKeys(phoneNumber);
        return this;
    }

    public SecuritySettingsPage send(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath(sendButtonElement),
                Duration.ofSeconds(1000));
        driver.findElement(By.xpath(sendButtonElement)).click();
        return this;
    }

}
