package IndustryStandard;

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

public class BaseTest {


    @Parameters("browser")
    @BeforeMethod
    public void Setup(@Optional String browser) {
        DriverCreator.setDriver(DriverSetter.selectDriverType(DriverDetails.valueOf(browser)));
        WebDriver driver = DriverCreator.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }


    @AfterMethod
    public void tearDown() {
        DriverCreator.getDriver().quit();
    }

    public void loginWithValidCredentails(String userName, String password) throws FileNotFoundException {
        LoginPageServices loginPageServices = new LoginPageServices();
        loginPageServices.loginToHomePage(userName,password);
    }

    public boolean getUrlText(WebDriver driver) {
        String url = driver.getTitle();
        System.out.println(url);
        return url.equalsIgnoreCase("OrangeHRM");
    }
}
