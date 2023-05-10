package binance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyFileReader;
import utils.TestApp;

import java.time.Duration;

public class PopUpPage {
        WebDriver driver;
        PropertyFileReader property = new PropertyFileReader();
        String bangladeshElement= property.getProperty("PopUpPage","bangladesh.element");
        String timorElement= property.getProperty("PopUpPage","timor.element");

        public PopUpPage(WebDriver driver) {
            this.driver = driver;
        }

        public PersonalAccountPage selectBangladesh() {
            TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@id=\"880-BD-Bangladesh (বাংলাদেশ)\"]/div/div/div/div[1]/div[2]"),
                    Duration.ofSeconds(300));
            driver.findElement(By.xpath("//*[@id=\"880-BD-Bangladesh (বাংলাদেশ)\"]/div/div/div/div[1]/div[2]")).click();

            return new PersonalAccountPage(driver);
        }

    public PersonalAccountPage selectTimor() {
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@id=\"670-TL-Timor-Leste\"]/div/div/div/div[1]/div[2]"),
                Duration.ofSeconds(300));
        driver.findElement(By.xpath("//*[@id=\"670-TL-Timor-Leste\"]/div/div/div/div[1]/div[2]")).click();
        return new PersonalAccountPage(driver);
    }

}