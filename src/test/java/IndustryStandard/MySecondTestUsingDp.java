package IndustryStandard;

import driver.DriverCreator;
import listeners.BasicListeners;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.HomePageServices;

import java.io.FileNotFoundException;

public class MySecondTestUsingDp extends BaseTest {


    @Test(retryAnalyzer = BasicListeners.class)
    public void SecondTest() throws InterruptedException, FileNotFoundException {
        Assert.assertTrue(new MySecondTestUsingDp().getUrlText(DriverCreator.getDriver()));
        loginWithValidCredentails();
        HomePageServices homePageServices = new HomePageServices();
        homePageServices.navigateToRightTopMenu();
    }


}
