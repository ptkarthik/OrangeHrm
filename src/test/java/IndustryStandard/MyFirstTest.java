package IndustryStandard;

import driver.DriverCreator;
import listeners.BasicListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class MyFirstTest extends BaseTest {

    @Test(retryAnalyzer = BasicListeners.class)
    public void FirstTest() throws InterruptedException, FileNotFoundException {
        Assert.assertTrue(new MyFirstTest().getUrlText(DriverCreator.getDriver()));
        loginWithValidCredentails();
    }
}
