package binance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyFileReader;
import utils.TestApp;

import java.time.Duration;

public class SignUpPage {

    WebDriver driver;
    PropertyFileReader property=new PropertyFileReader();
    String signUpElement= property.getProperty("SignUpPage","sign.up.element");

    public SignUpPage(WebDriver driver){
        this.driver=driver;
    }
    public PersonalAccountPage signUp(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath(signUpElement),
                Duration.ofSeconds(100));
        driver.findElement(By.xpath(signUpElement)).click();
        return new PersonalAccountPage(driver);
    }

}
