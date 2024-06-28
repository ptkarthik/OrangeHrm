package services;

import driver.DriverCreator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utilitiespackage.BasicUtilities;

import java.io.FileNotFoundException;
import java.time.Duration;

public class LoginPageServices extends BaseServices {

    LoginPage loginPage = new LoginPage();
    BasicUtilities basicUtilities = new BasicUtilities();

    public void loginToHomePage(String userName, String password) throws FileNotFoundException {
        WebDriverWait webDriverWait = new WebDriverWait(DriverCreator.getDriver(), Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginPage.getUserName()));
        loginPage.getUserName().sendKeys(userName);
        loginPage.getPassword().sendKeys(password);
        basicUtilities.clickWithJs(loginPage.getLoginBtn());
    }


}
