package globalsources.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyFileReader;
import utils.TestApp;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    PropertyFileReader property=new PropertyFileReader();
    String myAccountElement= property.getProperty("HomePage","my.account.element");
    String buyerCenterElement= property.getProperty("HomePage","buyer.center.element");

    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    public HomePage myAccount(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath(myAccountElement),
                Duration.ofSeconds(1000));
        driver.findElement(By.xpath(myAccountElement)).click();
        return this;
    }

    public BuyerCenterPage buyerCenter(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath(buyerCenterElement),
                Duration.ofSeconds(1000));
        driver.findElement(By.xpath(buyerCenterElement)).click();
        return new BuyerCenterPage(driver);
    }
}
