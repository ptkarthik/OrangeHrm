package IndustryStandard;

import configuration.PropLoader;
import driver.DriverCreator;
import driver.DriverDetails;
import driver.DriverSetter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import services.HomePageServices;

import java.io.FileNotFoundException;
import java.util.Properties;

public class BaseTest {


    @Parameters("browser")
    @BeforeMethod
    public void Setup(String browser) {
        DriverCreator.setDriver(DriverSetter.selectDriverType(DriverDetails.valueOf(browser)));
        WebDriver driver = DriverCreator.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }


    @AfterMethod
    public void tearDown() {
        DriverCreator.getDriver().quit();
    }

    public void loginWithValidCredentails() throws FileNotFoundException {
        HomePageServices homePageServices= new HomePageServices();
        homePageServices.loginToHomePage();
    }

    public boolean getUrlText(WebDriver driver) {
        String url = driver.getTitle();
        System.out.println(url);
        return url.equalsIgnoreCase("OrangeHRM");
    }

}
