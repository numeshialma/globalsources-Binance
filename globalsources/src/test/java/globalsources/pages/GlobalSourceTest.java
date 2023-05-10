package globalsources.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestApp;

public class GlobalSourceTest {
    WebDriver driver;
    LoginPage loginPage;
    SignInPage signInPage;
    HomePage homePage;
    BuyerCenterPage buyerCenterPage;
    SecuritySettingsPage securitySettingsPage;

    @BeforeMethod
    public void setUp() {
        TestApp.getInstance().openBrowser();
        TestApp.getInstance().navigateToURL();

        driver = TestApp.getInstance().getDriver();

        loginPage=new LoginPage(driver);

        signInPage=loginPage
                .setEmail("nethpiyasiri2027@gmail.com")
                .next();

        homePage=signInPage
                .setPassword("r6GjB!RX_mRx:8F")
                .signIn();

        buyerCenterPage=homePage.myAccount().buyerCenter();
        securitySettingsPage=buyerCenterPage.securitySettings();

    }
    @Test
    public void testGlobalSource() {
        securitySettingsPage=new SecuritySettingsPage(driver);
        securitySettingsPage=securitySettingsPage
                .activated()
                .setCountryCode("880")
                .setPhoneNumber("1996724914")
                .send();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
