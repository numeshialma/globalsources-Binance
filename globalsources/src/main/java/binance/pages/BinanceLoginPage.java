package binance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyFileReader;
import utils.TestApp;

import java.time.Duration;

public class BinanceLoginPage {

    WebDriver driver;
    PropertyFileReader property=new PropertyFileReader();
    String createAccountElement= property.getProperty("BinanceLoginPage","create.account.element");

    public BinanceLoginPage(WebDriver driver){
        this.driver=driver;
    }
    public SignUpPage createAccount(){
        TestApp.getInstance().waitUntilNextElementAppears(By.id(createAccountElement),
                Duration.ofSeconds(100));
        driver.findElement(By.id(createAccountElement)).click();
        return new SignUpPage(driver);
    }
}
