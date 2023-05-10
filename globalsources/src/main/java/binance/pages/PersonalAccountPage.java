package binance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.PropertyFileReader;
import utils.TestApp;

import java.time.Duration;

public class PersonalAccountPage {

    WebDriver driver;
    PropertyFileReader property=new PropertyFileReader();
    String clickPhoneNumberElement= property.getProperty("PersonalAccountPage","click.phone.number.element");
    String phoneNumberElement= property.getProperty("PersonalAccountPage","phone.number.element");
    String countryCodeElement= property.getProperty("PersonalAccountPage","country.code.element");
    String passwordElement= property.getProperty("PersonalAccountPage","password.element");
    String agreementElement= property.getProperty("PersonalAccountPage","agreement.element");
    String createElement= property.getProperty("PersonalAccountPage","create.element");
    public PersonalAccountPage(WebDriver driver){
        this.driver=driver;
    }
    public PersonalAccountPage clickPhoneNumber(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath(clickPhoneNumberElement),
                Duration.ofSeconds(100));
        driver.findElement(By.xpath(clickPhoneNumberElement)).click();
        return this;
    }

    public PersonalAccountPage setPhoneNumber(String phoneNumber){
        TestApp.getInstance().waitUntilNextElementAppears(By.name(phoneNumberElement),
                Duration.ofSeconds(100));
        driver.findElement(By.name(phoneNumberElement)).sendKeys(phoneNumber);
        return this;
    }

    public PersonalAccountPage setPassword(String password){
        TestApp.getInstance().waitUntilNextElementAppears(By.name(passwordElement),
                Duration.ofSeconds(100));
        driver.findElement(By.name(passwordElement)).sendKeys(password);
        return this;
    }

    public PersonalAccountPage clickAgree(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath(agreementElement),
                Duration.ofSeconds(1000));
        driver.findElement(By.xpath(agreementElement)).click();
        return this;
    }

    public SecurityVerificationPage create(){
        TestApp.getInstance().waitUntilNextElementAppears(By.id(createElement),
                Duration.ofSeconds(100));
        driver.findElement(By.id(createElement)).click();
        return new SecurityVerificationPage(driver);
    }

    public PopUpPage selectCountry(){
        driver.findElement(By.xpath(countryCodeElement)).click();
        return new PopUpPage(driver);
    }
}
