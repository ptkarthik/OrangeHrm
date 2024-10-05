package driver;


import org.openqa.selenium.WebDriver;

public class DriverCreator {

    private DriverCreator() {

    }

    public static WebDriver getDriver() {
        return localThreadDriver.get();
    }

    public static void setDriver(WebDriver driverRef) {
        localThreadDriver.set(driverRef);
    }

    private static ThreadLocal<WebDriver> localThreadDriver = new ThreadLocal<>();

}
