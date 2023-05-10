package binance.pages;

import org.openqa.selenium.WebDriver;
import utils.PropertyFileReader;

public class SecurityVerificationPage {
    WebDriver driver;
    PropertyFileReader property=new PropertyFileReader();
    public SecurityVerificationPage(WebDriver driver){
        this.driver=driver;
    }
}
