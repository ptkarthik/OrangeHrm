package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetter {


    public static WebDriver selectDriverType(DriverDetails driverDetails) throws MalformedURLException {
        switch (driverDetails) {
            case CHROME -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                return new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
            }

            case FIREFOX -> {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                return new RemoteWebDriver(new URL("http://localhost:4444"), firefoxOptions);

            }
            case EDGE -> {
                EdgeOptions edgeOptions = new EdgeOptions();
                return new RemoteWebDriver(new URL("http://localhost:4444"), edgeOptions);
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
