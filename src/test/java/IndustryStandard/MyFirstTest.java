package IndustryStandard;

import DataProviders.DataProviders;
import driver.DriverCreator;
import listeners.BasicListeners;
import org.apache.log4j.LogManager;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class MyFirstTest extends BaseTest {


    @Test(dataProvider = "sendingData",dataProviderClass = DataProviders.class)
    public void FirstTest(String userName, String password) throws InterruptedException, FileNotFoundException {
        LogManager.getLogger(MyFirstTest.class);
        Assert.assertTrue(new MyFirstTest().getUrlText(DriverCreator.getDriver()));
        loginWithValidCredentails(userName, password);
    }


}
