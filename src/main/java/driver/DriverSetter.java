package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
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
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver returnEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver returnFireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
