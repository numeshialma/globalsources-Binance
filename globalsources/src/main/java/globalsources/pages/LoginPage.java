package globalsources.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyFileReader;
import utils.TestApp;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    PropertyFileReader property=new PropertyFileReader();
    String emailElement= property.getProperty("LoginPage","email.element");
    String nextButtonElement= property.getProperty("LoginPage","next.button.element");
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public LoginPage setEmail(String email){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath(emailElement),
                Duration.ofSeconds(1000));
        driver.findElement(By.xpath(emailElement)).sendKeys(email);
        return this;
    }

    public SignInPage next(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath(nextButtonElement),
                Duration.ofSeconds(1000));
        driver.findElement(By.xpath(nextButtonElement)).click();
        return new SignInPage(driver);
    }

}
