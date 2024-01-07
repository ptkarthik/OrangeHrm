package IndustryStandard;

import driver.DriverCreator;
import listeners.BasicListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
@Listeners(BasicListeners.class)
public class MyFirstTest extends BaseTest {

    @Test
    public void FirstTest() throws InterruptedException, FileNotFoundException {
        Thread.sleep(5000);
        Assert.assertFalse(new MyFirstTest().getUrlText(DriverCreator.getDriver()));
        loginWithValidCredentails();
    }


}
