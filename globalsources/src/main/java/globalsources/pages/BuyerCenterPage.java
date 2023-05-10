package globalsources.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyFileReader;
import utils.TestApp;

import java.time.Duration;

public class BuyerCenterPage {
    WebDriver driver;
    PropertyFileReader property=new PropertyFileReader();
    String securitySettingsElement= property.getProperty("BuyerCenterPage","security.settings.element");

    public BuyerCenterPage(WebDriver driver){
        this.driver=driver;
    }

    public SecuritySettingsPage securitySettings(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath(securitySettingsElement),
                Duration.ofSeconds(1000));
        driver.findElement(By.xpath(securitySettingsElement)).click();
        return new SecuritySettingsPage(driver);
    }
}
