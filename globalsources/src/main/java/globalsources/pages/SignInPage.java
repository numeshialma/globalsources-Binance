package globalsources.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyFileReader;
import utils.TestApp;

import java.time.Duration;

public class SignInPage {
    WebDriver driver;
    PropertyFileReader property=new PropertyFileReader();
    String passwordElement= property.getProperty("SignInPage","password.element");
    String signInButtonElement= property.getProperty("SignInPage","sign.in.button.element");

    public SignInPage(WebDriver driver){
        this.driver=driver;
    }
    public SignInPage setPassword(String password){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath(passwordElement),
                Duration.ofSeconds(1000));
        driver.findElement(By.xpath(passwordElement)).sendKeys(password);
        return this;
    }

    public HomePage signIn(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath(signInButtonElement),
                Duration.ofSeconds(1000));
        driver.findElement(By.xpath(signInButtonElement)).click();
        return new HomePage(driver);
    }
}
