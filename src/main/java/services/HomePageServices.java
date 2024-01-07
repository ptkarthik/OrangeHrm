package services;

import configuration.PropLoader;
import driver.DriverCreator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import utilitiespackage.BasicUtilities;

import java.io.FileNotFoundException;
import java.time.Duration;

public class HomePageServices extends BaseServices {

    HomePage homePage = new HomePage();
   BasicUtilities basicUtilities = new BasicUtilities();

    public void loginToHomePage() throws FileNotFoundException {
        WebDriverWait webDriverWait = new WebDriverWait(DriverCreator.getDriver(), Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(homePage.getUserName()));
        homePage.getUserName().sendKeys(PropLoader.loadProperties().getProperty("username"));
        homePage.getPassword().sendKeys(PropLoader.loadProperties().getProperty("password"));
        basicUtilities.clickWithJs(homePage.getLoginBtn());
    }


}
