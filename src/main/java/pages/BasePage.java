package pages;

import driver.DriverCreator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;

    public BasePage() {
        this.driver = DriverCreator.getDriver();
        PageFactory.initElements(driver, this);
    }
}
