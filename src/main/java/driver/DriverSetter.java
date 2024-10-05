package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetter {


    public static WebDriver selectDriverType(DriverDetails driverDetails) {
        switch (driverDetails) {
            case CHROME -> {
                return returnChromeDriver();
            }

            case FIREFOX -> {
                return returnFireFoxDriver();

            }
            case EDGE -> {
                return returnEdgeDriver();

            }
            default -> {
                throw new IllegalArgumentException("Invalid Driver: " + driverDetails);
            }
        }
    }


    public static WebDriver returnChromeDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver returnEdgeDriver() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver returnFireFoxDriver() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
