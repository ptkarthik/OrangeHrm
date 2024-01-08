package IndustryStandard;

import DataProviders.DataProviders;
import driver.DriverCreator;
import listeners.BasicListeners;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class MyFirstTest extends BaseTest {

    @Test(retryAnalyzer = BasicListeners.class, dataProvider = "sendingData", dataProviderClass = DataProviders.class)
    public void FirstTest(String userName, String password) throws InterruptedException, FileNotFoundException {
        Assert.assertTrue(new MyFirstTest().getUrlText(DriverCreator.getDriver()));
        loginWithValidCredentails(userName, password);
    }


}
