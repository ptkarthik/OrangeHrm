package IndustryStandard;

import DataProviders.DataProviders;
import driver.DriverCreator;
import listeners.BasicListeners;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import services.HomePageServices;

import java.io.FileNotFoundException;

public class MySecondTestUsingDp extends BaseTest {

    @Test(retryAnalyzer = BasicListeners.class, dataProvider = "sendingData",dataProviderClass = DataProviders.class)

    public void SecondTest(String userName, String password) throws InterruptedException, FileNotFoundException {
        Assert.assertTrue(new MySecondTestUsingDp().getUrlText(DriverCreator.getDriver()));
        loginWithValidCredentails(userName,password);
        HomePageServices homePageServices = new HomePageServices();
        homePageServices.navigateToRightTopMenu();
    }


}
