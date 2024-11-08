package IndustryStandard;

import configuration.SeleniumGridManager;
import driver.DriverCreator;
import driver.DriverDetails;
import driver.DriverSetter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import services.LoginPageServices;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class BaseTest {


    @Parameters("browser")
    @BeforeMethod
    public void Setup(@Optional("CHROME") String browser) throws MalformedURLException {
        SeleniumGridManager seleniumGridManager = new SeleniumGridManager();
        DriverCreator.setDriver(DriverSetter.selectDriverType(DriverDetails.valueOf(browser)));
        WebDriver driver = DriverCreator.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }


    @AfterMethod
    public void tearDown() {
        DriverCreator.getDriver().quit();
    }

    public void loginWithValidCredentails() throws FileNotFoundException {
        LoginPageServices loginPageServices = new LoginPageServices();
        loginPageServices.loginToHomePage();
    }

    public boolean getUrlText(WebDriver driver) {
        String url = driver.getTitle();
        System.out.println(url);
        return url.equalsIgnoreCase("OrangeHRM");
    }

}
