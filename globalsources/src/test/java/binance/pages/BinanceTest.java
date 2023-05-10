package binance.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestApp;

public class BinanceTest {
    WebDriver driver;
    BinanceLoginPage binanceLoginPage;
    SignUpPage signUpPage;
    PersonalAccountPage personalAccountPage;
    SecurityVerificationPage securityVerificationPage;

    @BeforeMethod
    public void setUp() {
        TestApp.getInstance().openBrowser();
        TestApp.getInstance().navigateToURL();
        driver = TestApp.getInstance().getDriver();

        binanceLoginPage=new BinanceLoginPage(driver);
        signUpPage=binanceLoginPage.createAccount();

        personalAccountPage=signUpPage.signUp();
        personalAccountPage=personalAccountPage.clickPhoneNumber();
    }

    @AfterMethod
    public void tearDown() {
        TestApp.getInstance().closeBrowser();
    }

    @Test
    public void testBangladesh() {
        securityVerificationPage=personalAccountPage
                .selectCountry().selectBangladesh()
                .setPhoneNumber("1988733870")
                .setPassword("Piyasiri22")
                .clickAgree()
                .create();
    }

    @Test
    public void testTimor() {
        securityVerificationPage=personalAccountPage
                .selectCountry().selectTimor()
                .setPhoneNumber("73426696")
                .setPassword("Piyasiri22")
                .clickAgree()
                .create();
    }

}
